package LinkedList.LC1472DesignBrowserHistory;
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
public class BrowserHistory {
    //Node for doubly-linked lists
    class Node{
        String domain;
        Node next;
        Node prev;
        Node(String domain){
            this.domain = domain;
            this.next = null;
            this.prev = null;
        }
        Node(String domain, Node next, Node prev){
            this.domain = domain;
            this.next = next;
            this.prev = prev;
        }
    }
    public Node root;
    public Node cur;
    public BrowserHistory(String homepage) {
        root = new Node(homepage);
        cur = root;
    }

    public void visit(String url) {
        if(cur.next!=null){
            Node curNext = cur.next;
            curNext.prev = null;
            cur.next = null;
        }
        Node newDomain = new Node(url);
        newDomain.prev = cur;
        cur.next = newDomain;
        cur = cur.next;
    }

    public String back(int steps) {
        while(cur.prev!=null && steps>0){
            cur = cur.prev;
            steps--;
        }
        return cur.domain;
    }

    public String forward(int steps) {
        while(cur.next!=null && steps>0){
            cur = cur.next;
            steps--;
        }
        return cur.domain;
    }
}
