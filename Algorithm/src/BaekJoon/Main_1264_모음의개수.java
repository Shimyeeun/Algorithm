package BaekJoon;
import java.io.*;
public class Main_1264_모음의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s=br.readLine();
			
			if(s.equals("#")) break;
			int cnt=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='a'||s.charAt(i)=='A'||s.charAt(i)=='e'||s.charAt(i)=='E'||s.charAt(i)=='i'||s.charAt(i)=='I'||s.charAt(i)=='o'||s.charAt(i)=='O'||s.charAt(i)=='u'||s.charAt(i)=='U'){
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
