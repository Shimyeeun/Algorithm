package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1874_스택수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int j=0;
		for(int i=1;i<=n+1;i++) {
			if(stack.isEmpty()) {
				stack.push(i);
				sb.append("+"+"\n");
			}
			else {
				
				while(j<n&&!stack.isEmpty()) {
					if(stack.peek()==arr[j]) {
						stack.pop();
						j++;
						sb.append("-"+"\n");
					}
					else {
						stack.push(i);
						sb.append("+"+"\n");
						break;
					}
				}
				
				if(stack.isEmpty()&&j<n) {
					i--;
				}
				
			}
			
		
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println("NO");
		}

	}

}
