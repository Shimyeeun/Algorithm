package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2822_점수계산 {

	static class cal implements Comparable<cal>{
		int score,idx;
		
		public cal(int score,int idx) {
			this.score=score;
			this.idx=idx;
		}

		@Override
		public int compareTo(cal o) {
			return Integer.compare(o.score, this.score);
		}
				
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<cal> list=new ArrayList<>();
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<8;i++) {
			int a=Integer.parseInt(br.readLine());
			list.add(new cal(a,i+1));
		}
		
		Collections.sort(list);
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=list.get(i).score;
			ans.add(list.get(i).idx);
		}
		Collections.sort(ans);
		System.out.println(sum);
		for(int i=0;i<5;i++) {
			System.out.print(ans.get(i)+" ");
		}
		
		
	}

}
