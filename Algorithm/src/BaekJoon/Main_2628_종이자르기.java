package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_2628_종이자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		int[] widx=new int[w+1];
		int[] hidx=new int[h+1];
		int n=Integer.parseInt(br.readLine());
		int ans=0,wcnt=0,hcnt=0,maxW=0,maxH=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int wh=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			
			if(wh==0) {
				hidx[num]=1;
				
			}
			else {
				widx[num]=1;
			}
			
		}
		widx[w]=1;
		hidx[h]=1;
		for(int j=1;j<=w;j++) {
			wcnt++;
			if(widx[j]==1) {
				maxW=Math.max(maxW, wcnt);
				wcnt=0;
			}
		}
		
		for(int j=1;j<=h;j++) {
			hcnt++;
			if(hidx[j]==1) {
				maxH=Math.max(maxH,hcnt);
				hcnt=0;
			}
		}
		ans=maxW*maxH;
		System.out.println(ans);
		

	}

}
