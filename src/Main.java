import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Dice.createFile();
        Dice.createArray();
        Dice.analyseArray();

        Integer[] output = Dice.analyseArray();
        System.out.print("Here's the number of [1][2][3][4][5][6] you rolled" + "\n");
        System.out.println(Arrays.toString(output));

    }
}
