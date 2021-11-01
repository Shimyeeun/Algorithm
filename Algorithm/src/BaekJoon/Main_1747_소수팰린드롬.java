package BaekJoon;
import java.io.*;
public class Main_1747_소수팰린드롬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int max=1003001;
		boolean[] arr=new boolean[max+1];
		
		for(int i=2;i<=max;i++) {
			arr[i]=true;
		}
		for(int i=2;i<=Math.sqrt(max);i++) {
			for(int j=i*i;j<=max;j+=i){
				arr[j]=false;
			}
		}
		
		while(true) {
			if(arr[N]&&isPalindrome(N)) {
				System.out.println(N);
				break;
			}
			N++;
		}
		
	}
	
	public static boolean isPalindrome(int n) {
		
		if(n>=10) {
			String s=Integer.toString(n);
			for(int i=0;i<s.length()/2;i++) {
				if(s.charAt(i)==s.charAt(s.length()-i-1)) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}

}
