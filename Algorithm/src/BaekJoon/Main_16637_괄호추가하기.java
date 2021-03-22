package BaekJoon;
import java.io.*;
public class Main_16637_괄호추가하기 {
	static int N,max=Integer.MIN_VALUE;
	static String s;
	static char[] op;
	static int[] num;


	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		s=br.readLine();
		
		op=new char[N/2];
		num=new int[N/2+1];
		
		for(int i=0;i<s.length();i++) {
			if(i%2==1) {
				op[i/2]=s.charAt(i);
			}
			else {
				num[i/2]=(int)s.charAt(i)-48;
			}
		}
		calc(0,num[0]);
		
		System.out.println(max);

	}
	
	public static void calc(int idx,int a) {
		if(idx==op.length) {
			max=Math.max(max, a);
			return;
		}
		
		int res=opCal(idx,a,num[idx+1]);
		calc(idx+1,res);
		if(idx+1<op.length) {
			res=opCal(idx,a,opCal(idx+1,num[idx+1],num[idx+2]));
			calc(idx+2,res);			
		}
			
	}
	
	public static int opCal(int idx,int num1,int num2) {
		if(op[idx]=='+') return num1+num2;
		else if(op[idx]=='-') return num1-num2;
		else if(op[idx]=='*') return num1*num2;
		return 0;
	}

}
