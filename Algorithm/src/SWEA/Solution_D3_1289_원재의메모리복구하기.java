package SWEA;
import java.io.*;

public class Solution_D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringBuilder sb=new StringBuilder();
			String s=br.readLine();
			int cnt=0;
			for(int i=0;i<s.length();i++) {
				sb.append("0");				
			}
			
			for(int i=0;i<s.length();i++) {
				
				if(s.charAt(i)!=sb.charAt(i)) {
					cnt++;
					for(int j=i;j<s.length();j++) {
						sb.setCharAt(j, s.charAt(i));
					}
				}
				
				if(s.equals(sb)) {
					break;
				}
				
			}
			System.out.println("#"+t+" "+cnt);
		}

	}

}
