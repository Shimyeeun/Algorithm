package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=10;t++) {
			
			int N=Integer.parseInt(br.readLine());
			ArrayList<Integer> list=new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M=Integer.parseInt(br.readLine());
			
			StringTokenizer s=new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				
				String I=s.nextToken();
				int x=Integer.parseInt(s.nextToken());
				int y=Integer.parseInt(s.nextToken());
				
				for(int j=0;j<y;j++) {
					list.add(x+j,Integer.parseInt(s.nextToken()));
				}
				
			}
			
			sb.append("#"+t+" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)+" ");
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	

	}

}
