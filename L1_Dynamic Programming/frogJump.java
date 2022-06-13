import java.util.*;
public class frogJump {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=0; i<t; i++){
            int n = scn.nextInt();
            int[] height = new int[n];
            for(int j=0; j<n; j++){
                height[i] = scn.nextInt();
            }
            int ans = fj(n, height);
            System.out.println(ans);
        }
    }
    public static int fj(int n, int[] height){
        if(n == 0){
            return 0;
        }
        if(n>1){
            
        }
        return 0;
    }
}
