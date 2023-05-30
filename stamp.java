
import java.io.*;
import java.util.*;
public class stamp{
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(in.readLine().trim());
	for(int i=0;i<n;i++){
	    int bs = Integer.parseInt(in.readLine().trim());
	    String[][] base = new String[bs][bs];
	    for(int j=0;j<bs;j++){
		for(int k=0; k<bs; k++){
		    String line = in.readLine().trim();
		    StringTokenizer st = new StringTokenizer(line);
		    while(st.hasMoreTokens()){
			base[j][k] = st.nextToken();
		    }
		}
	    }
	    int ss = Integer.parseInt(in.readLine().trim());
	    String[][] stamp = new String[ss][ss];
	    for(int j=0;j<ss;j++){
		for(int k=0; k<ss; k++){
		    String line = in.readLine().trim();
		    StringTokenizer st = new StringTokenizer(line);
		    while(st.hasMoreTokens()){
			stamp[j][k] = st.nextToken();
		    }
		}
	    }
	    in.readLine();
	    check(base,stamp,bs,ss);
	    rotate(stamp,ss);
	    check(base,stamp,bs,ss);
	    rotate(stamp,ss);
	    check(base,stamp,bs,ss);
	    rotate(stamp,ss);
	    check(base,stamp,bs,ss);
	    boolean found= true;
	    for(int a=0;a<bs; a++){
		for(int b=0;b<bs;b++){
		    if(base[a][b].equals("*")){
			found=false;
		    }
		}
		if(!found) break;
	    }
	    if(found){
		System.out.println("YES");
	    }
	    else{
		System.out.println("NO");
	    }


	}
    }
    public static void check(String[][] base, String[][] stamp, int bs, int ss){
	for(int a= 0; a<bs-ss; a++){
	    for(int b=0; b<bs-ss;b++){
		boolean notwork = false;
		for(int c=0; c<ss; c++){
		    for(int d=0; d<ss; d++){
			if(stamp[c][d].equals("*")&&base[a][b].equals(".")){
			    notwork=true;
			    break;
			}
		    }
		    if(notwork) break;
		}
		if(!notwork){
		    for(int c=0; c<ss; c++){
			for(int d=0; d<ss; d++){
			    if(stamp[c][d].equals("*")&&base[a][b].equals("*")){
				base[a][b]="1";
			    }
			}
		    }
		}
	    }
	}
    }
    public static void rotate(String a[][], int N)
    {
	for (int i = 0; i < N / 2; i++)
	    {
		for (int j = i; j < N - i - 1; j++)
		    {
			String temp = a[i][j];
			a[i][j] = a[N - 1 - j][i];
			a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
			a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
			a[j][N - 1 - i] = temp;
		    }
	    }
    }
}

