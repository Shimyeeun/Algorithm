package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D1_2068_최대수구하기{

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int max=0;
			for(int i=0;i<10;i++) {
				int num=Integer.parseInt(st.nextToken());
				if(num>max) {
					max=num;
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}
