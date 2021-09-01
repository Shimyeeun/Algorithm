package BaekJoon;
import java.util.*;
public class Main_1371_가장많은글자 {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[26];
		
		while(sc.hasNextLine()) {
			String s=sc.nextLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)!=' ') {
					arr[(int)s.charAt(i)-97]++;					
				}
			}
		}
		
		int max=0;
		String res="";
		for(int i=0;i<26;i++) {
			if(arr[i]>max) {
				max=arr[i];
				
				res=Character.toString((char)(i+97));
			}
			else if(arr[i]==max) {
				res+=Character.toString((char)(i+97));
			}
		}

		System.out.println(res);
		
		
	}

}
