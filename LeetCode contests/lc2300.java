import java.util.*;
public class lc2300 {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int[] pairs = new int[spells.length];
            for(int i=0; i<spells.length; i++){
                for(int j=0; j<potions.length; j++){
                    if(spells[i]*potions[j]>=success){
                        pairs[i]++;
                    }
                }
            }
            return pairs;
        }
    
}
