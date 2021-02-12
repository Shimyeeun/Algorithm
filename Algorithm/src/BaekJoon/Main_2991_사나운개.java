package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2991_사나운개 {
	
	static int A,B,C,D,P,M,N;
	static StringBuilder sb;
	public static void attack(int person) {
		int cnt=0;
		if(person%(A+B)<=A&&person%(A+B)!=0) {
			cnt++;
		}
		if(person%(C+D)<=C&&person%(C+D)!=0) {
			cnt++;
		}
		
		sb.append(cnt+"\n");
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		int P=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		attack(P);
		attack(M);
		attack(N);
		
		System.out.println(sb.toString());

	}

}
