/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithmsproject1;

import java.util.Scanner;

/**
 *
 * @author apple
 */
public class MyLinkedList{ 
    Node first, last;
public MyLinkedList(){
    first= null;
    last= null; 
}

 class Node{ 
    int coef, power;
   Node next; 
   
public Node(int coef, int pow){ 
this.coef = coef;
this.power = pow;
this.next = null;
}
    public void toStringforNode() {
       System.out.print(this.coef + "x^" +  this.power + " + ");
   }
}
 public void insertLast(int coef, int pow) {
     Node newNode = new Node(coef, pow);
     if(first == null) {
         first = newNode;
         last = newNode;
     }
     last.next = newNode;
     last = newNode;
 }
 public static MyLinkedList addTwoPolynomials(MyLinkedList l1, MyLinkedList l2) {
     Node i;
     Node j;
     Node k;
     MyLinkedList result;
     int coefficient;
     int power;
     result = new MyLinkedList();
     i = l1.first;
     j = l2.first;
     // checks both of the linkedlists and adds them into the result list until one of the linkedlist is empty
     while(i != null && j!= null) {
        if(i.power == j.power) {
            coefficient = i.coef + j.coef;
            power = i.power;
            i = i.next;
            j = j.next;
        }else {
            if(i.power > j.power) {
                coefficient = i.coef;
                power = i.power;
                i = i.next;
            }else {
                coefficient = j.coef;
                power = j.coef;
                j = j.next;
            }
        }
        if(coefficient != 0) {
            result.insertLast(coefficient,power);
        }
 } //End of the while loop
     
     
     if(i == null) {
         k = j;
     }else {
         k = i;
     }
     while(k != null) {
         result.insertLast(k.coef,k.power);
         k = k.next;
     }
     Node tempNode = result.first;
     while(tempNode != null) {
         tempNode.toStringforNode();
         tempNode = tempNode.next;
     }
     return result;
 }
 public static MyLinkedList multiplyTwoPolynomials(MyLinkedList l1, MyLinkedList l2) {
     Node i;
     Node j;
     Node k;
     MyLinkedList result;
     result = new MyLinkedList();
     int coefficient;
     int power;
     i = l1.first;
     j = l2.first;
     while(i != null) {
         while(j != null) {
             coefficient = i.coef * j.coef;
             power = i.power + j.power;
             j = j.next;
             if(coefficient != 0) {
                 result.insertLast(coefficient, power);
             }
         }
         i = i.next;
     }
     Node tempNode = result.first;
     while(tempNode != null) {
         tempNode.toStringforNode();
         tempNode = tempNode.next;
     }
     return result;
 }
 public static void delete(MyLinkedList l1, MyLinkedList l2, int deletedPower) {
     Node i;
     Node j;
     Node k;
     i = l1.first;
     j = l2.first;
     while(i != null) {
         if(i.power == deletedPower) {
             i.coef = 0;
             i.power = 0;
         }
         i = i.next;
     }
     while(j != null) {
         if(j.power == deletedPower) {
             j.coef = 0;
             j.power = 0;
         }
         j = j.next;
     }
 }
 public static void printPolynomials(MyLinkedList l1, MyLinkedList l2) {
     Node i;
     Node j;
     i = l1.first;
     j = l2.first;
     System.out.println("First polynomial");
     while(i != null) {
         i.toStringforNode();
         i = i.next;
     }
     System.out.println("");
     System.out.println("Second polynomial");
     while(j != null) {
         j.toStringforNode();
         j = j.next;
     }
     System.out.println("");
 }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();
        System.out.println("Enter the coefficient and power of the first polynomial. Type 0 at the end:");
        int coef;
        int power;
        do {            
            System.out.println("Enter the coefficient");
             coef = scanner.nextInt();
            System.out.println("Enter the power");
             power = scanner.nextInt();
            l1.insertLast(coef, power);
            
        } while (coef != 0);
        System.out.println("Enter the coefficient and power of the second polynomial. Type 0 at the end:");
        do {            
            System.out.println("Enter the coefficient");
             coef = scanner.nextInt();
            System.out.println("Enter the power");
             power = scanner.nextInt();
            l2.insertLast(coef, power);
        } while (coef != 0);
        boolean condition = true;
        while(condition) {
            System.out.println("");
            System.out.println("1- Add");
            System.out.println("2- Multiply");
            System.out.println("3- Print");
            System.out.println("4- Delete");
            System.out.println("5- exit");
            
            System.out.println("Enter your operation");
            int operation = scanner.nextInt();
            switch(operation) {
                case 1:
                    MyLinkedList.addTwoPolynomials(l1,l2);
                    break;
                case 2:
                    MyLinkedList.multiplyTwoPolynomials(l1, l2);
                    break;
                case 3:
                    MyLinkedList.printPolynomials(l1, l2);
                    break;
                case 4:
                    System.out.println("Which power do you want to be deleted ? ");
                    int q = scanner.nextInt();
                    MyLinkedList.delete(l1, l2, q);
                    break;
                case 5:
                    condition = false;
                    break;
                    default: 
                        System.out.println("Wrong operation number");
                        break;
            } 
        }
    }
    
}



