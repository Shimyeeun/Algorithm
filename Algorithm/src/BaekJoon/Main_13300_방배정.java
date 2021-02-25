package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_13300_방배정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] girl=new int[7];
		int[] boy=new int[7];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int grade=Integer.parseInt(st.nextToken());
			
			if(gender==0) {
				girl[grade]++;
			}
			else {
				boy[grade]++;
			}
		}
		int cnt=0;
		for(int i=1;i<=6;i++) {
			if(girl[i]%K==0) {
				cnt+=girl[i]/K;
			}
			else {
				cnt+=girl[i]/K+1;
			}
			
			if(boy[i]%K==0) {
				cnt+=boy[i]/K;
			}
			else {
				cnt+=boy[i]/K+1;
			}
		}
		
		System.out.println(cnt);
		
	}

}
