package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		String s=br.readLine();
		
		Double[] alphabet=new Double[N];
		for(int i=0;i<N;i++) {
			alphabet[i]=(double)Integer.parseInt(br.readLine()); // 소수점둘째자리까지 나타내줘야하기때문에 double로 값을 바꿔줌
		}
		
		Stack<Double> stack=new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				int idx=s.charAt(i)-'A';
				stack.push(alphabet[idx]); // 알파벳일 경우에만 스택에 삽입	
			}
			else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/') {
				double num1=stack.pop();
				double num2=stack.pop();
				char op=s.charAt(i);
				
				if(op=='+') stack.push(num1+num2);				
				else if(op=='-') stack.push(num2-num1); // 나중에 pop한 num2에서 빼줘야 한다
				else if(op=='*') stack.push(num1*num2);
				else if(op=='/') stack.push(num2/num1); // 나중에 pop한 num2를 num1으로 나눠야 한다
								
			}
		}
		
		System.out.println(String.format("%.2f",stack.pop())); // 소수점 둘째자리까지 표시

	}

}
