package com.backspace.ds.list;

public class LinkedList {
    int length;
    private Node head;
    private Node tail;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head.next = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0)
            return null;
        if(length == 1) {
            Node removedNode = head;
            head = tail = null;
            length = 0;
            return removedNode;
        }

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        Node removedNode = temp.next;
        temp.next = null;
        tail = temp;
        length--;
        return removedNode;
    }

    public void prepend(int value) {
        Node prependNode = new Node(value);

        if(length == 0) {
            head = tail = prependNode;
        }
        else {
            Node temp = head;
            head = prependNode;
            head.next = temp;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if((index<0) || (index >= length))
            return null;
        Node temp = head;
        int ptr = 0;
        while(temp != null) {
            if(index == ptr) {
                return temp;
            }
            temp = temp.next;
            ptr++;
        }
        return null;
    }

    public boolean set(int index, int value) {
        Node newNode = get(index);
        if(newNode == null)
            return false;

        newNode.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length)
            return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length)
            return null;
        if(index == 0)
            return removeFirst();
        if(index == length-1)
            return removeLast();
        Node prevNode = get(index - 1);
        Node currentNode = prevNode.next;

        prevNode.next = currentNode.next;
        currentNode.next = null;
        length--;
        return currentNode;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i=0;i<length;i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        if(head == null)
            return null;

        Node slowPtr = head;
        Node fastPtr = head;
        while(fastPtr.next!=null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if(fastPtr.next != null)
            return slowPtr.next;
        return slowPtr;
    }

    public boolean hasLoop() {
        if(length == 0)
            return false;
        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                return true;
            slowPtr = slowPtr.next;
        }
        return  false;
    }

    public Node findKthFromEnd(int index) {
        if(index < 0 || head == null)
            return null;

        Node fastPtr = head;
        Node slowPtr = head;

        for(int i=0;i<index;i++) {
            if(fastPtr == null)
                return null;
            fastPtr = fastPtr.next;
        }

        while(fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public void partitionList(int x) {
        Node greaterNode = null;
        Node smallerNode = null;
        Node temp = head;

        if(head == null)
            return;

        while(temp.next != null) {
            if(temp.value < x) {
                if(smallerNode == null) {
                    smallerNode = new Node(temp.value);
                    head = smallerNode;
                } else {
                    smallerNode.next = temp;
                }
            } else {
                if(greaterNode == null) {
                    greaterNode = new Node(temp.value);
                } else {
                    greaterNode.next = temp;
                }
            }
            temp = temp.next;
        }

        if(smallerNode != null)
            smallerNode.next = greaterNode;
    }

    public void display() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public int getHeadValue() {
        return head.value;
    }

    public int getTailValue() {
        return tail.value;
    }

    public int getLength() {
        return length;
    }

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
