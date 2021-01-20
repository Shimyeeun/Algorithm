package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D1_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			if(num1>num2) {
				System.out.println("#"+t+" >");
			}
			else if(num1==num2) {
				System.out.println("#"+t+" =");
			}
			else {
				System.out.println("#"+t+" <");
			}
		}

	}

}
