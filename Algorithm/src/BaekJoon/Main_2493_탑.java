package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2493_탑 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Stack<int[]> stack=new Stack<>();
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		int[] ans=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		} 
		
		for(int i=0;i<N;i++) {
			if(!stack.isEmpty()) {
				if(arr[i]<=stack.peek()[1]) {
					ans[i]=stack.peek()[0];
					stack.push(new int[] {i+1,arr[i]});
				}
				else {
					stack.pop();
					if(stack.isEmpty()) {
						stack.push(new int[] {i+1,arr[i]});
					}
					else {
						i--;
					}
					
				}
			}
			else {
				stack.push(new int[] {i+1, arr[i]});
			}
			
		}

		
		for(int i=0;i<N;i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
		

	}

}
