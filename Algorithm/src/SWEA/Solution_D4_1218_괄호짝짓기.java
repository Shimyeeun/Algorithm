package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack=new Stack<>();
		for(int t=1;t<=10;t++) {
			stack.clear();
			int N=Integer.parseInt(br.readLine());
			String s=br.readLine();
			int ans=0;
			for(int i=0;i<N;i++) {
				
				if(s.charAt(i)=='('|| s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='<') {
					stack.push(s.charAt(i));
					continue;
				}
		
				if(!stack.isEmpty()) {
					if(stack.peek()=='(' && s.charAt(i)==')') {
						stack.pop();
					}
					else if(stack.peek()=='{'&&s.charAt(i)=='}') {
						stack.pop();
					}
					else if(stack.peek()=='['&&s.charAt(i)==']') {
						stack.pop();
					}
					else if(stack.peek()=='<'&&s.charAt(i)=='>') {
						stack.pop();
					} else {
						ans=0;
						break;
					}
				}
				else {
					ans=0;
					break;
				}
				
			}
			
			if(stack.isEmpty()) ans=1;
			System.out.println("#"+t+" "+ans);
		}

	}

}
