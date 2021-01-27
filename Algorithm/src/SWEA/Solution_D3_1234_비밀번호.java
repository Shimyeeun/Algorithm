package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D3_1234_비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t=1;t<=10;t++) {			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			String s=st.nextToken();
			
			ArrayList<Character> list=new ArrayList<>();
			
			for(int i=0;i<s.length();i++) {
				list.add(s.charAt(i));
			}
			
			for(int i=0;i<list.size();i++) {
				if(i<list.size()-1&&list.get(i)==list.get(i+1)) {
					list.remove(i);
					list.remove(i);
					i=-1;
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
			
			System.out.println();
			
			
		}

	}

}
