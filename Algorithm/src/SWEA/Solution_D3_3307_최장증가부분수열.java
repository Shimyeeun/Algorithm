package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			
			int[] arr=new int[N];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int[] LSI=new int[N];
			int max=0;
			for(int i=0;i<N;i++) {
				LSI[i]=1;
				
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i] && LSI[i]<LSI[j]+1 ) {
						LSI[i]=LSI[i]+1;
					}
				}
				if(max<LSI[i]) {
					max=LSI[i];
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
