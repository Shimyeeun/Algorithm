package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_11047_동전0 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		int cnt=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int amount=K;
		for(int i=N-1;i>=0;i--) {
			if(arr[i]>amount && amount%arr[i]!=0) continue;
			cnt+=(amount/arr[i]);
			amount-=(amount/arr[i]*arr[i]);
			if(amount==0) break;
		}
		
		System.out.println(cnt);
	}

}
