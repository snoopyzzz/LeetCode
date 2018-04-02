package byJava;


//题目：#9 判断一个数是否为回文数


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
 		System.out.println(new PalindromeNumber().isPalindrome(a));
	} 
	
    public boolean isPalindrome(int x) {
    	
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
   
    /*优解：
     * 
     * 思路：
     * 1、先通过log的方法计算出x的位数
     * 2、通过 %10（求余）算出最后一位数
     * 3、通过 /pow（10，i）算出第一位数
     * 4、判断第一位数和第二位是是否相同，如果不相同，立即return false
     * 5、如果两数相同，则进行进行循环
     * 6、通过x = (int) (x%Math.pow(10, i));清除第一位数
     * 7、通过x /= 10;  清除最后一位数
     * 8、i-=2
     * 
     * 优点：
     * 不用把整数存入数组中再进行比较
     * 
     */
    
    public boolean isPalindrome_2(int x) {
    	
    	if(x<0 || (x%10 == 0 && x!= 0)) {
    		return false;
    	}

    	int m = (int) Math.log10(x); //implies 10^m < x < 10^(m+1) 
    	int i=m;
    	while(i >= 0 ){ 
    		int a = x%10; // 得到最后一位数
    		int b = (int) (x/Math.pow(10, i)); // 得到第一位数
    		if(a != b) // 
    			return false;
    		x = (int) (x%Math.pow(10, i)); // 清除第一位数
    		x /= 10; // 清除最后一位数
    		i -= 2;
    	    } 
    	return true;
    }
    
}
