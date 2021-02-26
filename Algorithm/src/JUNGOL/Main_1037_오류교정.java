package JUNGOL;
import java.util.*;
import java.io.*;

public class Main_1037_오류교정 {
	
	static int n,chi,chj;
	
	
	public static boolean parityCheck(int[][] arr) {
		
		
		for(int i=1;i<=n;i++) {
			int rsum=0;
			int csum=0;
			for(int j=1;j<=n;j++) {
				rsum+=arr[i][j];
				csum+=arr[j][i];
			}
			
			if(rsum%2!=0 || csum%2!=0) return false;			
		}
		
		return true;	
		
	}
	
	public static boolean change(int[][] arr) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==1) {
					arr[i][j]=0;
					if(parityCheck(arr)) {
						chi=i;
						chj=j;
						return true;
					}
					else {
						arr[i][j]=1;						
					}
				}
				else {
					arr[i][j]=1;
					if(parityCheck(arr)) {
						chi=i;
						chj=j;
						return true;
					}
					else {
						arr[i][j]=0;						
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		if(!parityCheck(arr)) {
			if(change(arr)) {
				System.out.println("Change bit ("+chi+","+chj+")");
			}
			else {
				System.out.println("Corrupt");
			}
		}
		else {
			System.out.println("OK");
		}

	}

}
