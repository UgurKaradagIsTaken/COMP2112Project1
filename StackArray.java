/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithmsproject1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author apple
 */

public class StackArray {
String data[]; // array to hold items int top; // the top most item index public StackArray(int N) {
int top;
public StackArray(int N) {
data = new String[N];
top = -1; 
}

public void push(String element) {
if (!isFull()) {
top++;
data[top] = element;
}
}

public String pop() {
if (isEmpty()) {
throw new java.util.NoSuchElementException(); 
} else {
top--;
return data[top + 1]; 
}
}
public boolean isFull() {
return top == data.length - 1; 
}
public boolean isEmpty() {
return top == - 1; 
}
public String peek() {
    return this.data[top];
    
}

    public  boolean isPalindrome() {
        boolean isPalindrome = true;
        StackArray temp = new StackArray(this.top + 1);
        int j = this.top;
        for(int i = 0; i <= this.top; i++) {
            temp.data[j] = this.data[i];
            j--;
        }
        for(int i = 0; i <= this.top; i++) {
            if(!(this.data[i].equals(temp.data[i]))) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
	}
    
public static void deleteMiddle(StackArray s) {
    if((s.top + 1) % 2 == 0) {
        System.out.println("There is no middle element as the size of stack is even.");
        return;
    }
    StackArray temp = new StackArray((s.top + 1) / 2);
    for(int i = 0; i < (s.top + 1) / 2; i++) {
        temp.push(s.pop());
    }
    s.pop();
    while(!temp.isEmpty()) {
        s.push(temp.pop());
    }
}
public void print() {
    if(isEmpty()) {
        return;
    }
    String s = this.peek();
    this.pop();
    print();
    System.out.print(s + " ");
    this.push(s);
}
    public static void main(String[] args) {
        StackArray sa = new StackArray(100);
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        while(condition) {
            System.out.println(" ");
            System.out.println("1- Push");
            System.out.println("2- Pop");
            System.out.println("3- Print");
            System.out.println("4- Delete middle");
            System.out.println("5- isPalindrome");
            System.out.println("6- Exit");
           
            System.out.println("Enter your operation");
            int operation = scanner.nextInt();
            switch(operation) {
                case 1:
                    System.out.println("How many times do you want to push ? ");
                    int numberOfPush = scanner.nextInt();
                    for(int i = 0; i < numberOfPush; i++) {
                        System.out.println("Enter the String");
                        String s1 = scanner.next();
                        sa.push(s1);
                    }
                    break;
                case 2:
                    System.out.println("Popped element");
                    System.out.print(sa.pop());
                    break;
                case 3:
                    sa.print();
                    break;
                    case 4:
                    StackArray.deleteMiddle(sa);
                    break;
                    case 5:
                        System.out.println(sa.isPalindrome());
                    break;
                case 6:
                    condition = false;
                    break;
                    default: 
                        System.out.println("Wrong operation number");
                        break;
            } 
        }
    }
}



/*
StackArray temp = new StackArray((s.top + 1) / 2);
    boolean isPalindrome = true;
    if((s.top + 1) % 2 == 0) {
    for(int i = s.top; i >= (s.top + 1) / 2; i--) {
        temp.push(s.pop());
    }
    
    for(int i = s.top; i >= 0; i--) {
        String s1 = temp.data[i];
        String s2 = s.data[i];
        if(!(s1.equals(s2))) {
            isPalindrome = false;
            break;
        }
    }
    while(!temp.isEmpty()) {
        s.push(temp.pop());
    }
    }else {
        for(int i = s.top - 1; i > (s.top + 1) / 2; i--) {
        temp.push(s.pop());
    }
    for(int i = s.top - 1; i >= 0; i--) {
        String s1 = temp.data[i];
        String s2 = s.data[i];
        if(!(s1.equals(s2))) {
            isPalindrome = false;
            break;
        }
    }
    while(!temp.isEmpty()) {
        s.push(temp.pop());
    }
    }
    return isPalindrome;
*/
/*
public static boolean isPalindromeEvenElements(StackArray s) {
    if(s.data.length % 2 != 0) {
        return false;
    }
    StackArray temp = new StackArray(s.data.length / 2);
    StackArray temp2 = new StackArray(s.data.length / 2);
    for(int i = s.data.length - 1; i >= s.data.length / 2; i--) {
        temp.push(s.data[i]);
    }
    for(int i = 0; i < s.data.length / 2; i++) {
        temp2.push(s.data[i]);
    }
    boolean isPalindrome = true;
    while(!temp.isEmpty() && !temp2.isEmpty()) {
        String s1 = temp.pop();
        String s2 = temp.pop();
        if(!(s1.equals(s2))) {
            isPalindrome = false;
            break;
        }
    }
    return isPalindrome;
}
*/
/*
public static boolean isPalindromeOddElements(StackArray s) {
    if(s.data.length % 2 == 0) {
        return false;
    }
    StackArray temp = new StackArray(s.data.length / 2);
    StackArray temp2 = new StackArray(s.data.length / 2);
    for(int i = s.data.length - 1; i > s.data.length / 2; i--) {
        temp.push(s.data[i]);
    }
    for(int i = 0; i < s.data.length / 2; i++) {
        temp2.push(s.data[i]);
    }
    boolean isPalindrome = true;
    while(!temp.isEmpty() && !temp2.isEmpty()) {
        String s1 = temp.pop();
        String s2 = temp.pop();
        if(!(s1.equals(s2))) {
            isPalindrome = false;
            break;
        }
    }
    return isPalindrome;
}
*/
