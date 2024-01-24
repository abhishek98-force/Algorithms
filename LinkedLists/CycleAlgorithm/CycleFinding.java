import java.util.HashSet;
import java.util.Set;

public class CycleFinding {

    public static void main(String agrs[]){
        Node n1  = new Node("Data 1");
        Node n2 = new Node("Data 2");
        Node n3 = new Node("Data 3");
        Node n4 = new Node("Data 4");
        Node n5 = new Node("Data 5");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        Node head = n1;
        System.out.println(findCycleByBruteForce(head));
        //System.out.println(findCycleUsingHashMap(head));
//        System.out.println(findCycleUsingFlyods(head));
    }

    public static boolean findCycleByBruteForce(Node outer){
        int numNodesTraversedByOuter = 0;
        Node outerCopy = outer;
        Node inner = outerCopy;

        while(outer != null){
            outer = outer.next;
            numNodesTraversedByOuter++;
            int k = numNodesTraversedByOuter;
            while(k>0){
                if(inner == outer){
                    return true;
                }
                inner = inner.next;
                k--;
            }
            inner = outerCopy;
        }
        return false;
    }

    public static boolean findCycleUsingHashMap(Node head){
        Set<Node> data = new HashSet<Node>();
        Node temp = head;
        while(temp != null){
            if(data.contains(temp)){
                return true;
            }
            data.add(temp);
        }
        return false;
    }

    public static boolean findCycleUsingFlyods(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


}
