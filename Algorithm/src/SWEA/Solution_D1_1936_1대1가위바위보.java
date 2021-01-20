package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D1_1936_1대1가위바위보 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		if(a==1 && b==2) {
			System.out.println("B");
		}
		else if(a==1 && b==3) {
			System.out.println("A");
		}
		else if(a==2 && b==3) {
			System.out.println("B");
		}
		else if(a==2 && b==1) {
			System.out.println("A");
		}
		else if(a==3 && b==1) {
			System.out.println("B");
		}
		else if(a==3 && b==2) {
			System.out.println("A");
		}

	}

}
