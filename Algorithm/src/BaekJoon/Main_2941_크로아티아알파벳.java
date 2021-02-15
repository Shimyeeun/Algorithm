package BaekJoon;
import java.io.*;
public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		
		int cnt=0;
		
		for(int i=0;i<s.length();i++) {
			cnt++;
			if(i+1<s.length()) {
				if(s.charAt(i)=='c') {
					if(s.charAt(i+1)=='='||s.charAt(i+1)=='-') i++;
				}
				else if(s.charAt(i)=='l') {
					if(s.charAt(i+1)=='j') i++;
				}
				else if(s.charAt(i)=='n') {
					if(s.charAt(i+1)=='j') i++;
				}
				else if(s.charAt(i)=='s') {
					if(s.charAt(i+1)=='=') i++;
				}
				else if(s.charAt(i)=='z') {
					if(s.charAt(i+1)=='=') i++;
				}
				else if(s.charAt(i)=='d') {
					if(s.charAt(i+1)=='-') i++;
					else if(i+2<s.length()&&s.charAt(i+1)=='z'&&s.charAt(i+2)=='=') i+=2;
				}
			}
			
		}
		
		System.out.println(cnt);

	}

}
