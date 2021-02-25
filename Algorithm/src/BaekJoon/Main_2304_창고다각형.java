package BaekJoon;

import java.util.*;
import java.io.*;

public class Main_2304_창고다각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[1002];
		int max=0,lastL=0,maxidx=0,cnt=0,maxcnt=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int H=Integer.parseInt(st.nextToken());
			arr[L]=H;
			
			if(arr[L]>max) {
				max=arr[L];
				maxidx=L;
			}
		}
		
		for(int i=0;i<=1002;i++) {
			if(arr[i]!=0) {
				cnt++;
			}
			
			if(cnt==N) {
				lastL=i;
				break;
			}
		}
		int currL=0,currH=0;
		int sum=0;
		for(int i=1;i<=maxidx;i++) {
			
			if(arr[i]>=currH) {
				if(arr[i]!=0&&arr[i]==currH) {
					maxcnt++;
				}
				sum=sum+currL*currH;
				currL=0;
				currH=arr[i];

			}
			currL++;
		}
		
		currL=0;
		currH=0;
		for(int i=lastL+1;i>=maxidx;i--) {
			if(arr[i]>=currH) {
				if(arr[i]!=0&&arr[i]==currH) {
					maxcnt++;
				}
				sum=sum+currL*currH;
				currL=0;
				currH=arr[i];
			}
			currL++;
		}
		
		sum+=max;
		if(maxcnt==N) {
			sum-=max;
		}
		System.out.println(sum);
		

	}

}
