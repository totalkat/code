import java.util.*;
public class cowyear{
    public static void main(String[] args){
	Map<String, Integer> map = new HashMap<>();
	Map<String, String> animalmap = new HashMap<>();
	Scanner in  = new Scanner(System.in);
	int lines = in.nextInt();
	in.nextLine();
	map.put("Bessie",0);
	animalmap.put("Bessie","Ox");
	for(int i=0; i<lines; i++){
	    String line = in.nextLine();
	    String[] words = line.split(" ");
	    if(words[3].equals("previous")){
		if(getplace(words[4])<getplace(animalmap.get(words[7]))){
		    map.put(words[0],map.get(words[7])-((getplace(animalmap.get(words[7])))-getplace(words[4])));
		}
		else if(getplace(words[4])>getplace(animalmap.get(words[7]))){
		    map.put(words[0],map.get(words[7])-(Math.abs(getplace(animalmap.get(words[7]))+(12-getplace(words[4])))));
		}
		else{
		    map.put(words[0],map.get(words[7])-12);
		}
	    }
	    else{
		if(getplace(words[4])<getplace(animalmap.get(words[7]))){
		    map.put(words[0],map.get(words[7])+(12-getplace(animalmap.get(words[7]))+getplace(words[4])));
		}
		else if(getplace(words[4])>getplace(animalmap.get(words[7]))){
		    map.put(words[0],map.get(words[7])+getplace(words[4])-getplace(animalmap.get(words[7])));
		}
		else{
		    map.put(words[0],map.get(words[7])+12);
		}
		
	    }
	    animalmap.put(words[0],words[4]);
	    if(words[0].equals("Elsie")){
		System.out.println(Math.abs(map.get("Elsie")));
		break;
	    }	
	}
    }
    public static int getplace(String animal){
	String[] animals = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
	for(int i=0; i<animals.length; i++){
	    if(animals[i].equals(animal)){
		return i;
	    }
	}
	return -1;
    }
}
