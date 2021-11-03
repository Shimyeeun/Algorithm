package BaekJoon;
import java.io.*;

public class Main_9663_NQueen {

	static int N,cnt;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		
		nqueen(0);
		System.out.println(cnt);
	}
	
	public static void nqueen(int idx) {
		if(idx==N) {
			cnt++;
			return;
		}
		for(int i=0;i<N;i++) {
			arr[idx]=i;
			if(check(idx)) {
				nqueen(idx+1);
			}			
		}
	}
	
	public static boolean check(int idx) {
		for(int i=0;i<idx;i++) {
			if(arr[idx]==arr[i]||Math.abs(arr[idx]-arr[i])==idx-i) {
				return false;
			}
		}
		
		return true;
	}

}
