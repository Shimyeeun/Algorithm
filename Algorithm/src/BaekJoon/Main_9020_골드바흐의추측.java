package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_9020_골드바흐의추측 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n=Integer.parseInt(br.readLine());
			int min=Integer.MAX_VALUE;
			int num1=0;
			int num2=0;
			boolean[] arr=new boolean[n+1];
			for(int i=2;i<=n;i++) {
				arr[i]=true;
			}
			for(int i=2;i<=Math.sqrt(n);i++) {
				for(int j=i*i;j<=n;j+=i) {
					arr[j]=false;
				}
			}
			
			for(int i=2;i<=n;i++) {
				if(arr[i]&&arr[n-i]) {
					if(Math.abs(n-i-i)<min) {
						min=n-i-i;
						num1=i;
						num2=n-i;
					}
				}
			}
			
			System.out.println(num1+" "+num2);

		}
	}
	
	

}
