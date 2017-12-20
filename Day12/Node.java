import java.util.ArrayList;

public class Node {
    int id;
    ArrayList<Node> connections = new ArrayList<Node>();
    ArrayList<String> connectionsString = new ArrayList<String>();

    Node(int id, String connections) {
        this.id = id;
        connections = connections.replace(",", "");
        String[] connectionsList = connections.split(" ");

        if (connectionsList.length > 2) {
            for (int i = 2; i<connectionsList.length; i++) {
                connectionsString.add(connectionsList[i]);
            }//end of for-loop
        }//end of if-test
    }//end of constructor

    public int getId() {
        return this.id;
    }//end of getId

    public void setConnection(Node node) {
        this.connections.add(node);
    }//end of setConnection

}//end of Node
