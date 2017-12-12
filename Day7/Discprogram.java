import java.util.ArrayList;

public class Discprogram {
    String name;
    ArrayList<Discprogram> downstream = new ArrayList<Discprogram>();
    ArrayList<Discprogram> upstream = new ArrayList<Discprogram>();
    ArrayList<String> listOfConnections = new ArrayList<String>();

    Discprogram(String input) {
        String[] variableGenerator = input.split(" ");

        this.name = variableGenerator[0];

        if (variableGenerator.length > 2) {
            for(int i = 3; i<variableGenerator.length; i++) {
                String tempString = variableGenerator[i];
                tempString = tempString.replace(",", ""); //removes any commas
                listOfConnections.add(tempString);
            }//end of for-loop
        }//end of if-test
    }//end of constructor

    public String getName() {
        return this.name;
    } //end of getName

    public void addUpstream(Discprogram up) {
        this.upstream.add(up);
    }//end of addUpstream

    public void addDownstream(Discprogram down) {
        this.downstream.add(down);
    }//end of addDownstream


}//end of Discprogram
