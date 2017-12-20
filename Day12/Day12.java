

public class Day12 {
    public static void main(String[] args) {
        Pipenetwork network = new Pipenetwork();

        network.generateNetwork("day12input.txt");
        network.connectionsToZero(network.nodesInNetwork.get(0));
        int nodeNumber = network.zeroConnectors.size();

        System.out.println("Number of nodes connected to 0: " + nodeNumber);
    }
}
