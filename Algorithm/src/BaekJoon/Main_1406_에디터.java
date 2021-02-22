package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1406_에디터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left=new Stack<>();
		Stack<Character> right=new Stack<>();
		StringBuilder sb=new StringBuilder();
		String s=br.readLine();
		int M=Integer.parseInt(br.readLine());

		
		for(int i=0;i<s.length();i++) {
			left.push(s.charAt(i));
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			char comm=st.nextToken().charAt(0);
			if(comm=='L') {
				if(!left.isEmpty()) {
					right.push(left.pop());					
				}
			}else if(comm=='D') {
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
				
			}else if(comm=='B') {
				if(!left.isEmpty()) {
					left.pop();
				}
			}else {
				char p=st.nextToken().charAt(0);
				left.push(p);
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb.toString());

		
	}

}
