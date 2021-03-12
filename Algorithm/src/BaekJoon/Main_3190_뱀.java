package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_3190_뱀 {
	
	static int[] dr= {-1,0,1,0},dc= {0,1,0,-1};
	static int time,N;
	static int[][] apple,snake;
	static char[] turn;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		
		apple=new int[N+1][N+1]; //사과가 있는 위치
		turn=new char[10001]; //방향 전환 확인 배열
		snake=new int[N+1][N+1]; //뱀 위치 
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int appleR=Integer.parseInt(st.nextToken());
			int appleC=Integer.parseInt(st.nextToken());
			
			apple[appleR][appleC]=1;
		}
		
		int L=Integer.parseInt(br.readLine());
		
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			char C=st.nextToken().charAt(0);
			
			turn[X]=C;
			
		}
		
		move(1,1,1);
		System.out.println(time);	
		
	}
	
	public static void move(int r,int c,int d) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while(true) {
			time++; // 시간 세주기
			r=r+dr[d]; //앞으로 이동
			c=c+dc[d];
			
			if(c>0 && c<=N && r>0 && r<=N && snake[r][c]==0 ) {
				if(apple[r][c]==1) { //사과가 있을 때
					q.offer(new int[] {r,c}); //머리 위치 삽입
					snake[r][c]=1; // 뱀 위치 저장
					apple[r][c]=0; // 사과를 먹으면 없어짐
				}
				else {
					q.offer(new int[] {r,c}); //머리 위치 삽입
					snake[r][c]=1; // 뱀 위치 저장
					int[] tail=q.peek(); //꼬리 위치 변수
					snake[tail[0]][tail[1]]=0; //꼬리가 위치한 칸 비우기
					q.poll(); //꼬리 위치 삭제					
				}
				
				
				if(turn[time]=='D') { //오른쪽으로 방향전환
					if(d<3) {
						d++;
					} else {
						d=0;
					}
				}
				else if(turn[time]=='L'){ //왼쪽으로 방향전환
					if(d>0) {
						d--;
					} else {
						d=3;
					}
				}
				
			}
			else {
				break;
			}
		}
		
	}
	
}
