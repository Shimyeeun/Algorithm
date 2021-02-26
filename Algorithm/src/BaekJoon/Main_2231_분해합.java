package BaekJoon;
import java.io.*;

public class Main_2231_분해합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=0;
		for(int i=1;i<=N;i++) {
			String s=Integer.toString(i);
			int sum=0;
			sum+=i;
			for(int j=0;j<s.length();j++) {
				sum+=s.charAt(j)-'0';
			}
			
			if(sum==N) {
				M=i;
				break;
			}
		}
		
		System.out.println(M);

	}

}
