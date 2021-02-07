package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Integer[] arr=new Integer[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int time=0;
		int sum=0;
		for(int i=0;i<N;i++) {
			time=time+arr[i];
			sum+=time;
		}
		System.out.println(sum);
	}

}
