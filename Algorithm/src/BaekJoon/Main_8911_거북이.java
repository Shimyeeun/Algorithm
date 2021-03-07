package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_8911_거북이 {

	static int xmax,xmin,ymax,ymin;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		String s="";
		
		for(int t=0;t<T;t++) {
			xmax=0;
			xmin=0;
			ymax=0;
			ymin=0;
			int x=0,y=0,d=0;
			s=br.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='F') {
					if(d==0) y++;
					else if(d==1) y--;
					else if(d==2) x--;
					else if(d==3) x++;
					rangecheck(x,y);
				}
				else if(s.charAt(i)=='B') {
					if(d==0) y--;
					else if(d==1) y++;
					else if(d==2) x++;
					else if(d==3) x--;
					rangecheck(x,y);
				}
				else if(s.charAt(i)=='R') {
					if(d==0) d=3;
					else if(d==1) d=2;
					else if(d==2) d=0;
					else if(d==3) d=1;
				}
				else if(s.charAt(i)=='L') {
					if(d==0) d=2;
					else if(d==1) d=3;
					else if(d==2) d=1;
					else if(d==3) d=0;
				}
			}
			
			int ans=Math.abs(xmax-xmin)*Math.abs(ymax-ymin);
			System.out.println(ans);
		}
		
	}
	
	public static void rangecheck(int x,int y) {
		xmax=Math.max(xmax, x);
		xmin=Math.min(xmin, x);
		ymax=Math.max(ymax, y);
		ymin=Math.min(ymin, y);		
	}

}
