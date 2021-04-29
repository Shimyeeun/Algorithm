package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1339_단어수학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		String[] arr=new String[N];
		int[] alpha=new int[26];
		int sum=0;
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<arr[i].length();j++) {
				alpha[arr[i].charAt(j)-'A']+=Math.pow(10,arr[i].length()-1-j); // 해당하는 알파벳 인덱스에 자릿수를 더해줌
			}
		}
		
		Arrays.sort(alpha); // 오름차순 정렬
		
		// 자릿수가 큰 알파벳에 큰 수를 대입해야 되므로 배열 뒤에서부터 숫자 부여, 숫자는 9부터
		int num=9;
		for(int i=25;i>=16;i--) {
			sum+=alpha[i]*num;
			num--;
		}
		
		System.out.println(sum);
	}

}
