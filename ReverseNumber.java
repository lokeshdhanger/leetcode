package numbers;

public class ReverseNumber {
	
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(120));
		System.out.println(reverse(-123));
		System.out.println(reverse(1534236469));
		
	}
	
    public static int reverse(int x) {
        Integer rev=0;
        boolean flag = false;
        if(x<0) {
        	flag=true;
        	x=-x;
        }
        Integer prev_rev=0;
        while(x!=0){
        	int current=x%10;
            rev=current + rev*10;
            if (((rev-current)/10) != prev_rev) {
				return 0;
			}
            prev_rev = rev;
            x=x/10;
        }
        return flag?-rev:rev;
    }

}
