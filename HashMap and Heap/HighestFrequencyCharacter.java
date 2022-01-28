import java.util.*;

public class HighestFrequencyCharacter {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String s = scn.nextLine();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(fmap.containsKey(s.charAt(i))==false){
                fmap.put(s.charAt(i), 1);
            }else{
                int oldfreq = fmap.get(s.charAt(i));
                int newfreq = oldfreq+1;
                fmap.put(s.charAt(i), newfreq);
            }
        }
        Character max = s.charAt(0);
        Set<Character> keys = fmap.keySet();
        for(Character key : keys){
            if(fmap.get(key)>fmap.get(max)){
                max = key;
            }
        }        
        System.out.println("Max frequency is of " + max);
    }    
}
