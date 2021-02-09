package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int cnt=0;
		Queue<Integer> qu=new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			qu.offer(i);
		}
		
		sb.append("<");
		while(!qu.isEmpty()) {
			int temp=qu.poll();
			cnt++;
			
			if(cnt%K==0) {
				sb.append(temp+", ");
			}
			else {
				qu.offer(temp);
			}
			
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
		

	}

}
