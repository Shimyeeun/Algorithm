package BaekJoon;
import java.io.*;
public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s=br.readLine();
		
		int n=s.length();
		int r=0;
		int c=0;
		
		for(int i=1;i<=Math.sqrt(s.length());i++) {
			if(n%i==0) {
				r=i;
				c=n/i;				
			}	
		}
		
		char[][] arr=new char[r][c];
		int cnt=0;
		L:for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				arr[j][i]=s.charAt(cnt);
				if(cnt==n) break L;
				else cnt++;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(arr[i][j]);
			}
		}
		
		System.out.println(sb.toString());	
	}

}
