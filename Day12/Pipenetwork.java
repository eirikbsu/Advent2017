import java.util.ArrayList;
import java.io.*;

public class Pipenetwork {
    ArrayList<Node> nodesInNetwork = new ArrayList<Node>();


    public void generateNetwork(String filename) {
        int idCounter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Node tempNode = new Node(idCounter, line);
                nodesInNetwork.add(tempNode);
                idCounter ++;
            }//end of while-loop
        } catch (FileNotFoundException fnf) {
            System.out.println("Nope, input invalid");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("Not. working. stahp");
            System.exit(1);
        }//end of try-catch

        /*
        Triple for-loop again. I'm sorry :/
        */

        for (Node node:nodesInNetwork) {
            if (node.connectionsString != null ) {
                for (int i = 0; i<node.connectionsString.size(); i++) {
                    int tempInt = Integer.parseInt(node.connectionsString.get(i));
                    for (Node downstream:nodesInNetwork) {
                        if (tempInt == downstream.getId() && node.connections.contains(downstream) == false) {
                            node.setConnection(downstream);
                            downstream.setConnection(node);
                        }//end of if
                    }//end of downstream-for
                }//end of for-loop
            }//end of if
        }//end of for
    }//end of generateNetwork

    ArrayList<Node> zeroConnectors = new ArrayList<Node>();

    public void connectionsToZero(Node node) {
        zeroConnectors.add(node);
        for (Node downstream:node.connections) {
            if (zeroConnectors.contains(downstream) == false) {
                connectionsToZero(downstream);
            }//end of if
        }//end of for
    }//end of connectionsToZero

}//end of Pipenetwork
