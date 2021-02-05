package BaekJoon;
import java.io.*;

public class Main_17413_단어뒤집기2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s=br.readLine();
		s=s+" ";
		int start=0;
		int end=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='<') {
				for(int j=i;;j++) {
					sb.append(s.charAt(j));
					if(s.charAt(j)=='>') {
						i=j;
						break;
					}
				}
			}
			
			else if(s.charAt(i)==' ') {
				sb.append(s.charAt(i));
			}
			
			else {
				start=i;
				for(int j=i;;j++) {
					if(s.charAt(j)==' '||s.charAt(j)=='<') {
						end=j-1;
						i=j-1;
						break;
					}
				}
				
				for(int j=end;j>=start;j--) {
					sb.append(s.charAt(j));
				}				
			}
		}
		
		System.out.println(sb);
			
	}

}
