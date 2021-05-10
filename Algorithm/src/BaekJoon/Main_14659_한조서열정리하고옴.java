package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14659_한조서열정리하고옴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int max=0;
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N-1;i++) {
			int cnt=0;
			for(int j=i+1;j<N;j++) { // 다음봉우리부터 확인
				if(arr[i]>arr[j]) { // 봉우리가 낮을때만 공격가능
					cnt++;
				}
				else {
					break;
				}
			}
			max=Math.max(cnt, max); //max값 구하기
		}
		System.out.println(max);
	}

}
