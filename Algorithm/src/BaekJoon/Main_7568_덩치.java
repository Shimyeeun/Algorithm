package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_7568_덩치 {
	
	static int[][] arr;
	static int N;
	static int[] sel;
	static int[] res;

	public static void comb(int cnt, int start) {
		if(cnt==sel.length) {
			if(arr[sel[0]][0]>arr[sel[1]][0]&&arr[sel[0]][1]>arr[sel[1]][1]) {
				res[sel[1]]++;
			}
			else if(arr[sel[0]][0]<arr[sel[1]][0]&&arr[sel[0]][1]<arr[sel[1]][1]) {
				res[sel[0]]++;
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			sel[cnt]=i;
			comb(cnt+1,i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][2];
		res=new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			res[i]=1;
		}
		sel=new int[2];
		comb(0,0);
		
		for(int i=0;i<N;i++) {
			System.out.print(res[i]+" ");
		}

	}

}
