import java.util.*;
public class getCommonElements2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of array1 : ");
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements in array1 : ");
        for(int i=0; i<n1; i++){
            arr1[i] = scn.nextInt();
        }
        System.out.println("Enter size of array2 : ");
        int n2 = scn.nextInt();
        int[] arr2 = new int[n1];
        System.out.println("Enter elements in array2 : ");
        for(int i=0; i<n1; i++){
            arr2[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(fmap.containsKey(arr1[i])==false){
                fmap.put(arr1[i], 1);
            }else{
                Integer oldf = fmap.get(arr1[i]);
                Integer newf = oldf+1;
                fmap.put(arr1[i], newf);
            }
        }
        for(int i=0; i<arr2.length; i++){
            if(fmap.containsKey(arr2[i]) == true && fmap.get(arr2[i])>0){
                System.out.print(arr2[i]+" ");
                Integer oldf = fmap.get(arr2[i]);
                Integer newf = oldf-1;
                fmap.put(arr2[i], newf);
            }
        }
    }
}

