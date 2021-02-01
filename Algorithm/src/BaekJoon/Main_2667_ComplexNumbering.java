package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2667_ComplexNumbering {
	public static int n,section,count;
	public static ArrayList<Integer> list;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static void dfs(int[][] arr,int i, int j) {
		arr[i][j]=0;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<n && nj<n && arr[ni][nj]!=0) {
				count++;
				dfs(arr,ni,nj);
			}
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n][n];
		list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			char[] charr=new char[n];
			charr=br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				arr[i][j]=charr[j]-'0';
			}
		}
		section=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				count=1;
				if(arr[i][j]!=0) {
					section++;
					dfs(arr,i,j);
					list.add(count);
				}
				
			}
		}
		int[] sort=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			sort[i]=list.get(i);
		}
		
		Arrays.sort(sort);
		System.out.println(section);
		for(int i=0;i<sort.length;i++) {
			System.out.println(sort[i]);
		}
		

	}

}
