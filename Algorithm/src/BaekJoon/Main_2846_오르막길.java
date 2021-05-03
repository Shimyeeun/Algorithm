package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2846_오르막길 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr= new int[N];
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int now=0;
		int ans=0;
		if(N>1) {
			for(int i=0;i<N-1;i++) {
				if(arr[i]<arr[i+1]) {
					now+=(arr[i+1]-arr[i]);
					ans=Math.max(ans, now);
				}
				else {
					ans=Math.max(ans, now);
					now=0;
				}
				
			}
		}
		System.out.println(ans);
	}

}
