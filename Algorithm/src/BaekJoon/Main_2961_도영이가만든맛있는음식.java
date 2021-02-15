package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2961_도영이가만든맛있는음식 {

	static int N;
	static int[][] arr;
	static int[] sel;
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		arr=new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			sel=new int[i];
			combination(0,0,sel);
		}
		System.out.println(ans);

	}
	
	public static void combination(int cnt,int start,int[] sel) {
		if(cnt==sel.length) {
			int S=1;
			int B=0;
			for(int i=0;i<sel.length;i++) {
				S*=arr[sel[i]][0];
				B+=arr[sel[i]][1];
			}
			
			ans=Math.min(ans, Math.abs(S-B));
			return;
		}
		
		for(int i=start;i<arr.length;i++) {
			sel[cnt]=i;
			combination(cnt+1,i+1,sel);
		}
	}

}
