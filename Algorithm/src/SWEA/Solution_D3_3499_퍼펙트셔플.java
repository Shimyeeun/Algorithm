package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringBuilder sb=new StringBuilder();
			int N=Integer.parseInt(br.readLine());
			ArrayList<String> list=new ArrayList<>();
			String[] arr=new String[N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i]=st.nextToken();
			}
			if(N%2==0) {
				
				for(int i=0;i<N/2;i++) {
					list.add(arr[i]);
					list.add(arr[i+N/2]);
				}
			}
			
			else {
				for(int i=0;i<N/2+1;i++) {
					list.add(arr[i]);
					if(i==N/2) break;
					list.add(arr[i+N/2+1]);
				}
			}
			
			sb.append("#"+t+" ");
			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i)+" ");
			}
			
			System.out.println(sb);
		}

	}

}
