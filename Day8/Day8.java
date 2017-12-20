

public class Day8 {
    public static void main(String[] args) {
        Registrylist reglist = new Registrylist();

        String filename = "day8input.txt";
        reglist.generateRegistries(filename);
        reglist.readInstructions(filename);

        System.out.println("highest value: " + reglist.highestValue());
        System.out.println("HIGHEST EVER: " + reglist.returnHighestEver());
    }//end of main
}//end of Day8
