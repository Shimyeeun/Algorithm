package BaekJoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] LSI=new int[N];
		int max=0;
		for(int i=0;i<N;i++) {
			LSI[i]=1;
			
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && LSI[i]<LSI[j]+1 ) {
					LSI[i]=LSI[i]+1;
				}
			}
			if(max<LSI[i]) {
				max=LSI[i];
			}
		}
		System.out.println(max);
			
	}

}
