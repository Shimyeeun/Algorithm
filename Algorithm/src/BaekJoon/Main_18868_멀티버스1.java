package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_18868_멀티버스1 {

	static int N,M,ans;
	static int[][] arr;
	static int[] sel;
	static int[] planet;
	
	public static void comb(int cnt,int start) {
		if(cnt==sel.length) {
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if((arr[sel[0]][i]<arr[sel[0]][j]&&arr[sel[1]][i]<arr[sel[1]][j]) ||
							(arr[sel[0]][i]==arr[sel[0]][j]&&arr[sel[1]][i]==arr[sel[1]][j]) ||
							(arr[sel[0]][i]>arr[sel[0]][j]&&arr[sel[1]][i]>arr[sel[1]][j]) ) {
						continue;
					}	
					else {
						return;
					}
				}
			}
			ans++;
			return;
		}
		for(int i=start;i<arr.length;i++) {
			sel[cnt]=i;
			comb(cnt+1,i+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new int[M][N];
		sel=new int[2];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(ans);
		
	}

}
