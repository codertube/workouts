public class LinkedList {

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
    }

    public int getNode(int nodePosition) {
        Node current = head;
        for(int i = 0; i < nodePosition; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getNodeFromEnd(int nodePosition) {
        int nodeSize = getListSize();
        Node current = head;
        for(int i = 0; i < nodeSize - nodePosition; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getListSize() {
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count ++;
        }
        return count;
    }

    public int getNodeDataCount(int nodeData) {
        Node current = head;
        int nodeDataCount = 0;
        while (current != null) {
            if (current.data == nodeData) {
                nodeDataCount++;
            }
            current = current.next;
        }
        return nodeDataCount;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void printMiddleNode() {
        Node current = head;
        int size = getListSize();
        int middle = size / 2;
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }
        System.out.println("Middle node : " + current.data);
    }

    public boolean isCircular() {
        Node current = head;
        while (current != null && current.next != head) {
            current = current.next;
        }
        return current == head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.print();
        System.out.println("");
        list.append(30);
        list.print();
        System.out.println("Get node by index :: " + list.getNode(2));
        System.out.println("List size :: " + list.getListSize());
        System.out.println("Get node by index from end :: " + list.getNodeFromEnd(4));
        list.printMiddleNode();
        System.out.println("Node with Data:30 count :: " + list.getNodeDataCount(30));
        System.out.println("Is List circular :: " + list.isCircular());
    }
}
