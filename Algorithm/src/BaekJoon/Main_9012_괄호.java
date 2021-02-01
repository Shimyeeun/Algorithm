package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_9012_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			String s=br.readLine();
			Stack<Character> stack=new Stack<>();
			
			for(int i=0;i<s.length();i++) {
				if(stack.isEmpty()) {
					stack.push(s.charAt(i));
				}
				else {
					if(stack.peek()=='('&&s.charAt(i)==')') {
						stack.pop();
					} else {
						stack.push(s.charAt(i));
					}
				}
				
			}
			
			if(stack.size()>0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			
			
		}

	}

}
