package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16506_CPU {

	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		String[][] arr=new String[N][4];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				arr[i][j]=st.nextToken();
			}
		}
		
		for(int i=0;i<N;i++) {
			opcode(arr[i][0]);
			if(lastCheck(arr[i][0])) sb.append(1);
			else sb.append(0);
			sb.append(0);
			String rD=String.format("%03d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(arr[i][1]))));
			sb.append(rD);
			String rA=String.format("%03d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(arr[i][2]))));
			sb.append(rA);
			if(!lastCheck(arr[i][0])) {
				String rB=String.format("%03d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(arr[i][3]))));
				sb.append(rB+"0");
			} else {
				String C=String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(arr[i][3]))));
				sb.append(C);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static void opcode(String s) {
		if(s.contains("ADD")) sb.append("0000");
		else if(s.contains("SUB")) sb.append("0001");
		else if(s.contains("MOV")) sb.append("0010");
		else if(s.contains("AND")) sb.append("0011");
		else if(s.contains("OR")) sb.append("0100");
		else if(s.contains("NOT")) sb.append("0101");
		else if(s.contains("MULT")) sb.append("0110");
		else if(s.contains("LSFTL")) sb.append("0111");
		else if(s.contains("LSFTR")) sb.append("1000");
		else if(s.contains("ASFTR")) sb.append("1001");
		else if(s.contains("RL")) sb.append("1010");
		else if(s.contains("RR")) sb.append("1011");

	}
	
	public static boolean lastCheck(String s) {
		if(s.charAt(s.length()-1)!='C') return false;
		else if(s.charAt(s.length()-1)=='C') return true;
		return false;
	}

}
