package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_4613_러시아국기같은깃발 {

	static int N,M,paint,min;
	static int[] sel;
	static char[][] arr;
	
	public static void perm(int cnt) {
		if(cnt==sel.length) {
			int sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			if(sum==N) {
				paint=0;
				//System.out.println(Arrays.toString(sel));		
				for(int i=0;i<sel[0];i++) {
					for(int j=0;j<M;j++) {
						if(arr[i][j]!='W') {
							paint++;
						}
					}
				}
				
				for(int i=sel[0];i<sel[0]+sel[1];i++) {
					for(int j=0;j<M;j++) {
						if(arr[i][j]!='B') {
							paint++;
						}
					}
				}
				
				for(int i=sel[0]+sel[1];i<N;i++) {
					for(int j=0;j<M;j++) {
						if(arr[i][j]!='R') {
							paint++;
						}
					}
				}
				min=Math.min(paint, min);
			}
			
			return;
		}
		
		for(int i=1;i<=N-2;i++) {
			sel[cnt]=i;
			perm(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			sel=new int[3];
			arr=new char[N][M];
			min=Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				String s=br.readLine();
				for(int j=0;j<M;j++) {
					arr[i][j]=s.charAt(j);
				}
			}
			
			perm(0);
			sb.append("#"+t+" "+min+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
