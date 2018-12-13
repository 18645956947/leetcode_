
 
/**
 * ���ߣ� ���л���http://blog.csdn.net/zhongqi2513
 * ���ڣ� 2017��6��29�� ����8:21:03 
 * 
 * ����: MapReduce�����ţ�WordCount���ӳ��� 
 */
public class WordCountMR {
 
	/**
	 * ��main�����Ǹ�mapreduce�������е���ڣ�������һ��Job������������������ʱ����Ҫ�ĺܶ������
	 * ���磬ָ�����ĸ������Ϊ���ݶ�ȡ�������ݽ������� ָ�����ĸ�����Ϊmap�׶ε�ҵ���߼��࣬�ĸ�����Ϊreduce�׶ε�ҵ���߼���
	 * ָ��wordcount job�����jar������·�� .... �Լ�����������Ҫ�Ĳ���
	 */
	public static void main(String[] args) throws Exception {
		// ָ��hdfs��صĲ���
		Configuration conf = new Configuration();
		
		// �ֶ����ã���MapReduce�����ȡ������������HDFS��Ⱥ
		conf.set("fs.defaultFS", "hdfs://hadoop02:9000");
		// �������г�����û���hadoop�û������ǰ�װhadoop��Ⱥ���û�������ó�����Hadoop��Ⱥ��ʹ��hadoop�û��������У������ȥ��
		System.setProperty("HADOOP_USER_NAME", "hadoop");
		
		/**
		 * ���ϵ�������Ϣ����ʵ�ϣ���ʵ����ҵ���������У�Ҳ����ʹ��conf.addResource�������м��ء�
		 * ��Ȼ��������ļ���������core/hdfs/yarn/mapred-site/default.xml�Ļ��� ��ô���Զ����صġ�
		 */
//		conf.addResource("hadoop_config/core-site.xml");
//		conf.addResource("hadoop_config/hdfs-site.xml");
 
		// �������MR�����������ض���YARN��Ⱥ֮�ϣ������ʹ��һ�´��룬Ȼ��������Ϣ���ڰ�װ��Ⱥ�������ļ��ж������õ�
		// conf.set("mapreduce.framework.name", "yarn");
		// conf.set("yarn.resourcemanager.hostname", "hadoop04");
 
		// ͨ��Configuration�����ȡJob���󣬸�job�������֯���еĸ�MapReduce�������еĸ������
		Job job = Job.getInstance(conf);
 
		// ����jar������·��
		job.setJarByClass(WordCountMR.class);
 
		// ָ��mapper���reducer��
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
 
		/**
		 * ָ��maptask���������
		 * Mapper������key-value���ͣ���MapReduce��ܾ����� Ĭ������¾��� LongWritable��Text����
		 * 
		 * ���� mapTask�����key-value���ͣ���reduceTask�����key-value����һ�£���ô���������������Բ�������
		 */
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
 
		/**
		 * ָ��reducetask���������
		 * ���reduceTask������key-value���;��� mapTask�����key-value���͡����Բ���Ҫָ��
		 */
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
 
		// Ϊjobָ���������ݵ������������ݵ��������������������Ĭ�ϵģ����Բ�ָ��Ҳ��OK��
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
 
		// Ϊ��mapreduce�����ƶ�Ĭ�ϵ����ݷ��������Ĭ���� HashPartitioner.class
		job.setPartitionerClass(HashPartitioner.class);
 
		/**
		 * ָ����mapreduce�������ݵ���������·��:
		 * inputPathĿ¼�������ļ���Ҳ������Ŀ¼
		 * outputPath·�������ǲ����ڵ�Ŀ¼
		 */
		Path inputPath = new Path("D:\\bigdata\\wordcount\\input\\wc.txt");
		Path outputPath = new Path("D:\\bigdata\\wordcount\\output");
 
		// ���ø�MapReduce�����ReduceTask�ĸ���
		// job.setNumReduceTasks(3);
 
		// �öδ����������ж����·�����ڲ����ڣ����ھ�ɾ������Ȼ����������������
		FileSystem fs = FileSystem.get(conf);
		if (fs.exists(outputPath)) {
			fs.delete(outputPath, true);
		}
 
		// ����wordcount���������·��
		FileInputFormat.setInputPaths(job, inputPath);
		// ����wordcount��������·��
		FileOutputFormat.setOutputPath(job, outputPath);
 
		// job.submit();
		// ����ύ����(verbose����ֵ ����Ҫ��Ҫ�����н�����Ϣ������û�)
		boolean waitForCompletion = job.waitForCompletion(true);
		// ���̳߳������MapReduce��������н���ɹ�����˳���
		System.exit(waitForCompletion ? 0 : 1);
	}
 
