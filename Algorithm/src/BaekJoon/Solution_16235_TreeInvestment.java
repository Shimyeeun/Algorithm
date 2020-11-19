package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_16235_TreeInvestment {

	public static int[] di= {-1,-1,-1,0,1,1,1,0};
	public static int[] dj= {-1,0,1,1,1,0,-1,-1};
	public static int n;
	public static int[][] arr,nutri,deadtree;
	public static ArrayList<Integer> tree[][];
	public static void spring() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				deadtree[i][j]=0;
				for(int k=0;k<tree[i][j].size();) {
					if(nutri[i][j]-tree[i][j].get(k)>=0) {
						nutri[i][j]=nutri[i][j]-tree[i][j].get(k);
						tree[i][j].set(k, tree[i][j].get(k)+1);
						k++;
					} else {
						deadtree[i][j]=deadtree[i][j]+tree[i][j].get(k)/2;
						tree[i][j].remove(k);
					}
				}
				
				nutri[i][j]=nutri[i][j]+deadtree[i][j];
			}
		}
	}
	
	public static void fall() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				for(int k=0;k<tree[i][j].size();k++) {
					
					if(tree[i][j].get(k)%5==0) {
						for(int l=0;l<8;l++) {
							int ni=i+di[l];
							int nj=j+dj[l];
							
							if(ni>=0 && nj>=0 && ni<n && nj<n) {
								tree[ni][nj].add(0,1);
							}
						}
					}
				}
			}
		}
	}
	
	public static void winter() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				nutri[i][j]=nutri[i][j]+arr[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		nutri=new int[n][n];
		arr=new int[n][n];
		deadtree=new int[n][n];
		tree=new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer s=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(s.nextToken());
				tree[i][j]=new ArrayList<>();
				nutri[i][j]=5;
			}
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer str=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(str.nextToken());
			int c=Integer.parseInt(str.nextToken());
			int z=Integer.parseInt(str.nextToken());
			tree[r-1][c-1].add(z);
		}
		
		for(int i=0;i<k;i++) {
			spring();
			fall();
			winter();
		}
		
		int treecnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				treecnt=treecnt+tree[i][j].size();
			}
		}
		
		System.out.println(treecnt);
	}

}
