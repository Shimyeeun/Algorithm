package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D1_2072_홀수만더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int sum=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<10;i++) {
				int num=Integer.parseInt(st.nextToken());
				if(num%2==1) {
					sum+=num;
				}
				
			}
			
			System.out.println("#"+t+" "+sum);
			
		}
		
		
	}

}
