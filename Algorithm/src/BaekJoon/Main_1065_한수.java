package BaekJoon;
import java.io.*;
public class Main_1065_한수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(i<100) {
				cnt++;
			}
			else if(i>=100) {
				int hund=i/100;
				int ten=(i%100)/10;
				int one=i%10;
				
				if(hund-ten==ten-one) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		

	}

}
