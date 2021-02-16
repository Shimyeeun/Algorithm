package JUNGOL;
import java.util.*;
import java.io.*;
public class Main_1370_회의실배정 {

	public static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			int diff=this.end-o.end;
			return diff!=0?diff:this.start-o.start;
		}
		
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<MeetingRoom> list=new ArrayList<>();
		
		int N=Integer.parseInt(br.readLine());
		MeetingRoom[] m=new MeetingRoom[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			m[i]=new MeetingRoom(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(m);
		list.add(m[0]);
		
		for(int i=1;i<m.length;i++) {
			if(list.get(list.size()-1).end<=m[i].start) {
				list.add(m[i]);
			}
		}
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).no+" ");
		}

	}

}
