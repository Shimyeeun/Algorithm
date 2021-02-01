package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_10026_ColorWeakness {
	static boolean[][] v;
	static boolean[][] pv;
	static int n,normal=0,abnormal=0;
	static char[][] grid;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void patientdfs(int i, int j, char[][] arr, char curr) {
		pv[i][j]=true;
		
		for(int k=0;k<4;k++) {
			int nx=i+dx[k];
			int ny=j+dy[k];
			
			if(nx>=0 && ny>=0 && nx<n &&ny<n &&pv[nx][ny]==false) {
				char next=arr[nx][ny];
				if(next==curr||(next=='R'&&curr=='G')||(next=='G'&&curr=='R')) {
					patientdfs(nx,ny,arr,curr);
				}
			}
		}
	}
	
	public static void dfs(int i, int j, char[][] arr, char curr) {
		v[i][j]=true;
		
		for(int k=0;k<4;k++) {
			int nx=i+dx[k];
			int ny=j+dy[k];
			
			if(nx>=0 && ny>=0 && nx<n &&ny<n &&v[nx][ny]==false) {
				char next=arr[nx][ny];
				if(next==curr) {
					dfs(nx,ny,arr,curr);
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     n=Integer.parseInt(br.readLine());
	      grid=new char[n][n];
	      v=new boolean[n][n];
	      pv=new boolean[n][n];
	      for(int i=0;i<n;i++) {
	         char[] temp=new char[n];
	         temp=br.readLine().toCharArray();
	         for(int j=0;j<n;j++) {
	            grid[i][j]=temp[j];	            
	         }
	      }
	      
	      for(int i=0;i<n;i++) {
	    	  for(int j=0;j<n;j++) {
	    		  if(v[i][j]==false) {
	    			  normal++;
	    			  dfs(i,j,grid,grid[i][j]);
	    		  }
	    		  if(pv[i][j]==false) {
		    		  abnormal++;
		    		  patientdfs(i,j,grid,grid[i][j]);
		    	  }
	    		
	    	  }
	      }
	      
    
	      System.out.println(normal+" "+abnormal);
		 
	}
}

