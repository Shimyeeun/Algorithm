package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_7272_안경이없어 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int[] hole= {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String s1=st.nextToken();
			String s2=st.nextToken();
			int same=1;
			if(s1.length()!=s2.length()) {
				same=0;
			}
			else {
				for(int i=0;i<s1.length();i++) {					
					if(hole[(int)s1.charAt(i)-65]==hole[(int)s2.charAt(i)-65]) {
						same=1;
					}
					else {
						same=0;
						break;
					}
			
				}
			}
			
			if(same==1) {
				System.out.println("#"+t+" SAME");
			}
			else {
				System.out.println("#"+t+" DIFF");
			}
		}

	}

}
