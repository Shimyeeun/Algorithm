package BaekJoon;
import java.io.*;
public class Main_1259_팰린드롬수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s=br.readLine();
			
			if(s.equals("0")) break;
			
			int ch=0;
			for(int i=0;i<s.length()/2;i++) {
				if(s.charAt(i)==s.charAt(s.length()-1-i)) {
					continue;
				}
				else {
					ch=1;
					break;
				}
			}
			
			if(ch==0) System.out.println("yes");
			else System.out.println("no");
			
		}
	}

}
