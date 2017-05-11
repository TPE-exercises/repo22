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
        ArrayQueue myArrayQueue = new ArrayQueue(3);
        System.out.println("peak(): " + myArrayQueue.peak());
        System.out.println(myArrayQueue.leave());
        //Test Run 1
//        System.out.println("enter(1)");
//        myArrayQueue.enter(1);
//        System.out.println("enter(2)");
//        myArrayQueue.enter(2);
//        System.out.println("enter(3)");
//        myArrayQueue.enter(3);
//        System.out.println("enter(4)");
//        myArrayQueue.enter(4);
//        System.out.println("enter(5)");
//        myArrayQueue.enter(5);
//        System.out.println("enter(6)");
//        myArrayQueue.enter(6);
//        System.out.println("enter(7)");
//        myArrayQueue.enter(7);
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());
//        System.out.println("leave(): " + myArrayQueue.leave());

        // Test Run 2
        System.out.println("enter(1)");
        myArrayQueue.enter(1);
        System.out.println("enter(2)");
        myArrayQueue.enter(2);
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("enter(3)");
        myArrayQueue.enter(3);
        System.out.println("enter(4)");
        myArrayQueue.enter(4);

        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("enter(5)");
        myArrayQueue.enter(5);
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("enter(6)");
        myArrayQueue.enter(6);
        System.out.println("enter(7)");
        myArrayQueue.enter(7);
        System.out.println("enter(8)");
        myArrayQueue.enter(8);
        System.out.println("enter(9)");
        myArrayQueue.enter(9);

        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());

        System.out.println("enter(10)");
        myArrayQueue.enter(10);
        System.out.println("enter(11)");
        myArrayQueue.enter(11);
        System.out.println("enter(12)");
        myArrayQueue.enter(12);

        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("leave(): " + myArrayQueue.leave());
        System.out.println("enter(13)");
        myArrayQueue.enter(13);
        System.out.println("enter(14)");
        myArrayQueue.enter(14);
        System.out.println("enter(15)");
        myArrayQueue.enter(15);
        System.out.println("enter(16)");
        myArrayQueue.enter(16);
        System.out.println("enter(17)");
        myArrayQueue.enter(17);
        System.out.println("enter(18)");
        myArrayQueue.enter(18);
        System.out.println("enter(19)");
        myArrayQueue.enter(19);
        System.out.println("enter(20)");
        myArrayQueue.enter(20);

        System.out.println();
        System.out.println("Implementierung von ArrayStack.");

    }
}
