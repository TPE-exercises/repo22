package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;


public class Array {

    int array[] = new int[10];

    public void fillArrayWithThrows(int[] otherArray) throws MyException {
        for (int i = 0; i < otherArray.length; i++) {
            if (i >= this.array.length) {
                throw new MyException("Arrayüberschreitung", i);
            }
            this.array[i] = otherArray[i];
            
        }
        System.out.println("Das Array wurde erfolgreich gefüllt!");
    }

    public void fillArray(int[] otherArray) {
        try {
            for (int i = 0; i < otherArray.length; i++) {
                if (i >= this.array.length) {
                    throw new MyException("Arrayüberschreitung", i);
                }
                this.array[i] = otherArray[i];

            }
            System.out.println("Das Array wurde erfolgreich gefüllt!");
        } catch (MyException e) {
            e.printInfo();
        }
    }
}
