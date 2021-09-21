package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_20055_컨베이어벨트위의로봇 {

	static int N,K;
	static int[] arr;
	static boolean[] robot;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[2*N];
		robot=new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int ans=0;
		while(check()) {
			rotate();
			move();
			if(arr[0]!=0) {
				robot[0]=true;
				arr[0]--;
			}
			ans++;
		}
		System.out.println(ans);
	}
	
	public static void rotate() {
		int temp=arr[2*N-1];
		for(int i=2*N-2;i>=0;i--) {
			arr[i+1]=arr[i];
			
		}
		arr[0]=temp;
		
		for(int i=N-1;i>0;i--) {
			robot[i]=robot[i-1];
		}
		robot[0]=false;
		robot[N-1]=false;
		
	}
	public static void move() {
		
		for(int i=N-1;i>0;i--) {
			if(robot[i-1]&&!robot[i]&&arr[i]>=1) {
				robot[i]=true;
				robot[i-1]=false;
				arr[i]--;
			}
		}
		
	}
	public static boolean check() {
		int cnt=0;
		for(int i=0;i<2*N;i++) {
			if(arr[i]==0) {
				cnt++;
			}
		}
		
		if(cnt>=K) {
			return false;
		}
		
		return true;
		
	}

}
