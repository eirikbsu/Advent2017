public class GridNode {
    int id;
    GridNode east;
    GridNode west;
    GridNode north;
    GridNode south;

    GridNode(int id) {
        this.id = id;
    }//end of constructor

    public void setEast(GridNode east) {
        this.east = east;
    }//end of setEast

    public void setWest(GridNode west) {
        this.west = west;
    }//end of setWest

    public void setNorth(GridNode north) {
        this.north = north;
    }//end of setNorth

    public void setSouth(GridNode South) {
        this.south = south;
    }//end of setSouth

    public int getId() {
        return this.id;
    }//end of getId
}//end of GridNode
