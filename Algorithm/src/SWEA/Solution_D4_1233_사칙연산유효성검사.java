package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1233_사칙연산유효성검사 {
	
	static int N,ans;
	static String[] arr;
	static StringBuilder sb;
	
	public static void inorder(int v) {
		if(v>N) return;
		inorder(v*2);
		sb.append(arr[v]);
		inorder(v*2+1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new String[201];
			ans=1;
			sb=new StringBuilder();
			int check=1;
			int idx=1;
			while(idx<=N) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				idx=Integer.parseInt(st.nextToken());
				arr[idx]=st.nextToken();
				arr[idx*2]=st.nextToken();
				if(Integer.parseInt(arr[idx*2])==N) {
					while(idx<=N) {
						st=new StringTokenizer(br.readLine());
						idx=Integer.parseInt(st.nextToken());
						arr[idx]=st.nextToken();
						idx++;
					}
					break;
				}
				arr[idx*2+1]=st.nextToken();
				if(Integer.parseInt(arr[idx*2+1])==N) {
					while(idx<=N) {
						st=new StringTokenizer(br.readLine());
						idx=Integer.parseInt(st.nextToken());
						arr[idx]=st.nextToken();
						idx++;
					}
					break;
				}
				idx++;				
			}
			
			inorder(1);
			
			for(int i=0;i<sb.length();i++) {
				
				if(sb.charAt(i)=='+'||sb.charAt(i)=='-'||sb.charAt(i)=='*'||sb.charAt(i)=='/') {
					if(check==1) {
						ans=0;
						break;
					}
					check=1;
				} else {
					if(check==0) {
						ans=0;
						break;
					}
					check=0;
				}
				
			}
			System.out.println("#"+t+" "+ans);
	
		}

	}

}
