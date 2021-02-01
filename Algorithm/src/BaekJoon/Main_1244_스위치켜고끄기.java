package BaekJoon;
import java.io.*;
import java.util.*;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {		
			
			sb.append(st.nextToken());		
		}
		
		int student=Integer.parseInt(br.readLine());
		for(int i=0;i<student;i++) {
			StringTokenizer s=new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(s.nextToken());
			int idx=Integer.parseInt(s.nextToken());
			int start=idx-1;
			int end=idx-1;
			if(gender==1) {
				for(int j=idx-1;j<sb.length();j++) {
					if((j+1)%idx==0) {
						if(sb.charAt(j)=='0') sb.setCharAt(j, '1');
						else sb.setCharAt(j, '0');
					}
				}
			}
			else {
				for(int j=1;j<sb.length()/2;j++) {
					if(idx-1-j>=0 && idx-1+j <sb.length() && sb.charAt(idx-1-j)==sb.charAt(idx-1+j)) {
						start=idx-1-j;
						end=idx-1+j; 
					} else {
						break;
					}
				}
				
				for(int j=start;j<=end;j++) {
					if(sb.charAt(j)=='0') sb.setCharAt(j, '1');
					else sb.setCharAt(j, '0');	
				}
				
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(sb.charAt(i)+" ");
			if((i+1)%20==0) {
				System.out.println();
			}
			
		}

	}

}
