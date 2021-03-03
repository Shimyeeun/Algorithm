package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1107_리모컨 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String N=br.readLine();
		int M=Integer.parseInt(br.readLine());
		int plus=Integer.MAX_VALUE,minus=Integer.MAX_VALUE;
		int ans=0;
		String[] arr=new String[M];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i]=st.nextToken();
		}
		
		if(Integer.parseInt(N)==100) {
			ans=0;
		}
		else if(M==10) {
			ans=Integer.parseInt(N)-100;
		}
		else if(M==0) {
			ans=N.length();
		}
		else if(M==9&& Integer.parseInt(arr[0])==1) {
			ans=Integer.parseInt(N)-100;
		}
		else {
			int p=Integer.parseInt(N);
			int m=Integer.parseInt(N);
			L1: while(p<=1000000) {
				for(int i=0;i<M;i++) {
					if(Integer.toString(p).contains(arr[i])) {
						break;
					}
					else {
						if(i==M-1) {
							plus=Math.abs(Integer.parseInt(N)-p)+Integer.toString(p).length();							
							break L1;
						}
					}
				}
				p++;
			}
			
			L2: while(m>=0) {
				for(int i=0;i<M;i++) {
					if(Integer.toString(m).contains(arr[i])) {
						break;
					}
					else {
						if(i==M-1) {
							minus=Math.abs(Integer.parseInt(N)-m)+Integer.toString(m).length();							
							break L2;
						}
					}
					
				}
				m--;
			}
			
			ans=Math.min(plus, minus);
			
		}
		
		System.out.println(ans);
		
		

	}

}
