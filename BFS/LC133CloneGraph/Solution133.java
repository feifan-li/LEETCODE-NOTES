package BFS.LC133CloneGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution133 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    public static Node cloneGraph(Node node) {
        if(node==null) return null;
        Node[] clone = new Node[101];// also visited
        clone[node.val] = new Node(node.val);
        Queue<Node> originQ = new LinkedList<>();
        originQ.offer(node);
        while(!originQ.isEmpty()){
            Node u = originQ.poll();
            for(Node v:u.neighbors){
                if(clone[v.val]==null){//!visited
                    originQ.offer(v);
                    clone[v.val] = new Node(v.val);
                }
                clone[u.val].neighbors.add(clone[v.val]);
            }
        }
        return clone[node.val];
    }
    public static void printGraph(Node node){
        boolean[] visited = new boolean[101];
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited[node.val] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int cnt=0;cnt<size;++cnt){
                Node u = q.poll();
                System.out.print(u.val+": [");
                for(Node v:u.neighbors){
                    System.out.print(v.val+", ");
                    if(!visited[v.val]){
                        visited[v.val] = true;
                        q.offer(v);
                    }
                }
                System.out.println("]");
            }
        }
    }
    public static void main(String[] args) {
        Node s1 = new Node(1);
        Node s2 = new Node(2);
        Node s3 = new Node(3);
        Node s4 = new Node(4);
        s1.neighbors.add(s2);
        s1.neighbors.add(s4);
        s2.neighbors.add(s1);
        s2.neighbors.add(s3);
        s3.neighbors.add(s2);
        s3.neighbors.add(s4);
        s4.neighbors.add(s1);
        s4.neighbors.add(s3);
        Node s1Clone = cloneGraph(s2);
        printGraph(s2);
        System.out.println("------------------------");
        printGraph(s1Clone);
    }
}
