import java.util.ArrayList;

public class Day7 {
    public static void main(String[] args) {
        System.out.println("Start");
        Disc disc = new Disc();
        System.out.println("Disc generated");

        disc.generateProgramDisc("day7input.txt");

        System.out.println("Programdisc generated");

        disc.findTop(disc.programs.get(0));
    } //end of main
}//end of Day7
