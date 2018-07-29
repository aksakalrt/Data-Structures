package com.company;

class Node{
    Integer data=null;
    Node next=null;
}

public class List {
    Node root;
    Node last;

    public List(){
        root=null;
        last=null;
    }

    public void basaEkle(int icData){
        if (root==null){
            Node yeni = new Node();
            yeni.data = icData;
            root=yeni;
            yeni.next=null;
            last=root;
        }
        else if (root==last){
            Node yeni = new Node();
            yeni.data = icData;
            yeni.next=root;
            root=yeni;
            last=yeni;
        }
        else{
            Node yeni = new Node();
            yeni.data = icData;
            yeni.next=root;
            root=yeni;
            last=yeni;
        }
    }

    public void arayaEkle(int icData){
        if (root==null){
            Node yeni = new Node();
            yeni.data = icData;
            yeni.next = null;
            root=yeni;
            last=root;
        }
        else if (root==last){
            Node yeni = new Node();
            yeni.data = icData;
            if (yeni.data<root.data){
                yeni.next=root;
            }
            else {
                root.next=yeni;
                last=yeni;
            }
        }
        else {
            Node iter = root;
            if (iter.data>icData){
                Node yeni = new Node();
                yeni.data = icData;
                yeni.next = iter;
                root = yeni;
            }
            else {
                while (iter.next!=null && iter.next.data<icData){
                    iter = iter.next;
                }
                if (iter.next==null){
                    Node yeni = new Node();
                    yeni.data = icData;
                    yeni.next = null;
                    last.next = yeni;
                    last = yeni;
                }
                else {
                    Node yeni = new Node();
                    yeni.data = icData;
                    yeni.next = iter.next;
                    iter.next = yeni;
                }
            }


        }
    }

    public void sonaEkle(int icData){
        if (root==null){
            Node yeni = new Node();
            yeni.data = icData;
            yeni.next = null;
            root = yeni;
            last = root;
        }
        else if (root==last){
            Node yeni = new Node();
            yeni.data = icData;
            last.next=yeni;
            yeni.next=null;
            last=yeni;
        }
        else {
            Node yeni = new Node();
            yeni.data = icData;
            last.next = yeni;
            yeni.next = null;
            last=yeni;
        }
    }

    public void bastanSil(){
        if (root==null){
            return;
        }
        else if (root==last){
            System.out.println(root.data+" Değeri Silindi!");
            root=null;
            last=root;
        }
        else {
            System.out.println(root.data+" Değeri Silindi!");
            Node yeni = root.next;
            root = yeni;
        }
    }

    public void aradanSil(int icData){
        if (root==null){
            return;
        }
        else if (root==last){
            if (root.data==icData){
                root=null;
                last=root;
            }
            else {
                System.out.println("Silinecek Değer Bulunamadı!");
            }
        }
        else {
            Node iter = root;
            while (iter.next!=null && iter.next.data!=icData){
                iter = iter.next;
            }
            if (iter.next==null){
                System.out.println("Silinecek Değer Bulunamadı!");
            }
            else if (iter.next.next==null){
                System.out.println(iter.next.data+" Değeri Silindi!");
                iter.next=null;
                last=iter;
            }
            else {
                Node temp = iter.next;
                iter.next = temp.next;
                System.out.println(temp.data+" Değeri Silindi!");
                temp.next=null;
            }
        }
    }

    public void indisSil(int indices){
        if (root==null){
            return;
        }
        else if (indices>=listeBoyutu()){
            System.out.println("Aralık Dışında indis verilmiştir!!");
            return;
        }
        else if (root==last){
            if (indices==0){
                System.out.println(root.data+" Değeri Silindi!");
                root=null;
                last=root;
            }
            else {
                System.out.println("Silinecek Değer Bulunamadı!");
            }
        }
        else{
            if (indices==0){
                System.out.println(root.data+" Değeri Silindi!");
                root=root.next;
            }
            else {
                Node iter = root;
                for (int i=0;i<indices-1;i++){
                    iter=iter.next;
                }
                if (iter.next.next==null){
                    System.out.println(iter.next.data+" Değeri Silindi!");
                    iter.next=null;
                    last=iter;
                }
                else {
                    Node temp = iter.next;
                    iter.next = temp.next;
                    System.out.println(temp.data+" Değeri Silindi!");
                    temp.next=null;
                }
            }
        }
    }

    public void sondanSil(){
        if (root==null){
            return;
        }
        else if (root==last){
            System.out.println(root.data+" Değeri Silindi!");
            root=null;
            last=null;
        }
        else {
            Node iter = root;
            while (iter.next.next!=null){
                iter=iter.next;
            }
            System.out.println(iter.next.data+" Değeri Silindi!");
            iter.next=null;
            last=iter;
        }
    }

    public void hepsiniSil(){
        System.out.println("Bütün liste silindi!");
        root=null;
        last=null;
    }

    public int degerGetir(int indices){
        if(indices>=listeBoyutu()){
            System.out.println("Aralık Dışında indis verilmiştir!!");
            return -1;
        }
        Node iter = root;
        for (int i=0;i<indices-1;i++){
            iter=iter.next;
        }
        return iter.next.data;
    }

    public int indisGetir(int icData){
        Node iter = root;
        int i=0;
        while(iter.next!=null && iter.data!=icData){
            iter=iter.next;
            i++;
        }
        if (iter.next==null){
            System.out.println("Veri Bulunamadı!");
            return -1;
        }
        return i;
    }

    public boolean listeBosmu(){
        if (root==null){
            return true;
        }
        else {
            return false;
        }
    }

    public int listeBoyutu(){
        if (root==null){
            return 0;
        }
        else if (root.next==null){
            return 1;
        }
        else{
            Node iter = root;
            int i=1;
            while (iter.next!=null){
                iter=iter.next;
                i++;
            }
            return i;
        }
    }

    public void ekranaBas(){
        if (root==null){
            System.out.println("Liste Boş");
        }
        else{
            Node iter = root;
            while (iter!=null){
                System.out.println(iter.data);
                iter=iter.next;
            }
        }
    }
}