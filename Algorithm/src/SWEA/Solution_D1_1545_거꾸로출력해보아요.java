package SWEA;
import java.io.*;

public class Solution_D1_1545_거꾸로출력해보아요 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=n;i>=0;i--) {
			System.out.print(i+" ");
		}

	}

}
