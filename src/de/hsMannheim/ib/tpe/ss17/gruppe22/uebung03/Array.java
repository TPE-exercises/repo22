package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;


public class Array {

    int array[] = new int[10];
    /**
     * This method is for testing purposes. A parameter array shall be put into 
     * this.array. If it fails, an exception is thrown to the outside.
     * @param otherArray The array to be put into this.array
     * @throws MyException A self defined Exception class
     */
    public void fillArrayWithThrows(int[] otherArray) throws MyException {
        for (int i = 0; i < otherArray.length; i++) {
            if (i >= this.array.length) {
                throw new MyException("Arrayüberschreitung", i);
            }
            this.array[i] = otherArray[i];
            
        }
        System.out.println("Das Array wurde erfolgreich übergeben!");
    }
    /**
     * This method is for testing purposes. A parameter array shall be put into 
     * this.array. If it fails, an exception is thrown and caught within the 
     * method.
     * @param otherArray The array to be put into this.array
     */
    public void fillArray(int[] otherArray) {
        try {
            for (int i = 0; i < otherArray.length; i++) {
                if (i >= this.array.length) {
                    throw new MyException("Arrayüberschreitung", i);
                }
                this.array[i] = otherArray[i];

            }
            System.out.println("Das Array wurde erfolgreich übergeben!");
        } catch (MyException e) {
            e.printInfo();
        }
    }
}
