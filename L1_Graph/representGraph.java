// package L1_Graph;

/*
 Graph is represented using two ways:
 1. Adjacency List -> most commonly used
 2. Adjacency Matrix -> when number of vertices in graph<10000  
 */

//representing graph using adjacency list
import java.io.*;
import java.util.*;
public class representGraph{
    public static class Edge{
        int src; //source vertex 
        int nbr; //neighbour vertex
        int wt; //weight of the edge between source and neighbour vertex
        Edge(int src, int nbr, int wt){ //constructor
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args){
        int vertices = 7; 
        ArrayList<Edge>[] graph = new ArrayList[7]; 
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>(); //making a new arraylist for each element in the array
        }
        graph[0].add(new Edge(0, 1, 10)); //in the 0th element of graph(array of AL of edges), add arraylist of edge w/ src, nbr and weight
        graph[0].add(new Edge(0, 3, 40)); //0th vertex also connected to vertex 3 with edge weighted 40

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        for(int i=0; i<vertices; i++){
            System.out.println(graph[i]);
        }
    }
}