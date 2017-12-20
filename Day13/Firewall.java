import java.util.ArrayList;
import java.io.*;

public class Firewall {
    ArrayList<Alarm> alarms = new ArrayList<Alarm>();
    int maxDepth;

    public void generateFirewall(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace(":", "");
                String[] tempLine = line.split(" ");
                Alarm tempAlarm = new Alarm(Integer.parseInt(tempLine[0]), Integer.parseInt(tempLine[1]));
                alarms.add(tempAlarm);
                maxDepth = Integer.parseInt(tempLine[0]);

            }//end of while-loop
        } catch (FileNotFoundException fnf) {
            System.out.println("there's no file bro");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("I DONT EVEN KNOW :(");
            System.exit(1);
        }//end of try-catch
    }//end of generateRegistries

    public int traverseFirewall() {
        int severityRaised = 0;
        for (int depthTravelled = 0; depthTravelled<=maxDepth; depthTravelled++) {
            for(Alarm alarm:alarms) {
                if (depthTravelled == alarm.getDepth() && alarm.getCurrent() == 1) {
                    severityRaised = severityRaised + alarm.severity();
                }//end of if-test
                alarm.moveScanner();
            }//end of for-loop
        }//end of depthTravelled for loop
        return severityRaised;
    }//end of traverseFirewall

    public int delayPacket() {
        int delay = 0;
        boolean willGetCaught = false;

        for (int depthTravelled = 0; depthTravelled<=maxDepth; depthTravelled++) {
            for(Alarm alarm:alarms) {
                if (depthTravelled == alarm.getDepth() && alarm.getCurrent() == 1) {
                    willGetCaught = true;
                    delay = delay + 1;
                }//end of if-test

                alarm.moveScanner();
                if (willGetCaught == true) {
                    depthTravelled = 0;
                    willGetCaught = false;
                }//end of  willGetCaught-test
            }//end of for-loop
        }//end of depthTravelled for loop
        return delay;
    }//end of delayPacket

}//end of Firewall
