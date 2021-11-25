package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_4948_베르트랑공준 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			else {
				boolean[] arr=new boolean[2*n+1];
				
				for(int i=2;i<=2*n;i++) {
					arr[i]=true;
				}
				
				for(int i=2;i<=Math.sqrt(2*n);i++) {
					for(int j=i*i;j<=2*n;j+=i) {
						arr[j]=false;
					}
				}
				
				int cnt=0;
				for(int i=n+1;i<=2*n;i++) {
					if(arr[i]) {
						cnt++;
					}
				}
				
				System.out.println(cnt);
			
			}
		}
	}

}
