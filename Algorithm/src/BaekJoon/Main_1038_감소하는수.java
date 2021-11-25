package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1038_감소하는수 {

	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		list=new ArrayList<>();
		
		if(N>1022) {
			System.out.println("-1");
		}
		else if(N==1022) {
			System.out.println("9876543210");
		}
		else {
			for(int i=0;i<10;i++) {
				isDecrease(i,1);
			}			
			Collections.sort(list);
			System.out.println(list.get(N));
		}
		
		
	}
	
	public static void isDecrease(int n, int cnt) {
		if(cnt>10) {
			return;
		}
		
		list.add(n);
		
		
		for(int i=0;i<10;i++) {
			if(n%10>i) {
				isDecrease(n*10+i,cnt+1);
			}
		}
	}
	
	
	

}
