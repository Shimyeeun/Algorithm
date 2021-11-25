package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21773_가희와프로세스1 {
	
	static class Process implements Comparable<Process>{
		int a,b,c;
		
		public Process(int a,int b,int c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
		
		@Override
		public int compareTo(Process o) {
			if(this.c==o.c) {
				return this.a-o.a;
			}
			return o.c-this.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		PriorityQueue<Process> pq=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());	
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			pq.offer(new Process(a,b,c));
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<T;i++) {
			
			if(pq.isEmpty()) break;
			Process curr=pq.poll();
			sb.append(curr.a+"\n");
			if(curr.b==1) {
				continue;
			}
			
			pq.offer(new Process(curr.a,curr.b-1,curr.c-1));
		}
		
		System.out.println(sb.toString());
	}

}
