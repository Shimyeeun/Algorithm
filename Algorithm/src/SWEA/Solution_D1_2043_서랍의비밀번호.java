package SWEA;
import java.io.*;
import java.util.*;

public class Solution_D1_2043_서랍의비밀번호{

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int p=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int ans=p-k+1;
		System.out.println(ans);
	}

}
