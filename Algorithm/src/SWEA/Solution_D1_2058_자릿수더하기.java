package SWEA;
import java.io.*;

public class Solution_D1_2058_자릿수더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String n=br.readLine();
		int sum=0;
		
		for(int i=0;i<n.length();i++) {
			sum += n.charAt(i)-48;
		}
		
		System.out.println(sum);

	}

}
