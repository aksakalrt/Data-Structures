package com.company;


public class Stack {
    Node root = new Node();

    public Stack(){
        root.data=null;
        root.next=null;
    }
    public void push(int icData){
        if (root.data==null){
            root.data=icData;
            root.next=null;
        }
        else{
            Node yeni = new Node();
            yeni.data=icData;
            yeni.next=root;
            root=yeni;
        }
    }
    public int pop(){
        if (root.data==null){
            System.out.println("Stack Zaten Boş!");
            return -1;
        }
        else if (root.next==null){
            Node temp = root;
            root = root.next;
            System.out.println("Stack Artık Boş!");
            return temp.data;
        }
        else {
            Node temp = root;
            root = root.next;
            return temp.data;
        }
    }
    public int top(){
        if (root.data==null){
            System.out.println("Stack Boş!");
            return -1;
        }
        else{
            return root.data;
        }
    }
    public int size(){
        if (root.data==null){
            return 0;
        }
        else if (root.next==null){
            return 1;
        }
        else{
            Node iter = root;
            int i = 0;
            while (iter!=null){
                iter=iter.next;
                i++;
            }
            return i;
        }
    }
    public boolean isEmpty(){
        if (root.data==null){
            return true;
        }
        else {
            return false;
        }
    }
}


