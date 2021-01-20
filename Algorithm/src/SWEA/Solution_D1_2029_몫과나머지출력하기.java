package SWEA;
import java.io.*;
import java.util.*;
public class Solution_D1_2029_몫과나머지출력하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			System.out.println("#"+t+" "+a/b+" "+a%b );
		}
		
		
		
	}

}
