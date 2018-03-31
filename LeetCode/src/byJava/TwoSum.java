package byJava;

/*题目：
 * #1 两数之和
 */

/*描述：
 * 给定一个整数数列，找出其中和为特定值的那两个数。
你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */

/*思路：
 * 1、定义一个数组arr[2]，两个角标index1，index2；
 * 2、通过一个两层的嵌套循环，一共进行length-1次查找，每次查找进行length-x-1次比较
//3、当查找到的两数之和不等于target时，内层角标+1（与下一个数相相加进行判断）
 * 4、当一个外层的角标与内层除了它自己以及它之前的数都做过判断后，外层角标+1
 * 5、当找到对应的两个数时，两个角标分别赋值给index1，index2
 * 6、如果数组中找不到这两个数，index1和index2则返回-1
 */

public class TwoSum {
	public static void main(String[] args){		
		int[] nums = new int[]{2,7,11,15};
		int[] arr = new int[2];
		arr = twoSum(nums,9);		
		System.out.println("[" + arr[0] + "," + arr[1] + "]");
	}
	
    public static int[] twoSum(int[] nums, int target) {
        int[] arr  = new int[2];
        int index1 = -1;
        int index2 = -1;
       
        for(int x=0; x<nums.length-1; x++) {
        	for(int y=x+1; y<nums.length; y++) {
        		if(nums[x] + nums[y] == target) {
        			index1 = x;
        			index2 = y;
        		}    			
        	}
        } 
        arr[0] = index1;
        arr[1] = index2;      
        return arr;
        
    }
}
