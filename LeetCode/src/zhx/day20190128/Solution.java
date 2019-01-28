package zhx.day20190128;

import java.awt.geom.Ellipse2D;

import javax.imageio.ImageTypeSpecifier;

/** 
* @author lenovo
* @date 2019年1月28日上午10:43:07 
* @Description: 
*/
/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class Solution extends VersionControl {
public int firstBadVersion(int n) {
 int l = 1;
 int mid = 0;
  int r = n;
  while(l<r){
      mid = l + (r-l)/2;
      if(isBadVersion(mid)){
          r = mid;
      }
      else{
          l = mid+1;
      }
      
  }
  return r;
}
}
 