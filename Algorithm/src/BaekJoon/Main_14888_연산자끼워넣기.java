package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14888_연산자끼워넣기 {
	static int N,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
	static int[] arr,op;
	public static void calculate(int idx,int cal,int i) {
		if(i==N-1) {
			min=Math.min(min, cal);
			max=Math.max(max, cal);
			return;
		}
		
		if(op[0]!=0) {
			op[0]--;			
			calculate(0,cal+arr[i+1],i+1);
			op[0]++;
		}
		
		if(op[1]!=0) {
			op[1]--;
			calculate(1,cal-arr[i+1],i+1);
			op[1]++;
		}
		
		if(op[2]!=0) {
			op[2]--;
			calculate(2,cal*arr[i+1],i+1);	
			op[2]++;
		}
		
		if(op[3]!=0) {
			op[3]--;
			calculate(3,cal/arr[i+1],i+1);			
			op[3]++;
		}
		
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		op=new int[4];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i]=Integer.parseInt(st.nextToken());
		}
		
		calculate(0,arr[0],0);
		System.out.println(max);
		System.out.println(min);
		

	}

}
