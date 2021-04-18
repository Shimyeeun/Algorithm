package BaekJoon;
import java.io.*;
public class Main_3568_iSharp {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		
		String[] arr=s.split(" ");
		
		for(int i=1;i<arr.length;i++) {
			String var=arr[0];
			String name="";
			for(int j=0;j<arr[i].length();j++) {
				if(arr[i].charAt(j)=='['||arr[i].charAt(j)=='*'||arr[i].charAt(j)=='&'||arr[i].charAt(j)==','||arr[i].charAt(j)==';') {
					break;
				}
				else {
					name+=Character.toString(arr[i].charAt(j));
				}
			}
			for(int j=arr[i].length()-2;j>0;j--) {
				if(arr[i].charAt(j)=='['||arr[i].charAt(j)==']'||arr[i].charAt(j)=='*'||arr[i].charAt(j)=='&') {
					if(arr[i].charAt(j)=='[') {
						var+="]";
					}
					else if(arr[i].charAt(j)==']'){
						var+="[";
					}
					else {
						var+=Character.toString(arr[i].charAt(j));											
					}
				}
				
				else {
					break;
				}
			}
			
			System.out.println(var+" "+name+";");
		}
		

	}

}
