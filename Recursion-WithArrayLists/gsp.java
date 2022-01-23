import java.io.*;
import java.util.*;
public class gsp{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> gsp = getStairPaths(n);
        System.out.println(gsp);
    }

    public static ArrayList<String> getStairPaths(int n){
        if(n<0){
            ArrayList<String> bpath = new ArrayList<>();
            return bpath;
        }else if(n==0){
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }

        ArrayList<String> pathsfromnm1 = getStairPaths(n-1);
        ArrayList<String> pathsfromnm2 = getStairPaths(n-2);
        ArrayList<String> pathsfromnm3 = getStairPaths(n-3);

        ArrayList<String> pathsfromn = new ArrayList<>();
        for(String pathfromnm1: pathsfromnm1){
            String pathfromn = "1" + pathfromnm1;
            pathsfromn.add(pathfromn);
        }
        for(String pathfromnm2: pathsfromnm2){
            String pathfromn = "2" + pathfromnm2;
            pathsfromn.add(pathfromn);
        }
        for(String pathfromnm3: pathsfromnm3){
            String pathfromn = "3" + pathfromnm3;
            pathsfromn.add(pathfromn);
        }
        return pathsfromn;
    }
}