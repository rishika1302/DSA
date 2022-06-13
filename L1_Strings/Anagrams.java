package Strings;

import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
public class Anagrams {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        if(areAnagrams(s1, s2)){
            System.out.println("strings are anagrams.");
        }else{
            System.out.println("not anagrams.");           
        }
    }
    public static boolean areAnagrams(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0; i<a.length(); i++){
            if(hmap.containsKey(a.charAt(i))){
                hmap.put(a.charAt(i), hmap.get(a.charAt(i))+1);
            }else{
                hmap.put(a.charAt(i), 1);
            }
        }
        for(int i=0; i<b.length(); i++){
            if(hmap.containsKey(b.charAt(i))){
                hmap.put(b.charAt(i), hmap.get(b.charAt(i))-1);
            }
        }
        Set<Character> keys = hmap.keySet();
        for(Character key: keys){
            if(hmap.get(key) !=0 ){
                return false;
            }
        }
        return true;
    }
}
