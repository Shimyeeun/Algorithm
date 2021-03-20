package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17281_야구 {

	static int N;
	static int[][] arr;
	static boolean[] v;
	static int[] sel;
	static int max=0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][10];
		v=new boolean[10];
		sel=new int[9];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sel[3]=1;
		
		perm(0);
		
		System.out.println(max);
		

	}

	public static void perm(int cnt) {
		if(cnt==sel.length) {
			play();
			return;
		}
		
		for(int i=2;i<10;i++) {
			if(cnt==3) {
				cnt++;
				i--;
				continue;
			}
			if(!v[i]) {
				v[i]=true;
				sel[cnt]=i;					
				perm(cnt+1);
				v[i]=false;					
			}
		}
		
	}
	
	public static void play() {
		
		int j=0;
		int out=0;
		int score=0;
		for(int i=0;i<N;i++) {
			int[] base=new int[3];
			out=0;
			
			while(out<3){
				
				int curr=arr[i][sel[j]];
				if(curr==0) {
					out++;
				}
				else if(curr==1) {
					if(base[2]==1) score++;
					base[2]=base[1];
					base[1]=base[0];
					base[0]=1;
				} 
				else if(curr==2) {
					if(base[2]==1) score++;
					if(base[1]==1) score++;
					base[2]=base[0];
					base[1]=1;
					base[0]=0;
				}
				else if(curr==3) {
					if(base[2]==1) score++;
					if(base[1]==1) score++;
					if(base[0]==1) score++;
					base[2]=1;
					base[1]=0;
					base[0]=0;
				}
				else {
					if(base[2]==1) score++;
					if(base[1]==1) score++;
					if(base[0]==1) score++;
					score++;
					for(int k=0;k<3;k++) {
						base[k]=0;
					}
				}
				
				j++;
				if(j==9) {
					j=0;
				}


			}
			
		}
		
		max=Math.max(max, score);
		
	}
}
