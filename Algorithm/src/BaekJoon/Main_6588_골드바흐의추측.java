package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_6588_골드바흐의추측 {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<Integer> list=new ArrayList<>();
		int max=Integer.MIN_VALUE;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) break;
			list.add(N);
		}
		for(int i=0;i<list.size();i++) {
			max=Math.max(list.get(i),max);
		}
		arr=new int[max+1];
		for(int i=2;i<arr.length;i++) {
			arr[i]=i;
		}
		for(int i=2;i<=Math.sqrt(max);i++ ) {
			if(arr[i]==0) continue;
			for(int j=i+i;j<=max;j+=i) {
				arr[j]=0;
			}
		}
		
		for(int k=0;k<list.size();k++) {
			for(int i=3;i<=list.get(k);i+=2) {
				int b=list.get(k)-i;
				if(arr[i]!=0&&arr[b]!=0) {
					sb.append(list.get(k)+" = "+i+" + "+b+"\n");
					break;
				}
			}
			
		}
		
		
				
		System.out.println(sb.toString());
	}	

}
