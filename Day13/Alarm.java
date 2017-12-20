public class Alarm {
    int depth;
    int numberOfLayers;

    Alarm(int depth, int numberOfLayers) {
        this.depth = depth;
        this.numberOfLayers = numberOfLayers;
    }//end of Constructor

    boolean downwards = true;
    int currentLayer = 1;

    public void moveScanner() {
        if (this.downwards == true) {
            this.currentLayer ++;
            if (this.currentLayer == this.numberOfLayers) {
                this.downwards = false;
            }//end of if-test
        } else {
            this.currentLayer --;
            if (this.currentLayer == 1) {
                this.downwards = true;
            }//end of if
        }//end of if-else
    }//end of moveScanner

    public int severity() {
        return (this.depth * this.numberOfLayers);
    }//end of severity

    public int getDepth() {
        return this.depth;
    }

    public int getCurrent() {
        return this.currentLayer;
    }

}//end of Alarm
