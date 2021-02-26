package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2477_참외밭 {

	public static void main(String[] args) throws Exception{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int K=Integer.parseInt(br.readLine());
		int[][] arr=new int[6][2];
		int[] v=new int[5];
		int smallw=0,smallh=0,area=1;
		for(int i=0;i<6;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int l=Integer.parseInt(st.nextToken());
			
			arr[i][0]=d;
			arr[i][1]=l;
			
			
		}
		
		for(int i=2;i<5;i++) {
			if(arr[i-2][0]==arr[i][0]&&arr[i-1][0]==arr[i+1][0]) {
				smallw=arr[i-1][1];
				smallh=arr[i][1];
				v[arr[i-1][0]]=1;
				v[arr[i][0]]=1;
				break;
				
			}
			else {
				if(arr[i-2][0]==arr[i][0] && i==2) {
					
					smallw=arr[0][1];
					smallh=arr[1][1];		
					v[arr[0][0]]=1;
					v[arr[1][0]]=1;
					break;
				}
				else if(arr[i-1][0]==arr[i+1][0] && i==4) {
					smallw=arr[4][1];
					smallh=arr[5][1];
					v[arr[4][0]]=1;
					v[arr[5][0]]=1;
					break;
				}
				
			}
				
		}
		if(smallw==0&&smallh==0) {
			smallw=arr[5][1];
			smallh=arr[0][1];
			v[arr[5][0]]=1;
			v[arr[0][0]]=1;
		}
		
		
		for(int i=1;i<=4;i++) {
			if(v[i]==0) {
				for(int j=0;j<6;j++) {
					if(arr[j][0]==i) {
						area*=arr[j][1];
					}
				}
			}
		}
		
		area=area-smallw*smallh;
		System.out.println(area*K);
	}

}
