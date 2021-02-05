package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		int cnt=0;
		int ball=0;
		arr[0]=1;
		
		while(true) {
			cnt++;
			if(arr[ball]%2==1) {
				ball+=L;
				if(ball>=N) {
					ball=ball-N;
				}
				
				arr[ball]++;
				
			}else {
				ball-=L;
				if(ball<0) {
					ball=N+ball;
				}
				arr[ball]++;
			}
			
			if(arr[ball]==M) break;			
		}
		
		System.out.println(cnt);

	}

}
