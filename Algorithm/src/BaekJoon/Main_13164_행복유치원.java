package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_13164_행복유치원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		int[] diff=new int[N-1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			diff[i]=arr[i+1]-arr[i];
		}
		
		Arrays.sort(diff);
		int ans=0;
		for(int i=0;i<N-K;i++) {
			ans+=diff[i];
		}
		System.out.println(ans);
	}

}
