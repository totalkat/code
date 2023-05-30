import java.util.*;
public class goodgrass{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int[] u = new int[4];
	int[] h = new int[4];
	int[] g = new int[4];
	int largest = -1000;
	for(int i=0; i<4; i++){
	    int uhcoord = in.nextInt();
	    u[i]=uhcoord;
	}
	for(int i=0; i<4; i++){
	    int hcoord = in.nextInt();
	    h[i]=hcoord;
	}
	for(int i=0; i<4; i++){
	    int gcoord = in.nextInt();
	    g[i]=gcoord;
	}
	boolean[][] all = new boolean[largestx(u,h,g)-smallestx(u,h,g)][largesty(u,h,g)-smallesty(u,h,g)];
	int smallx = smallestx(u,h,g);
	int smally = smallesty(u,h,g);
	for(int i=h[0]; i<h[2]; i++){
	    for(int j=h[1]; j<h[3];j++){
		all[i-smallx][j-smally]=true;
	    }
	}
	for(int i=u[0]; i<u[2]; i++){
	    for(int j=u[1]; j<u[3];j++){
		all[i-smallx][j-smally]=true;
	    }
	}
	int counter =0;
	for(int i=g[0]; i<g[2]; i++){
	    for(int j=g[1]; j<g[3];j++){
		all[i-smallx][j-smally]=false;
	    }
	}
	for (int i = 0; i < all.length; i++) {
	    for (int j = 0; j < all[0].length; j++) {
		if (all[i][j]) {
		    counter++;
		}			
	    }
	}
	System.out.println(counter);
    }
    public static int largestx(int[] a1,int[] a2,int[] a3){
	int largest = Math.max(a1[2],a2[2]);
	return Math.max(largest,a3[2]);
    }
    public static int smallestx(int[] a1,int[] a2,int[] a3){
	int smallest = Math.min(a1[0],a2[0]);
	return Math.min(smallest,a3[0]);
    }
    public static int smallesty(int[] a1,int[] a2,int[] a3){
	int smallest = Math.min(a1[1],a2[1]);
	return Math.min(smallest,a3[1]);
    }
    public static int largesty(int[] a1,int[] a2,int[] a3){
	int largest = Math.max(a1[3],a2[3]);
	return Math.max(largest,a3[3]);
    }

}

    
