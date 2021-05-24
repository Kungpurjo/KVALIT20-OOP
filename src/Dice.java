import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    /**
     * Denna metod skapar en fil.
     * 1. Deklarerar variabler
     * 2. Hämtar int a från user
     * 3. Loopar igenom a antal gånger. I varje iteration
     *      skapas en siffra mellan 1-6, konverteras till string
     *      och konkraktineras i 'summa'
     * 4. Skapar och fyller en textfil (rng.txt) med 'summa'
     */
    public static void createFile() throws IOException {

        Random rand = new Random();
        int rngValue;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of D6 to roll: ");
        int a= sc.nextInt();
        StringBuilder summa;
        summa = new StringBuilder();

        int i;
        for (i = 0; i <a; i = i + 1) {
            rngValue = rand.nextInt((6 - 1) + 1) + 1;
            String rngString = Integer.toString(rngValue);
            summa.append(rngString);
        }

        PrintWriter utstrom = new PrintWriter
                (new BufferedWriter
                        (new FileWriter("rng.txt")));
        utstrom.print(summa);
        utstrom.close();
    }

    /**
     * Denna metod läser in från rng.txt och skapar en array
     * 1. Läser in och forslar in data från fil i string 'holder'
     * 2. Konverterar 'holder' till array med en siffra per element
     * 3. Loopar igenom 'holder' för att konvertera varje element till int
     * 4. Loopar igenom arrayen och forslar över varje element in i numbers
     * 5. Konverterar numbers från String till int för att underlätta arbetet i metod anlyseArray()
     */
    public static Integer[] createArray() {

        StringBuilder holder = new StringBuilder();

        try {
            Scanner in = new Scanner(new File("rng.txt"));
            while(in.hasNextLine()) {
                holder.append(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }

        String[] array = holder.toString().split("");

        Integer[] numbers = new Integer[array.length];
        for(int i = 0;i < array.length;i++)
        {
            numbers[i] = Integer.parseInt(array[i]);
        }

        return numbers;
    }

    /**
     * Denna metod läser och hanterar data från array numbers
     * 2. Loopar 6 gånger - Först registrerar den alla 1:or, sen alla 2:or etc.
     * 3. Tittar på varje siffra i utfalls-arrayen
     * 4. Ser om utfallet på randomizer stämmer överrens med currIter
     *      (dvs om utfallet på tärningen matchar nuvarande iterationen)
     * 5. Registrerar utfallet i rätt slot i returnArray
     */
    public static Integer[] analyseArray() {

        Integer[] array2 = createArray();
        Integer[] returnArray = {0,0,0,0,0,0};

        for (int i = 0; i < 6; i++) {
            int currIter = 0;
            currIter += (i+1);

            for(int j : array2) {
                if (j == currIter) {
                    returnArray[i] ++;
                }
            }
        }

        return returnArray;
    }
}