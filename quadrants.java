import java.util.*;
public class quadrants{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int cows = in.nextInt();
	int integers = in.nextInt();
	int[] xmin = new int[cows];
	int[] ymin = new int[cows];
	int[] x = new int[cows];
	int[] y = new int[cows];
	for(int i=0; i<cows; i++){
	    int coordx = in.nextInt();
	    xmin[i] = coordx;
	    x[i] = coordx;
	    int coordy = in.nextInt();
	    ymin[i] = coordy;
	    y[i] = coordy;
	}
	int max = 101;
	for(int i=0; i<cows; i++){
	    int xdivide = getmin(xmin);
	    int ydivide = getmin(ymin);
	    int reg1=countcows(x,y,0,xdivide,0,ydivide,cows);
	    int reg2=countcows(x,y,xdivide,integers,0,ydivide,cows);
	    int reg3=countcows(x,y,xdivide,integers,ydivide,integers,cows);
	    int reg4=countcows(x,y,0,xdivide,ydivide,integers,cows);
	    int largest1 = Math.max(reg1,reg2);
	    int largest2 = Math.max(reg3,reg4);
	    if(Math.max(largest1,largest2)<max){
		max = Math.max(largest1,largest2);
	    }
	}
	System.out.println(max);
    }
    public static int getmin(int[] arr){
	int min = 1000001;
	int idx = 0;
	for(int i=0; i<arr.length; i++){
	    if(arr[i]<min){
		min = arr[i];
		idx=i;
	    }
	}
	arr[idx] = 1000001;
	return min+1;
    }
    public static int countcows(int[] x, int[] y, int xlow, int xhigh,int ylow, int yhigh, int cows){
	int counter=0;
	for(int i=0; i<cows;i++){
	    if((xlow<x[i] && x[i]<xhigh) && (ylow<y[i] && y[i]<yhigh)){
		counter++;
	    }
	}
	return counter;
    }
}
