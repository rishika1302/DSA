import java.util.*;
public class getCommonElement1 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements in first array : ");
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        System.out.print("Enter elements in first array : ");
        for(int i=0; i<n1; i++){
            arr1[i] = scn.nextInt();
        }
        System.out.print("Enter number of elements in second array : ");
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        System.out.print("Enter elements in second array : ");
        for(int i=0; i<n2; i++){
            arr2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int i=0; i<n1; i++){
            if(fmap.containsKey(arr1[i])==false){
                fmap.put(arr1[i], 1);
            }else{
                int oldf = fmap.get(arr1[i]);
                int newf = oldf+1;
                fmap.put(arr1[i], newf);
            }
        }
        
        for(int i=0; i<n2; i++){
            if(fmap.containsKey(arr2[i])==true){
                System.out.print(arr2[i] + " ");
                fmap.remove(arr2[i]);
            }
        }

        // HashMap<Integer, Integer> ans = new HashMap<>();
        // for(int i=0; i<n2; i++){
        //     if(fmap.containsKey(arr2[i])==true && ans.containsKey(arr2[i])==false){
        //         ans.put(arr2[i], 1);
        //     }
        // }
        // Set<Integer> k = ans.keySet();
        // for(Integer val : k){
        //     System.out.print(ans.get(k)+" ");
        // }
        scn.close();
    }
    
}
