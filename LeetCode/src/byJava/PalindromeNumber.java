package byJava;


/*题目：
 * #9 判断一个数是否为回文数
 */


/*思路：
 * 1、先判断该数是否小于0或在0和10之前，是则直接return false（先排除简单的特定情况）
 * 2、把Int类型的 x 转换为String类型 ，并计算出String的长度len
 * 3、定义一个数组arr，长度为len
 * 4、把数 x 依次存入数组arr（这个操作是逆着存储的，但并不妨碍接下来的判断）
 * 5、循环判断从数组arr的arr[0]和arr[len-1]是否不相等(两个index分别往中间靠)，循环（len/2）次，如果不相等，则立即return false
 * 6、如果完成循环，则return true
 */
 
public class PalindromeNumber {
	public static void main(String[] args){
		int a = 123321;
 		System.out.println(isPalindrome(a));
	} 
	
    public static boolean isPalindrome(int x) {
    	
    	if(x<0 || (x%10 == 0 && x!= 0)) {
    		return false;
    	}
    	
		int len = String.valueOf(x).length();
    	int[] arr = new int[len];
    	int temp;
    	
		arr[len-1] = (int) (x/Math.pow(10, len-1));
		temp = (int) (x%Math.pow(10, len-1));
    			
    	for(int i =  len-2; i >= 0 ; i--) {
    		arr[i] = (int) (temp/Math.pow(10, i));
    		temp = (int) (temp%Math.pow(10, i));
    	}
    	
    	for(int j = 0; j < len/2; j++) {
    		if(arr[j] != arr[len-j-1])
    		   		return false;
    	}
		return true;
    }
   
}
