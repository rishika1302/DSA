import java.util.*;

public class HashMapIntro {
    public static void main(String[] args){
      //pmap will have Integer values(population) against String keys(Country)
      HashMap<String, Integer> pmap = new HashMap<>(); 
      //System.out.println(pmap); //prints an empty hashmap pmap {}

      pmap.put("India", 130); //adds value 130 against key India
      pmap.put("UK", 90);
      pmap.put("Utopia", 0);
      pmap.put("China", 200);
      pmap.put("UK", 94); //updates value of "UK" to 94 from 90
      System.out.println(pmap);

      Integer ipop = pmap.get("India"); //retrieves value of key=India in Integer ipop
      System.out.println(ipop); //prints value 
      Integer cpop = pmap.get("China"); 
      System.out.println(cpop);

      boolean check = pmap.containsKey("US"); //checks if key US is present in pmap or not
      System.out.println("US - "+check); //prints false as US in not a key
      check = pmap.containsKey("UK"); 
      System.out.println("UK - "+check); //true as UK is a key in pmap

      //good practice
      Integer uspop = pmap.get("US"); //value of US is retrieved in Integer uspop
      System.out.println(uspop); //null -> since US is not a key in pmap, uspop gets 'null' inside it
      //bad practice
      //int USpop = pmap.get("US"); //value of US is retrieved in int USpop
      //Null Pointer Exception -> since US is not a key in pmap and int cant store null in it
      // System.out.println(USpop); 

      //use containsKey() before going for get()
      Integer val = pmap.get("US");
      if(pmap.containsKey("US")==true){
            System.out.println(val);
      }else{
            System.out.println(val + " as US is not a key in pmap.");
      }
      val = pmap.get("China");
      if(pmap.containsKey("China")==true){
            System.out.println("china population = "+val);
      }else{
            System.out.println(val + " as China is not a key in pmap.");
      }

      //print all keys from pmap using keySet()
      Set<String> keys = pmap.keySet(); 
      //the Set named keys will retrieve all keys from pmap in some random order which is uncontrollable and inpredictable
      for(String key : keys){ //String key gets values from Set 'keys' which are keys of pmap 
          System.out.println(key + "->" + pmap.get(key)); //prints key->value as we have retrieved the keys in the Set keys we can also access their values using get()
      }

      pmap.remove("China"); //to delete/remove the key China from pmap
      System.out.println(pmap);
  }  
}
