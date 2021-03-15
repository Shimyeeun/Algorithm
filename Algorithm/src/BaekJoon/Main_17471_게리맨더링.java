package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17471_게리맨더링 {
	static int[] arr;
	static int[][] map;
	static int N,min=Integer.MAX_VALUE,size;
	static boolean[] v,v2;
	static boolean isPossible;
	static ArrayList<Integer> area1,area2;
	public static void area(int cnt) {
		if(cnt==N+1) {
			area1.clear();
			area2.clear();
			for(int i=1;i<=N;i++) {
				if(v[i]) {
					area1.add(i);
				}
				else {
					area2.add(i);
				}
			}
			
			
			if(area1.size()==0||area2.size()==0) {
				isPossible=false;
				return;
			}
			v2=new boolean[N+1];
			check(area1,area1.get(0));
			
			if(isPossible) {
				v2=new boolean[N+1];
				check(area2,area2.get(0));				
			}
			
			
			if(isPossible) {
				int area1p=0,area2p=0;
				for(int i=0;i<area1.size();i++) {
					area1p+=arr[area1.get(i)];
				}
				for(int i=0;i<area2.size();i++) {
					area2p+=arr[area2.get(i)];
				}
				
				
				min=Math.min(min, Math.abs(area1p-area2p));
			}
			return;
		}
		
		v[cnt]=true;
		area(cnt+1);
		v[cnt]=false;
		area(cnt+1);
		
		
	}
	
	
	public static void check(ArrayList<Integer> list,int i) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(i);
		v2[i]=true;
		int count=0;
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			count++;
			for(int j=0;j<list.size();j++) {
				if(map[curr][list.get(j)]==1&&!v2[list.get(j)]) {
					v2[list.get(j)]=true;
					q.offer(list.get(j));
				}
			}
			
		}
		if(count==list.size()) {
			isPossible=true;
		}
		else {
			isPossible=false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		v=new boolean[N+1];
		v2=new boolean[N+1];
		map=new int[N+1][N+1];
		area1=new ArrayList<>();
		area2=new ArrayList<>();
		int line=0;
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			if(M!=0) line++;
			for(int j=1;j<=M;j++) {
				int a=Integer.parseInt(st.nextToken());
				map[i][a]=1;
			}
		}
		
		if(N==2 && line==0) {
			min=Math.min(min, Math.abs(arr[1]-arr[2]));
		}else {
			area(1);
		}
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);			
		}
		

	}

}
