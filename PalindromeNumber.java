package numbers;

public class PalindromeNumber {
	
	public static void main(String[] args) {
	
		System.out.println(isPalindromeNumber(121));
		System.out.println(isPalindromeNumber(-121));
		System.out.println(isPalindromeNumber(10));
		System.out.println(isPalindromeNumber(234565432));
		
	}

	public static boolean isPalindromeNumber(int num) {
		int rev=0;
		int prev_rev=0;
		int x=num;
		if(num<0) {
			return false;
		}
		while (num!=0) {
			int current = num%10;
			rev=rev*10 + current;
			if ((rev-current)/10 != prev_rev) {
				return false;
			}
			prev_rev=rev;
			num=num/10;
		}
		if (rev==x) {
			return true;
		} else {
			return false;
		}
		
	}
}
