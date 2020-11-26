package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_1206_View {
	public static int n;

	public static boolean left(int[] arr,int i) {
		boolean l=false;
		if(arr[i]>arr[i-1]) {
			if(arr[i]>arr[i-2]) {
				l=true;
			}
		}
		return l;
	}
	
	public static boolean right(int[] arr,int i) {
		boolean r=false;
		if(arr[i]>arr[i+1]) {
			if(arr[i]>arr[i+2]) {
				r=true;
			}
		}
		return r;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
						
			n=Integer.parseInt(br.readLine());
			int[] arr=new int[n];
			int cnt=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=2;i<n-2;i++) {
				int leftmax=0,rightmax=0;
				if(left(arr,i)&&right(arr,i)) {
					if(arr[i-1]>arr[i-2]) {
						leftmax=arr[i-1];
					} else {
						leftmax=arr[i-2];
					}
					if(arr[i+1]>arr[i+2]) {
						rightmax=arr[i+1];
					} else {
						rightmax=arr[i+2];
					}
					
					if(rightmax>leftmax) {
						cnt=cnt+(arr[i]-rightmax);
					} else {
						cnt=cnt+(arr[i]-leftmax);
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		
		
		

	}

}
