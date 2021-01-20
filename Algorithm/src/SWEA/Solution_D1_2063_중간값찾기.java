package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D1_2063_중간값찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(arr);
		System.out.println(arr[n/2]);

	}

}
