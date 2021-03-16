package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1759_암호만들기 {
	
	static int L,C;
	static char[] arr,sel;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		arr=new char[C];
		sel=new char[L];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		
		
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb.toString());

	}
	
	public static void comb(int cnt,int idx) {
		
		if(cnt==L) {
			int moeum=0;
			int jaeum=0;
			for(int i=0;i<L;i++) {
				if(sel[i]=='a'||sel[i]=='e' || sel[i]=='o' || sel[i]=='i' || sel[i]=='u') {
					moeum++;
				}
				else {
					jaeum++;
				}
			}
			
			if(moeum>=1 && jaeum>=2) {
				for(int i=0;i<L;i++) {
					sb.append(sel[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=idx;i<C;i++) {
			sel[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}

}
