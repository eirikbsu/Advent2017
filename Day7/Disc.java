import java.util.ArrayList;
import java.io.*;

public class Disc {

    ArrayList<Discprogram> programs = new ArrayList<Discprogram>();

    public void generateProgramDisc(String filename) {
        System.out.println("starting generateProgramDisc");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Discprogram tempDisc = new Discprogram(line);
                programs.add(tempDisc);
            }//end of while-loop
        } catch (FileNotFoundException fnf) {
            System.out.println("Nope, input invalid");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("Not. working. stahp");
            System.exit(1);
        }//end of try-catch

        /*
        Triple for-loop ftw. >_<
        Anyone have a better way of solving this? It hurts my eyes and my
        sensibilities but at least it works
        */
        for (Discprogram discprogram:programs) {
            if (discprogram.listOfConnections != null ) {
                for (int i = 0; i<discprogram.listOfConnections.size(); i++) {
                    for (Discprogram downstream:programs) {
                        if (discprogram.listOfConnections.get(i).equals(downstream.getName())) {
                            discprogram.addDownstream(downstream);
                            downstream.addUpstream(discprogram);
                        }//end of if
                    }//end of downstream-for
                }//end of for-loop
            }//end of if
        }//end of for
    }//end of generateProgramDisc

    public void printProgramList() {
        for (Discprogram discprogram:programs) {
            System.out.println(discprogram.getName());
        }//end of for-loop
    }//end of printProgramList

    public void findTop(Discprogram discprogram) {
        if (discprogram.upstream.size() == 0) {
            System.out.println("The program at the bottom is " + discprogram.getName());
        } else {
            findTop(discprogram.upstream.get(0));
        }//end of if-else
    }//end of findTop


}//end of Disc
