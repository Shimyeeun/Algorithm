package JUNGOL;
import java.util.*;
import java.io.*;
public class Main_1828_냉장고 {
	
	public static class Refrigerator implements Comparable<Refrigerator>{
		int x,y;

		public Refrigerator(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Refrigerator o) {
			
			return this.y-o.y;
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Refrigerator> list=new ArrayList<>();
		int N=Integer.parseInt(br.readLine());
		
		Refrigerator[] r=new Refrigerator[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			r[i]=new Refrigerator(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(r);
		list.add(r[0]);
		
		for(int i=1;i<N;i++) {
			if(list.get(list.size()-1).y<r[i].x) {
				list.add(r[i]);
			}
		}
		
		System.out.println(list.size());
	}
	
	
}
