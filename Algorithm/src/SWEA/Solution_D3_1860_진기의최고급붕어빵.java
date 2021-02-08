package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D3_1860_진기의최고급붕어빵 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			boolean check=false;
			int[] arr=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(arr[i]<M) {
					check=false;
					break;
				}
				else {
					cnt=arr[i]/M*K;
					if(cnt<i+1) {
						check=false;
						break;
					}
					else {
						check=true;
						continue;
					}
				}
			}
			
			if(check) {
				System.out.println("#"+t+" Possible");
			}
			else {
				System.out.println("#"+t+" Impossible");
			}	
			
		}
		
	}

}
