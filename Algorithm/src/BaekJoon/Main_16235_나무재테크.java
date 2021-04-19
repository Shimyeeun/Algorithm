package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16235_나무재테크 {

	static int N,M,K;
	static int[][] A,nutri,deadtree;
	static ArrayList<Integer>[][] tree;
	static int[] dr= {-1,-1,-1,0,0,1,1,1},dc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		A=new int[N+1][N+1];
		nutri=new int[N+1][N+1];
		deadtree=new int[N+1][N+1];
		tree=new ArrayList[N+1][N+1]; // 나무를 배열에 리스트로 관리
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
				tree[i][j]=new ArrayList<>();
				nutri[i][j]=5;
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			tree[x][y].add(z);
		}
		for(int i=0;i<K;i++) {
			spring();
			summer();
			autumm();
			winter();
		}
		
		// 남아있는 나무 카운트
		int cnt=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				cnt+=tree[i][j].size();
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static void spring() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=0;k<tree[i][j].size();k++) {
					if(tree[i][j].get(k)<=nutri[i][j]) { // 나무 나이가 양분의 수보다 적으면
						nutri[i][j]-=tree[i][j].get(k); // 나무가 양분을 먹고
						tree[i][j].set(k,tree[i][j].get(k)+1); // 나이 한살 더
					}
					else {
						deadtree[i][j]+=tree[i][j].get(k)/2; // 죽은 나무 배열에 저장
						tree[i][j].remove(k);
						k--;
					}
				}
			}
		}
		
	}
	
	public static void summer() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				nutri[i][j]+=deadtree[i][j]; // 양분 배열에 죽은나무의 양분을 더해준다
			}
		}
		deadtree=new int[N+1][N+1]; // 죽은 나무 배열 초기화
	}
	
	public static void autumm() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=0;k<tree[i][j].size();k++) {
					if(tree[i][j].get(k)%5==0) { // 나이가 5의 배수일 떄
						for(int l=0;l<8;l++) {
							int nr=i+dr[l];
							int nc=j+dc[l];
							
							if(nr>0 && nc>0 && nr<=N && nc<=N) {
								tree[nr][nc].add(0,1); // 어린나무순으로 양분을 먹어야하므로 0번인덱스에 삽입(한살이 가장 어린 나무)
							}
						}
						
					}
				}
			}
		}
	}
	
	public static void winter() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				nutri[i][j]+=A[i][j]; // 양분 더하기
			}
		}
	}

}
