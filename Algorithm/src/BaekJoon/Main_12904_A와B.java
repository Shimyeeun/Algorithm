package BaekJoon;
import java.io.*;
public class Main_12904_A와B {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String S=br.readLine();
		String T=br.readLine();
		int ans=0;
		while(T.length()>0) {
			if(T.charAt(T.length()-1)=='A') {
				T=T.substring(0,T.length()-1);
			}
			else if(T.charAt(T.length()-1)=='B') {
				T=T.substring(0,T.length()-1);
				String temp="";
				for(int i=T.length()-1;i>=0;i--) {
					temp+=T.charAt(i);
				}
				T=temp;
			}
			
			if(T.equals(S)) {
				ans=1;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
