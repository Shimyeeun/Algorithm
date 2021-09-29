package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_22252_정보상인호석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		HashMap<String,PriorityQueue<Integer>> map=new HashMap<>();
		long count=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int type=Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			
			if(type==1) {
				int k=Integer.parseInt(st.nextToken());
				
				if(map.containsKey(name)) {
					for(int j=0;j<k;j++) {
						map.get(name).add(Integer.parseInt(st.nextToken()));						
					}
				}
				else {
					PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
					for(int j=0;j<k;j++) {
						pq.add(Integer.parseInt(st.nextToken()));
					}
					map.put(name, pq);					
				}
			}
			
			else {
				int b=Integer.parseInt(st.nextToken());
				if(map.containsKey(name)) {
					if(map.get(name).size()<b) {
						b=map.get(name).size();
					}
					for(int j=0;j<b;j++) {
						count+=map.get(name).poll();
					}
				}
			}
			
			
			
		}
		
		System.out.println(count);
		
		
	}
	
	

}
