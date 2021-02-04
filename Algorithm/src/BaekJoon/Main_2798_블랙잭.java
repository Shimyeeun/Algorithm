package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2798_블랙잭 {

	static int N,M,ans;
	static int[] arr,sel;
	
	public static void combination(int cnt,int idx) {
		
		if(cnt==sel.length) {
			int sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			
			if(sum<=M) {
				ans=Math.max(sum, ans);
			}
			
			return;
		}
		
		for(int i=idx;i<N;i++) {
			sel[cnt]=arr[i];
			combination(cnt+1,i+1);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		sel=new int[3];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		combination(0,0);
		System.out.println(ans);

	}

}
