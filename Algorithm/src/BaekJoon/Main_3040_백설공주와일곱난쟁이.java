package BaekJoon;
import java.io.*;
public class Main_3040_백설공주와일곱난쟁이 {

	static int[] sel,arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		arr=new int[9];
		sel=new int[7];
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		combination(0,0);		
		System.out.println(sb.toString());
	}
	
	public static void combination(int cnt,int start) {
		if(cnt==sel.length) {
			int sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			
			if(sum==100) {
				for(int i=0;i<sel.length;i++) {
					sb.append(sel[i]+"\n");
				}
			}
			
			return;			
		}
		
		for(int i=start;i<arr.length;i++) {
			sel[cnt]=arr[i];
			combination(cnt+1,i+1);
		}
	}

}
