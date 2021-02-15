package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_3985_롤케이크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int L=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		int real=Integer.MIN_VALUE;
		int want=Integer.MIN_VALUE;
		int wantidx=0,realidx=0;
		int[] cake=new int[L+1];
		int[] res=new int[N+1];
		int[][] arr=new int[N+1][2];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=arr[i][0];j<=arr[i][1];j++) {
				if(cake[j]==0) {
					cake[j]=i;					
				}
			}
			
			if(arr[i][1]-arr[i][0]+1>want) {
				want=arr[i][1]-arr[i][0]+1;
				wantidx=i;
			}
			
			int sum=0;
			for(int j=1;j<=L;j++) {
				if(cake[j]==i) sum++;
			}
			res[i]=sum;
			if(real<sum) {
				real=sum;
				realidx=i;
			}
		}
		
		
		System.out.println(wantidx+"\n"+realidx);
	

	}

}