	/**
	 * Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
	 * 
	 * KEYIN ��ָ��ܶ�ȡ�������ݵ�key�����ͣ���Ĭ�ϵ�InputFormat�£�������key��һ���ı�����ʼƫ����������key��������Long
	 * VALUEIN ��ָ��ܶ�ȡ�������ݵ�value������,��Ĭ�ϵ�InputFormat�£�������value��һ���ı������ݣ�����value��������String
	 * KEYOUT ��ָ�û��Զ����߼��������ص�������key�����ͣ����û�ҵ���߼��������ڴ�wordcount�����У����������key�ǵ��ʣ�������String
	 * VALUEOUT ��ָ�û��Զ����߼��������ص�������value�����ͣ����û�ҵ���߼�����,�ڴ�wordcount�����У����������value�ǵ��ʵ�������������Integer
	 * 
	 * ���ǣ�String ��Long��jdk���Դ����������ͣ������л�ʱ��Ч�ʱȽϵͣ�hadoopΪ��������л�Ч�ʣ��Զ�����һ�����л����
	 * ���ԣ���hadoop�ĳ����У������������Ҫ�������л���д���̣��������紫�䣩����һ��Ҫ��ʵ����hadoop���л���ܵ���������
	 * 
	 * Long ----> LongWritable 
	 * String ----> Text 
	 * Integer ----> IntWritable 
	 * Null ----> NullWritable
	 */
	static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
 
		/**
		 * LongWritable key : ��key����value�����ı������ļ����е���ʼƫ����
		 * Text value �� ����MapReduce���Ĭ�ϵ����ݶ�ȡ���TextInputFormat��ȡ�ļ����е�һ���ı�
		 */
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
 
			// �зֵ���
			String[] words = value.toString().split(" ");
			for (String word : words) {
				// ÿ�����ʼ���һ�Σ�Ҳ���ǰѵ�����֯��<hello,1>������key-value������д��
				context.write(new Text(word), new IntWritable(1));
			}
		}
	}
 
	/**
	 * ���ȣ���ǰ��һ����Reducer��Ҳ�������������������Map�׶εĴ��������������Reduce�������
	 * reducetask�ڵ�����д��reduce����,reducetaskӦ���յ���ǰһ�׶Σ�map�׶Σ�������maptask����������е�һ����
	 * �����ݵ�key.hashcode%reducetask��==��reductask�ţ�������reducetaks���������ͱ����maptask���������һ��
	 * 
	 * reducetask����Щ�յ�kv������������ʱ���������������ǵ�reduce�����ģ� �Ƚ��Լ��յ������е�kv�԰���k���飨����k�Ƿ���ͬ��
	 * ��ĳһ��kv�еĵ�һ��kv�е�k����reduce������key����������һ��kv�����е�v��һ������������reduce�����ı���values
	 */
	static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
 
		/**
		 * Text key : mapTask�����keyֵ
		 * Iterable<IntWritable> values �� key��Ӧ��value�ļ��ϣ���keyֻ����ͬ��һ��key��
		 * 
		 * reduce��������keyֵ��ͬ��һ��key-value���л��ܼ���
		 */
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
 
			// �������
			int sum = 0;
			for (IntWritable v : values) {
				sum += v.get();
			}
			// ���ܵĽ���������
			context.write(key, new IntWritable(sum));
		}
	}
}
