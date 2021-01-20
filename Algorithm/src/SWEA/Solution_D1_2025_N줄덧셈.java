package SWEA;
import java.io.*;
public class Solution_D1_2025_N줄덧셈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		int sum=0;
		
		for(int i=1;i<=num;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
