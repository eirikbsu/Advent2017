import java.util.ArrayList;

public class ChristmasGrid {
    ArrayList<GridNode> grid = new ArrayList<GridNode>();

    public void makeGrid(int max) {
        GridNode last;
        for (int i = 0; i<max; i++) {
            int tempId = i + 1;
            GridNode tempNode = new GridNode(tempId);
            grid.add(tempNode);
        }//end of for-loop
        
    }
}
