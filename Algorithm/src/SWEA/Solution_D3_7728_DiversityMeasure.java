package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_7728_DiversityMeasure {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			String s=Integer.toString(Integer.parseInt(br.readLine()));
			HashSet<Character> set=new HashSet<>();  
			for(int j=0;j<s.length();j++) {
				set.add(s.charAt(j));
			}
			
			System.out.println("#"+i+" "+set.size());
		}

	}

}
