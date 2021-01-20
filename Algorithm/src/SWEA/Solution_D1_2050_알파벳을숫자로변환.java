package SWEA;
import java.io.*;
public class Solution_D1_2050_알파벳을숫자로변환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] alphabet={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		String s=br.readLine();
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<alphabet.length;j++) {
				if(s.charAt(i)==alphabet[j]) {
					int num=j+1;
					System.out.print(num+" ");
				}
			}
		}
		
		

	}

}
