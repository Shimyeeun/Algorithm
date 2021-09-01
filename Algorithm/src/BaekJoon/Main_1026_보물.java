package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1026_보물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[] arr1=new int[N];
		int[] arr2=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr1[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr2[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int ans=0;
		
		for(int i=0;i<N;i++) {
			int res=arr1[i]*arr2[N-1-i];
			ans+=res;
		}
		System.out.println(ans);
	}

}
