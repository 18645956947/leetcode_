
 
/**
 * 作者： 马中华：http://blog.csdn.net/zhongqi2513
 * 日期： 2017年6月29日 下午8:21:03 
 * 
 * 描述: MapReduce出入门：WordCount例子程序 
 */
public class WordCountMR {
 
	/**
	 * 该main方法是该mapreduce程序运行的入口，其中用一个Job类对象来管理程序运行时所需要的很多参数：
	 * 比如，指定用哪个组件作为数据读取器、数据结果输出器 指定用哪个类作为map阶段的业务逻辑类，哪个类作为reduce阶段的业务逻辑类
	 * 指定wordcount job程序的jar包所在路径 .... 以及其他各种需要的参数
	 */
	public static void main(String[] args) throws Exception {
		// 指定hdfs相关的参数
		Configuration conf = new Configuration();
		
		// 手动设置，该MapReduce程序读取的数据来自于HDFS集群
		conf.set("fs.defaultFS", "hdfs://hadoop02:9000");
		// 设置运行程序的用户是hadoop用户，就是安装hadoop集群的用户。如果该程序在Hadoop集群中使用hadoop用户进行运行，则可以去掉
		System.setProperty("HADOOP_USER_NAME", "hadoop");
		
		/**
		 * 以上的配置信息，事实上，在实际企业生产环境中，也可以使用conf.addResource方法进行加载。
		 * 当然如果配置文件的名字是core/hdfs/yarn/mapred-site/default.xml的话。 那么会自动加载的。
		 */
//		conf.addResource("hadoop_config/core-site.xml");
//		conf.addResource("hadoop_config/hdfs-site.xml");
 
		// 如果想让MR程序运行在特定的YARN集群之上，则可以使用一下代码，然后，这两信息，在安装集群的配置文件中都有配置的
		// conf.set("mapreduce.framework.name", "yarn");
		// conf.set("yarn.resourcemanager.hostname", "hadoop04");
 
		// 通过Configuration对象获取Job对象，该job对象会组织所有的该MapReduce程序所有的各种组件
		Job job = Job.getInstance(conf);
 
		// 设置jar包所在路径
		job.setJarByClass(WordCountMR.class);
 
		// 指定mapper类和reducer类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
 
		/**
		 * 指定maptask的输出类型
		 * Mapper的输入key-value类型，由MapReduce框架决定， 默认情况下就是 LongWritable和Text类型
		 * 
		 * 假如 mapTask的输出key-value类型，跟reduceTask的输出key-value类型一致，那么，以上两句代码可以不用设置
		 */
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
 
		/**
		 * 指定reducetask的输出类型
		 * 如果reduceTask的输入key-value类型就是 mapTask的输出key-value类型。可以不需要指定
		 */
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
 
		// 为job指定输入数据的组件和输出数据的组件，以下两个参数是默认的，所以不指定也是OK的
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
 
		// 为该mapreduce程序制定默认的数据分区组件。默认是 HashPartitioner.class
		job.setPartitionerClass(HashPartitioner.class);
 
		/**
		 * 指定该mapreduce程序数据的输入和输出路径:
		 * inputPath目录可以是文件，也可以是目录
		 * outputPath路径必须是不存在的目录
		 */
		Path inputPath = new Path("D:\\bigdata\\wordcount\\input\\wc.txt");
		Path outputPath = new Path("D:\\bigdata\\wordcount\\output");
 
		// 设置该MapReduce程序的ReduceTask的个数
		// job.setNumReduceTasks(3);
 
		// 该段代码是用来判断输出路径存在不存在，存在就删除，虽然方便操作，但请谨慎
		FileSystem fs = FileSystem.get(conf);
		if (fs.exists(outputPath)) {
			fs.delete(outputPath, true);
		}
 
		// 设置wordcount程序的输入路径
		FileInputFormat.setInputPaths(job, inputPath);
		// 设置wordcount程序的输出路径
		FileOutputFormat.setOutputPath(job, outputPath);
 
		// job.submit();
		// 最后提交任务(verbose布尔值 决定要不要将运行进度信息输出给用户)
		boolean waitForCompletion = job.waitForCompletion(true);
		// 主线程程序根据MapReduce程序的运行结果成功与否退出。
		System.exit(waitForCompletion ? 0 : 1);
	}
 
	/**
	 * Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
	 * 
	 * KEYIN 是指框架读取到的数据的key的类型，在默认的InputFormat下，读到的key是一行文本的起始偏移量，所以key的类型是Long
	 * VALUEIN 是指框架读取到的数据的value的类型,在默认的InputFormat下，读到的value是一行文本的内容，所以value的类型是String
	 * KEYOUT 是指用户自定义逻辑方法返回的数据中key的类型，由用户业务逻辑决定，在此wordcount程序中，我们输出的key是单词，所以是String
	 * VALUEOUT 是指用户自定义逻辑方法返回的数据中value的类型，由用户业务逻辑决定,在此wordcount程序中，我们输出的value是单词的数量，所以是Integer
	 * 
	 * 但是，String ，Long等jdk中自带的数据类型，在序列化时，效率比较低，hadoop为了提高序列化效率，自定义了一套序列化框架
	 * 所以，在hadoop的程序中，如果该数据需要进行序列化（写磁盘，或者网络传输），就一定要用实现了hadoop序列化框架的数据类型
	 * 
	 * Long ----> LongWritable 
	 * String ----> Text 
	 * Integer ----> IntWritable 
	 * Null ----> NullWritable
	 */
	static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
 
		/**
		 * LongWritable key : 该key就是value该行文本的在文件当中的起始偏移量
		 * Text value ： 就是MapReduce框架默认的数据读取组件TextInputFormat读取文件当中的一行文本
		 */
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
 
			// 切分单词
			String[] words = value.toString().split(" ");
			for (String word : words) {
				// 每个单词计数一次，也就是把单词组织成<hello,1>这样的key-value对往外写出
				context.write(new Text(word), new IntWritable(1));
			}
		}
	}
 
	/**
	 * 首先，和前面一样，Reducer类也有输入和输出，输入就是Map阶段的处理结果，输出就是Reduce最后的输出
	 * reducetask在调我们写的reduce方法,reducetask应该收到了前一阶段（map阶段）中所有maptask输出的数据中的一部分
	 * （数据的key.hashcode%reducetask数==本reductask号），所以reducetaks的输入类型必须和maptask的输出类型一样
	 * 
	 * reducetask将这些收到kv数据拿来处理时，是这样调用我们的reduce方法的： 先将自己收到的所有的kv对按照k分组（根据k是否相同）
	 * 将某一组kv中的第一个kv中的k传给reduce方法的key变量，把这一组kv中所有的v用一个迭代器传给reduce方法的变量values
	 */
	static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
 
		/**
		 * Text key : mapTask输出的key值
		 * Iterable<IntWritable> values ： key对应的value的集合（该key只是相同的一个key）
		 * 
		 * reduce方法接收key值相同的一组key-value进行汇总计算
		 */
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
 
			// 结果汇总
			int sum = 0;
			for (IntWritable v : values) {
				sum += v.get();
			}
			// 汇总的结果往外输出
			context.write(key, new IntWritable(sum));
		}
	}
}
