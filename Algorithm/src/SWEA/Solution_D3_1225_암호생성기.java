package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			ArrayList<Integer> list=new ArrayList<>();
			for(int i=0;i<8;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
		  L:while(true) {
				int num=1;
				while(num<6) {
					list.add(list.get(0)-num);
					list.remove(0);
					num++;
					if(list.get(list.size()-1)<=0) {
						list.set(list.size()-1,0);
						break L;
					}
				}
				
			}
			
		  	System.out.print("#"+t+" ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		

	}

}
