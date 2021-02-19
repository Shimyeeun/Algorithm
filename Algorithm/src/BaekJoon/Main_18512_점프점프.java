package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_18512_점프점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int P1=Integer.parseInt(st.nextToken());
		int P2=Integer.parseInt(st.nextToken());
		int ans=-1;
		
		int[] Xarr=new int[10000+1];
		int[] Yarr=new int[10000+1];
		
		for(int i=P1;i<Xarr.length;i+=X) {
			Xarr[i]=1;
		}
		for(int i=P2;i<Yarr.length;i+=Y) {
			Yarr[i]=1;
		}
		
		for(int i=0;i<Xarr.length;i++) {
			if(Xarr[i]==1 && Yarr[i]==1) {
				ans=i;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
