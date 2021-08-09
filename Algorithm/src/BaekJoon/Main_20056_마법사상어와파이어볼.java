package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_20056_마법사상어와파이어볼 {

	static class fireball{
		int r,c,m,s,d;
		
		public fireball(int r,int c,int m,int s,int d){
			this.r=r;
			this.c=c;
			this.m=m;
			this.s=s;
			this.d=d;
		}
	}
	
	static int N,M,K;
	static ArrayList<fireball> list;
	static int[][] arr,cp;
	static int[] dr= {-1,-1,0,1,1,1,0,-1},dc= {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
		list=new ArrayList<>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			
			list.add(new fireball(r,c,m,s,d));
			arr[r][c]++;
		}
		
		for(int i=0;i<K;i++) {
			cp=new int[N+1][N+1];
			move();
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(cp[j][k]>=2) divide(j,k,cp[j][k]);
				}
			}
			copy(arr,cp);
		}
		System.out.println(sum());
	}
	
	public static void copy(int[][] arr1,int[][] arr2) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	public static void move() {
		for(int i=0;i<list.size();i++) {
			
			int nr=list.get(i).r+(list.get(i).s*dr[list.get(i).d]);
			int nc=list.get(i).c+(list.get(i).s*dc[list.get(i).d]);
			if(nr>N){
				nr=Math.abs(nr)%N;				
			}
			if(nr<1) {
				nr=N-Math.abs(nr)%N;
			} 
			if(nc>N){				
				nc=Math.abs(nc)%N;
			}
			if(nc<1) {
				nc=N-Math.abs(nc)%N;
			} 
			cp[nr][nc]++;
			fireball nf=new fireball(nr,nc,list.get(i).m,list.get(i).s,list.get(i).d);
			list.set(i, nf);
		}
	}
	
	public static void divide(int r,int c,int cnt) {
		int even=0;
		int odd=0;
		int nm=0;
		int ns=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).r==r && list.get(i).c==c) {
				if(list.get(i).d%2==0) even++;
				else odd++;
				
				nm+=list.get(i).m;
				ns+=list.get(i).s;
				list.remove(i);
				i--;
			}
		}
		
		nm/=5;
		ns/=cnt;
		
		if(nm!=0) {
			if(even==cnt || odd==cnt) {
				list.add(new fireball(r,c,nm,ns,0));
				list.add(new fireball(r,c,nm,ns,2));
				list.add(new fireball(r,c,nm,ns,4));
				list.add(new fireball(r,c,nm,ns,6));
			}
			else {
				list.add(new fireball(r,c,nm,ns,1));
				list.add(new fireball(r,c,nm,ns,3));
				list.add(new fireball(r,c,nm,ns,5));
				list.add(new fireball(r,c,nm,ns,7));
			}	
		} else {			
			cp[r][c]=0;
		}
	}
	
	public static int sum() {
		int sum=0;
		
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).m;
		}
		return sum;
	}

}
