package com.backspace.ds.list;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(3);
//        printValues(list);

        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);
//        System.out.println("After append---");
        printValues(list);

        /*System.out.println("GET index");
        LinkedList.Node node = list.get(1);
        if(node!=null)
            System.out.println(node.value);
        else
            System.out.println("Node is null");

        System.out.println("========Remove Last============");
        list.removeLast();
        printValues(list);

        System.out.println("=====PREPEND Node");
        list.prepend(1);
        printValues(list);

        System.out.println("-----Remove First----");
        list.removeFirst();
        printValues(list);

        // SET Index
        System.out.println(list.set(2, 43));
        printValues(list);*/

        // Insert Values
        /*System.out.println(list.insert(0, 99));
        System.out.println(list.insert(4, 99));
        System.out.println(list.insert(3,99));
        System.out.println(list.insert(7, 99));
        printValues(list);*/

        // Remove Values
        /*list.remove(0);
        list.remove(3);
        list.remove(4);
        list.remove(2);
        printValues(list);*/

        // Reverse LL
        /*list.reverse();
        printValues(list);*/

        //Find Middle Node
        /*System.out.println();
        System.out.println(list.findMiddleNode().value);*/

        // Has Loop
        /*list.getTail().next = list.getHead().next;
        System.out.println();
        System.out.println("Has Loop:");
        System.out.println( list.hasLoop());*/

        // findKthNode
        /*System.out.println();
        System.out.println(list.findKthFromEnd(4).value);*/

        // Partition List
        System.out.println();
        list.partitionList(5);
        printValues(list);
    }

    private static void printValues(LinkedList list) {
        System.out.println();
        System.out.printf("Head and tail Values are %s and %s", list.getHeadValue(), list.getTailValue());
        System.out.println();
        list.display();
    }
}
