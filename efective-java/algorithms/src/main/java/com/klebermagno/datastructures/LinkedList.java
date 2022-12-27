package com.klebermagno.datastructures;

public class LinkedList {

    Node head;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
        
    }

    public void insert(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void dumpList() {
        Node node = head;
        while (node != null) {
            print("Node: ", node.value);
            node = node.next;
        }
    }

    public int count() {
        Node node = head;
        int count = 0;
        while (node!= null) {
            count ++;
            node = node.next;
        }
        return count ; 
    }

    public int find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node.value;
            } else {
                node = node.next;
            }

        }
        return 0;
    }

    public void deleteAt(int pos) {
        Node node = head;
        int count = 0;
        while (node != null ) {
            if (count == pos-1) {
                node.next = node.next.next;
            }
            count++;
            node = node.next;
        }

    }

    public static void print(String message, int value) {
        System.out.println(message + value);
    }

    public static void main(String[] args) {
        // create a linked list and insert some items
        LinkedList itemlist = new LinkedList();
        itemlist.insert( 38);
        itemlist.insert(49);
        itemlist.insert(13);
        itemlist.insert(15);
        itemlist.dumpList();

        //exercise the list
        print("Item count: ", itemlist.count());
        print("Finding item: ", itemlist.find(13));
        print("Finding item: ", itemlist.find(78));

        // delete an item
        itemlist.deleteAt(3);
        print("Item count: ", itemlist.count());
        print("Finding item: ", itemlist.find(38));
        itemlist.dumpList();

    }

}
