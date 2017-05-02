package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung02;

/**
 *
 * @author Marc, Marco
 */
public class Main {

    public static void showEisdiele() {
        Eisdiele[] eisdiele = new Eisdiele[]{new StandardEisdiele(), new MonnemerEisdiele(), new KoelnerEisdiele()};

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    System.out.println("Standard:");
                    break;
                case 1:
                    System.out.println("Mannheim:");
                    break;
                case 2:
                    System.out.println("Koeln:");
                    break;
            }
            System.out.println();
            eisdiele[i].erstellen("Schokotraum");
            System.out.println();
            eisdiele[i].erstellen("Bananasplit");
            System.out.println();
            eisdiele[i].erstellen("Spaghettieis");
            System.out.println();
            eisdiele[i].erstellen("Himbeer Becher");
            System.out.println();
            eisdiele[i].erstellen(
                    " two number 9s, a number 9 large, a number 6 with extra dip, a number 7, two number 45s, one with cheese, and a large soda.");
            System.out.println();

        }
    }

    public static Comparable[] giveStandardArray() {
        Comparable[] array = new Comparable[9];
        array[0] = new MyString("Quacker");
        array[1] = new MyInt(72);
        array[2] = new MyInt(-1);
        array[3] = new MyString("Duck");
        array[4] = new MyString("Ben");
        array[5] = new MyString("zielgerichtet");
        array[6] = new MyString("Zutaten");
        array[7] = new MyInt(20);
        array[8] = new MyString("yopta");
        return array;
    }

    public static void main(String[] args) {

        System.out.println("Teil 1, Aufgabe 1 + 2:");
        System.out.println();
        showEisdiele();
        System.out.println();
        System.out.println("Teil 2, Aufgabe 1:");
        System.out.println();

        CrypterCaesar myCaesarCrypter = new CrypterCaesar(1);
        CrypterReverse myCrypterReverse = new CrypterReverse();
        // Task 1b)
        Crypter myCrypter = myCaesarCrypter;
//      String myString = "aBc";
        String myString = "Ich, Julius Caesar, sagte den folgenden beruehmten Satz: Veni, vidi, vici.";

        System.out.println("Caesar-Verschluesselung:");
        System.out.println();
        String myEncryptedString = myCrypter.encrypt(myString);
        System.out.print("Encrypted Message: ");
        System.out.println(myEncryptedString);
        String myDecryptedString = myCrypter.decrypt(myEncryptedString);
        System.out.print("Decrypted Message: ");
        System.out.println(myDecryptedString);
        System.out.println();
        System.out.println();

        // Task 1c)
        myCrypter = myCrypterReverse;
        System.out.println("Reverse-Verschluesselung:");
        System.out.println();
        myEncryptedString = myCrypter.encrypt(myString);
        System.out.print("Encrypted Message: ");
        System.out.println(myEncryptedString);
        myDecryptedString = myCrypter.decrypt(myEncryptedString);
        System.out.print("Decrypted Message: ");
        System.out.println(myDecryptedString);
        System.out.println();
        System.out.println();

        // Task 1d)
        myString = "XHMSNYYXYJQQJS";
        myString = myCrypterReverse.decrypt(myString);
        myCaesarCrypter.setCharShift(5);
        myString = myCaesarCrypter.decrypt(myString);
        myString = myCrypterReverse.decrypt(myString);
        System.out.println(myString);
        System.out.println();

        // Task 2b)

        Comparable []array;
        array = giveStandardArray();
        Sortable.sortArray((new ShakerSort()), array);
        System.out.println();

        array = giveStandardArray();
        Sortable.sortArray((new InsertionSort()), array);
        System.out.println();

        array = giveStandardArray();
        Sortable.sortArray((new InsertionSortBinary()), array);
    }

}
