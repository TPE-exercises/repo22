package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.*;
import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;

public class Main {

    public static void main(String[] args) {
        int intArray[] = new int[15];
        // Aufgabe 1a)
        System.out.println("Aufgabe 1a)");
        System.out.println();
        for (int i = 0; i <= intArray.length + 2; i++) {
            try {
                intArray[i] = i;
            } catch (Exception e) {
                System.out.println("**Fehler bei Wert " + i + "**");
            }

        }
        for (int i = 0; i < intArray.length - 1; i++) {
            System.out.print(intArray[i] + ", ");

        }
        System.out.println(intArray[intArray.length - 1]);
        Array myArray = new Array();
        System.out.println("Es wird versucht myArray der Länge " + myArray.array.length + " ohne throws-Anweisung zu füllen.");
        myArray.fillArray(intArray);

        System.out.println("Es wird versucht myArray der Länge " + myArray.array.length + " mit throws-Anweisung zu füllen.");
        try {
            try {
                myArray.fillArrayWithThrows(intArray);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } catch (MyException e) {
            e.printInfo();
        }
        System.out.println();
        System.out.println();
        // Aufgabe 1b)
        System.out.println("Aufgabe 1b)");
        System.out.println();
        System.out.println("Implementierung von ArrayQueue.");
        Queue myQueue = new ArrayQueue(3);
        System.out.println("peak(): " + myQueue.peak());
        System.out.println(myQueue.leave());
        //Test Run 1
//        System.out.println("enter(1)");
//        myQueue.enter(1);
//        System.out.println("enter(2)");
//        myQueue.enter(2);
//        System.out.println("enter(3)");
//        myQueue.enter(3);
//        System.out.println("enter(4)");
//        myQueue.enter(4);
//        System.out.println("enter(5)");
//        myQueue.enter(5);
//        System.out.println("enter(6)");
//        myQueue.enter(6);
//        System.out.println("enter(7)");
//        myQueue.enter(7);
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());
//        System.out.println("leave(): " + myQueue.leave());

        // Test Run 2
        System.out.println("enter(1)");
        myQueue.enter(1);
        System.out.println("enter(2)");
        myQueue.enter(2);
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("enter(3)");
        myQueue.enter(3);
        System.out.println("enter(4)");
        myQueue.enter(4);

        System.out.println("leave(): " + myQueue.leave());
        System.out.println("enter(5)");
        myQueue.enter(5);
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("enter(6)");
        myQueue.enter(6);
        System.out.println("enter(7)");
        myQueue.enter(7);
        System.out.println("enter(8)");
        myQueue.enter(8);
        System.out.println("enter(9)");
        myQueue.enter(9);

        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());

        System.out.println("enter(10)");
        myQueue.enter(10);
        System.out.println("enter(11)");
        myQueue.enter(11);
        System.out.println("enter(12)");
        myQueue.enter(12);

        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("leave(): " + myQueue.leave());
        System.out.println("enter(13)");
        myQueue.enter(13);
        System.out.println("enter(14)");
        myQueue.enter(14);
        System.out.println("enter(15)");
        myQueue.enter(15);
        System.out.println("enter(16)");
        myQueue.enter(16);
        System.out.println("enter(17)");
        myQueue.enter(17);
        System.out.println("enter(18)");
        myQueue.enter(18);
        System.out.println("enter(19)");
        myQueue.enter(19);
        System.out.println("enter(20)");
        myQueue.enter(20);

        System.out.println();
        //Implementation of Stack as Array
        System.out.println("Implementierung von ArrayStack.");
        Stack myStack = new ArrayStack(3);
        
        System.out.println("peak(): " + myStack.peak());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println("pop(): " + myStack.pop());
        System.out.println("pop(): " + myStack.pop());
        System.out.println("pop(): " + myStack.pop());
        System.out.println("pop(): " + myStack.pop());      
                myStack.push(1);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
                myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(11);
    }
}
