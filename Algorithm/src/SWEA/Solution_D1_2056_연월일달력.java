package SWEA;
import java.io.*;

public class Solution_D1_2056_연월일달력 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String s=br.readLine();
			String year=s.substring(0,4);
			String month=s.substring(4,6);
			String day=s.substring(6,8);
			
			if(Integer.parseInt(month)<1 || Integer.parseInt(month)>12) {
				System.out.println("#"+t+" -1");
			}
			else {
				if(month.equals("02") && Integer.parseInt(day)>28) {
					System.out.println("#"+t+" -1");
				} 
				
				
				else if(month.equals("04") || month.equals("06")|| month.equals("09") || month.equals("11") ) {
					if(Integer.parseInt(day)>30) {
						System.out.println("#"+t+" -1");
					}
					else{
						System.out.println("#"+t+" "+year+"/"+month+"/"+day);
					}
				}
				
				else  {
					if(Integer.parseInt(day)>31) {
						System.out.println("#"+t+" -1");
					}
					else{
						System.out.println("#"+t+" "+year+"/"+month+"/"+day);
					}
				}			
			}
		}

	}

}
