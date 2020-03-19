package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval {
	int left;
	int right;
	public Interval(int left, int right) {
		this.left=left;
		this.right=right;
	}
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(n) as stack requires space.
 * 
 * @author xarvis
 *
 */
public class MergeIntervals {
	
	public static void main(String[] args) {
		
		Interval[] arr = new Interval[4]; 
		arr[0] = new Interval(1, 3);
		arr[1] = new Interval(2, 4);
		arr[2] = new Interval(5, 9);
		arr[3] = new Interval(8, 10);
		
		System.out.println("given intervals: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("["+arr[i].left+","+arr[i].right+"]");
		}
		
		
		System.out.println("merged intervals");
		mergeIntervals(arr);
		
		System.out.println("*****************************************");
		
		int arr2[][] = {{1,3},{2,4},{5,9}, {8,10}};

		System.out.println("given intervals");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("{"+arr2[i][0]+","+arr2[i][1]+"}");
		}
		mergeIntervals(arr2);
		
	}
	
	private static void mergeIntervals(int arr[][]) {
		
		if (arr==null || arr.length<=0) {
			return;
		}
		
		Stack<int[]> s = new Stack<>();
		s.push(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			int[] top = s.peek();
			if (top[1]>=arr[i][0]) {
				top[1]=arr[i][1];
				s.pop();
				s.push(top);
				
			} else if(top[1]<arr[i][0]) {
				s.push(arr[i]);
			}
		}
		
		while (!s.isEmpty()) {
			int [] pop = s.pop();
			System.out.println("["+pop[0] +", "+ pop[1]+"]");
		}
	
	}

	private static void mergeIntervals(Interval[] arr) {
		
		if (arr==null || arr.length<=0) {
			return;
		}
		
		//sort elements
		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval arg1, Interval arg2) {
				return arg1.left-arg1.left;
			}
		});
		
		Stack<Interval> stack = new Stack<>();
		stack.push(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			Interval top = stack.peek();
			
			if (top.right<arr[i].left) {
				stack.push(arr[i]);
			} else if(top.right<arr[i].right) {
				top.right = arr[i].right;
				stack.pop();
				stack.push(top);
			}
		}
		
		while (!stack.isEmpty()) {
			Interval pop = stack.pop();
			System.out.println("["+pop.left +", "+ pop.right+"]");
		}
		
	}

}
