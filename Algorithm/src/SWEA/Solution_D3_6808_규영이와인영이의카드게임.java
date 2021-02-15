package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int win=0;
			int lose=0;
			list=new ArrayList<>();
			for(int i=1;i<=18;i++) {
				list.add(i);
			}
			int[] arr=new int[9];
		
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				for(int j=0;j<list.size();j++) {
					if(list.get(j)==arr[i]) {
						list.remove(j);
						break;
					}
				}
			}
			
			do {
				int kyu=0;
				int in=0;
				for(int i=0;i<9;i++) {
					if(arr[i]>list.get(i)) {
						kyu=kyu+arr[i]+list.get(i);
					}else {
						in=in+arr[i]+list.get(i);
					}
				}
				if(kyu>in) win++;
				else if(in>kyu) lose++;
			} while(np());
	
			
			sb.append("#"+t+" "+win+" "+lose+"\n");
			
			
		}
		
		System.out.println(sb.toString());
		

	}

	public static boolean np() {
		
		int i=8;
		while(i>0 && list.get(i-1)>=list.get(i)) --i;
		
		if(i==0) return false;
		
		int j=8;
		while(list.get(i-1)>=list.get(j)) --j;
		swap(i-1,j);
		
		int k=8;
		while(i<k) {
			swap(i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j, temp);
	}
}
