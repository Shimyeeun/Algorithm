package SWEA;
import java.io.*;
public class Solution_D1_2019_더블더블 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int ans=1;
		
		System.out.print(ans+" ");
		for(int i=1;i<=n;i++) {
			ans*=2;
			System.out.print(ans+" ");
		}
		
	}

}
