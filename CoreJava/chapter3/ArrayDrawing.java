import java.util.*;


public class ArrayDrawing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("how large is this array(size):");
		int n = in.nextInt();
		System.out.println("how many numbers to pick:");
		int k = in.nextInt();
		
		int[] numbers = new int[n];
		for(int i=0; i <numbers.length; i++) {
			numbers[i] = i;
		}
		int[] result = new int[k];
		for(int i=0;i<result.length;i++) {
			int r = (int)(Math.random()*n);
			result[i]=numbers[r];
			numbers[r]=numbers[n-1];
			n--;
		}
		Arrays.sort(result);
		for(int r: result) {
		System.out.println(r);
		}
	}
	
}
