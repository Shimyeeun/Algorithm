package BaekJoon;
import java.io.*;
public class Main_8320_직사각형을만드는방법 {

	static int n;
	static int[] sel;
	static int count;
	public static void combination(int cnt,int idx) {
		if(cnt==sel.length) {
			if(sel[0]*sel[1]<=n) {
				count++;
			}
			return;
		}
		
		for(int i=idx;i<=n;i++) {
			sel[cnt]=i;
			combination(cnt+1,i);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		sel=new int[2];
		
		combination(0,1); 	
		System.out.println(count);
	}
	

}
