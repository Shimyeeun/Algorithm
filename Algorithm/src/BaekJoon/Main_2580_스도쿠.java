package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2580_스도쿠 {

	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		arr=new int[9][9];
		
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		fill(0,0);
		

	}
	
	public static void fill(int r,int c) {
		if(c==9){
			fill(r+1,0);
			return;
		}
		
		if(r==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		if(arr[r][c]==0) {
			for(int i=1;i<=9;i++) {
				if(sudoku(r,c,i)) {
					arr[r][c]=i;
					fill(r,c+1);
				}
				
			}
			arr[r][c]=0;
			return;
		}
		
		fill(r,c+1);
			
	}
	
	public static boolean sudoku(int r,int c,int val) {
		for(int i=0;i<9;i++) {
			if(arr[r][i]==val) {
				return false;
			}
		}
		
		for(int i=0;i<9;i++) {
			if(arr[i][c]==val) {
				return false;
			}
		}
		
		int sr=r/3*3;
		int sc=c/3*3;
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(arr[i][j]==val) {
					return false;
				}
			}
		}
		
		return true;
		
	}

	
}
