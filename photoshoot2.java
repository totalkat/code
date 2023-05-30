import java.util.*;
import java.io.*;
public class photoshoot2{
    public static void main(String[] args) throws Exception{
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	in.nextLine();
	int[] given = new int[N];
	for(int i=0; i<N; i++){
	    int a = in.nextInt();
	    given[i] = a;
	}
	int[] ideal = new int[N];
	for(int i=0; i<N; i++){
	    int inp = in.nextInt();
	    ideal[i] = inp;
	}
	int[] match = new int[N];
	boolean matched = false;
	int ans =0;
	int fault=0;
	int[] holder = new int[2];
	while(matched==false){
	    holder =getmatch(ideal,given);
	    if(holder[0]==1){
		matched=true;
		break;
	    }
	    else{
		int want = holder[1];
		int need = 0;
		for(int i=0; i<given.length;i++){
		    if(given[i]==ideal[want]){
			need = given[i];
		    }
		}
		// System.out.println("-"+need + " " + fault);
		shiftright(given,need,want);
		// System.out.println(Arrays.toString(given));
		ans++;
	    }
	}
	System.out.println(ans);
    }
    public static int[] getmatch(int[] ideal, int[] start){
	int[] holder = new int[2];
	boolean same = true;
	for(int i=0; i<ideal.length;i++){
	    if(ideal[i]!=start[i]){
		holder[1]=i;
		same=false; 
		break;
	    }
	}
	if(same){
	    holder[0]=1;
	}
	else{
	    holder[0]=0;
	}
	return holder;
    }
    public static void shiftright(int[] arr, int num, int ideal){
	for(int i=(arr.length)-1; i>ideal; i--){
	    int get = arr[i-1];
	    arr[i]=get;
	}
	arr[ideal]=num;
	    
    }
}
