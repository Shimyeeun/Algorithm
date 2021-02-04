package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_16935_배열돌리기3 {

	public static int[][] one(int[][] arr) {
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length;j++) {
				int temp=arr[i][j];
				arr[i][j]=arr[arr.length-i-1][j];
				arr[arr.length-i-1][j]=temp;		
			}
		}
		return arr;		
	}
	
	public static int[][] two(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				int temp=arr[i][j];
				arr[i][j]=arr[i][arr[0].length-j-1];
				arr[i][arr[0].length-j-1]=temp;
			}
		}
		return arr;
	}
	
	public static int[][] three(int[][] arr) {
		int[][] arr2=new int[arr[0].length][arr.length];
		for(int i=0;i<arr[0].length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr2[i][j]=arr[arr.length-j-1][i];
			}
		}
		return arr2;
	}
	
	public static int[][] four(int[][] arr) {
		int[][] arr2=new int[arr[0].length][arr.length];
		for(int i=0;i<arr[0].length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr2[i][j]=arr[j][arr[0].length-i-1];
			}
		}
		return arr2;
	}
	
	public static int[][] five(int[][] arr) {
		int[][] arr2=new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				arr2[i][j+arr[0].length/2]=arr[i][j];
			}
		}
		
		for(int i=0;i<arr.length/2;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				arr2[i+arr.length/2][j]=arr[i][j];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				arr2[i][j-(arr[0].length/2)]=arr[i][j];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				arr2[i-(arr.length/2)][j]=arr[i][j];
			}
		}
		return arr2;
	}
	
	public static int[][] six(int[][] arr) {
		int[][] arr2=new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				arr2[i+arr.length/2][j]=arr[i][j];
			}
		}
		
		for(int i=0;i<arr.length/2;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				arr2[i][j-(arr[0].length/2)]=arr[i][j];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=arr[0].length/2;j<arr[0].length;j++) {
				arr2[i-(arr.length/2)][j]=arr[i][j];
			}
		}
		
		for(int i=arr.length/2;i<arr.length;i++) {
			for(int j=0;j<arr[0].length/2;j++) {
				arr2[i][j+arr[0].length/2]=arr[i][j];
			}
		}
		return arr2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int R=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
				
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int num=Integer.parseInt(st.nextToken());
			switch(num) {
			case 1:
				arr=one(arr);
				break;
			case 2:
				arr=two(arr);
				break;
			case 3:
				arr=three(arr);
				break;
			case 4:
				arr=four(arr);
				break;
			case 5:
				arr=five(arr);
				break;
			default:
				arr=six(arr);
				break;
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
