package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_1303_WarBattle {
	public static int n,m,wcnt,bcnt;
	public static boolean[][] v;
	public static ArrayList<Integer> w,b;
	public static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	public static void wdfs(int i,int j,char[][] arr) {
		wcnt++;
		v[i][j]=true;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<m && nj<n && v[ni][nj]==false && arr[ni][nj]=='W' ) {
				wdfs(ni,nj,arr);
			}
		}
	}
	
	public static void bdfs(int i,int j,char[][] arr) {
		bcnt++;
		v[i][j]=true;

		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<m && nj<n && v[ni][nj]==false && arr[ni][nj]=='B' ) {
				bdfs(ni,nj,arr);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		char[][] arr=new char[m][n];
		v=new boolean[m][n];
		
		 for(int i=0;i<m;i++) {
	         char[] temp=new char[m];
	         temp=br.readLine().toCharArray();
	         for(int j=0;j<n;j++) {
	            arr[i][j]=temp[j];	            
	         }
	      }
		
		 w=new ArrayList<>();
		 b=new ArrayList<>();
		 
		 for(int i=0;i<m;i++) {
			 for(int j=0;j<n;j++) {
				 wcnt=0;
				 bcnt=0;
				 if(arr[i][j]=='W'&&v[i][j]==false) {
					 wdfs(i,j,arr);
					 w.add(wcnt);
				 }
				 else if(arr[i][j]=='B'&& v[i][j]==false){
					 bdfs(i,j,arr);
					 b.add(bcnt);
				 }
			 }
		 }
		 int wpower=0;
		 int bpower=0;
		 
		 for(int i=0;i<w.size();i++) {
			 wpower=wpower+w.get(i)*w.get(i);
		 }
		 for(int i=0;i<b.size();i++) {
			 bpower=bpower+b.get(i)*b.get(i);
		 }
		 
		 System.out.println(wpower+" "+bpower);

	}

}
