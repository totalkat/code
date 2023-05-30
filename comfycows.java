import java.util.*;
public class comfycows{
    public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	int cows = in.nextInt();
	in.nextLine();
	int count =0;
	Map<Integer,Integer> map = new HashMap<>();
	for(int i=0; i<cows; i++){
	    String info = in.nextLine();
	    StringTokenizer deftoken = new StringTokenizer(info);
	    int x = Integer.parseInt(deftoken.nextToken());
	    int y = Integer.parseInt(deftoken.nextToken());
	    count+=getconnect(x,y,map,true);
	    count+=getconnect(x+1,y,map,false);
	    count+=getconnect(x-1,y,map,false);
	    count+=getconnect(x,y+1,map,false);
	    count+=getconnect(x,y-1,map,false);
	    System.out.println(count);
	}
    }
    public static int getconnect(int x, int y, Map<Integer,Integer> map, boolean isnew){
	int neighbors=0;
	if(x<0 || y<0){
	    return 0;
	}
	int key =x*1000+y ;
	if(!(map.containsKey(key)) && !isnew){
	    return 0;
	}
	
	if(map.containsKey((x+1)*1000+y)){
	    neighbors++;
	}
	if( map.containsKey((x-1)*1000+y)){
	    neighbors++;
	}
	if(map.containsKey(x*1000+y+1)){
	    neighbors++;
	}
	if(map.containsKey(x*1000+y-1)){
	    neighbors++;
	}

	if(!(map.containsKey(key ))){
	    map.put(key ,neighbors);
	    if(neighbors==3){
		return 1;
	    }
	    else{
		return 0;
	    }
 	}
	else{
	    int prev = map.get(key);
	    map.put(key ,neighbors);
	    if(prev==3 && neighbors!=3){
		return -1;
	    }
	    else if(prev!=3 && neighbors==3){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
    }
}

