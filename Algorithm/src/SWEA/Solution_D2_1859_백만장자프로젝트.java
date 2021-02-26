package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D2_1859_백만장자프로젝트 {
	
	static int N;
	static long money;
	static int[] arr;
	public static void count(int start, int idx) {
		int buy=0;
		int cnt=0;
		for(int i=start;i<idx;i++) {
			buy+=arr[i];
			cnt++;
		}
		
		if(idx>=1) {
			money+=arr[idx]*cnt-buy;
		}
		
		else {
			idx++;
		}
		
		if(idx==N-1) {
			return;
		}else {
			maxfind(idx+1);
		}
		
		
	}
	
	public static void maxfind(int start) {
		int max=0,maxidx=0;
		for(int i=start;i<N;i++) {
			if(arr[i]>max) {
				max=arr[i];
				maxidx=i;
			}			
		}
		
		count(start,maxidx);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			money=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			maxfind(0);
			
			sb.append("#"+t+" "+money+"\n");
			
			
		}
		
		System.out.println(sb.toString());

	}

}
