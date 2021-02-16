package BaekJoon;
import java.io.*;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int cnt=0;

		while(N>=3) {
			
			if(N%5==0) {
				cnt+=N/5;
				N=0;
				break;
			}
			
			N-=3;
			cnt++;			
			
		}
		
		if(N!=0) {
			cnt=-1;
		}
		System.out.println(cnt);
	}

}
