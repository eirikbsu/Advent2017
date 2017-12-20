import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Registrylist {
    HashMap<String, Integer> registries = new HashMap<String, Integer>();
    ArrayList<String> registrynames = new ArrayList<String>();
    int highestValueEver = 0;


    public void generateRegistries(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean nameExists = false;
                String[] tempLine = line.split(" ");
                if (registrynames.size() != 0) {
                    for (String name:registrynames) {
                        if (name.equals(tempLine[0])) {
                            nameExists = true;
                        }//end of if
                    }//end of for-loop
                }//end of if-test

                if (nameExists == false) {
                    registries.put(tempLine[0], 0);
                    registrynames.add(tempLine[0]);
                }//end of if-test
                nameExists = false;

            }//end of while-loop
        } catch (FileNotFoundException fnf) {
            System.out.println("there's no file bro");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("I DONT EVEN KNOW :(");
            System.exit(1);
        }//end of try-catch
    }//end of generateRegistries

    public void readInstructions(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tempLine = line.split(" ");
                if (tempLine[5].equals(">")) {
                    if (registries.get(tempLine[4]) > Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                } else if (tempLine[5].equals("<")) {
                    if (registries.get(tempLine[4]) < Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                } else if (tempLine[5].equals(">=")) {
                    if (registries.get(tempLine[4]) >= Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                } else if (tempLine[5].equals("<=")) {
                    if (registries.get(tempLine[4]) <= Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                } else if (tempLine[5].equals("!=")) {
                    if (registries.get(tempLine[4]) != Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                } else if (tempLine[5].equals("==")) {
                    if (registries.get(tempLine[4]) == Integer.parseInt((tempLine[6]))) {
                        if (tempLine[1].equals("inc")) {
                            increaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        } else {
                            decreaseValue(tempLine[0], Integer.parseInt(tempLine[2]));
                        }//end of if-else
                    }//end of if-else
                }//end of long-ass if-else
                if (registries.get(tempLine[0]) > highestValueEver) {
                    highestValueEver = registries.get(tempLine[0]);
                }//end of if-test
            }//end of while-loop
        } catch (FileNotFoundException fnf) {
            System.out.println("there's no file bro");
            System.exit(0);
        } catch (IOException io) {
            System.out.println("I DONT EVEN KNOW :(");
            System.exit(1);
        }//end of try-catch
    }//end of readInstructions

    public void increaseValue(String keyName, int value) {
        registries.put(keyName, registries.get(keyName) + value);
    }//end of increaseValue

    public void decreaseValue(String keyName, int value) {
        registries.put(keyName, registries.get(keyName) - value);
    }//end of increaseValue

    public Integer highestValue() {
        Integer highest = 0;
        for (Integer value:registries.values()) {
            if (value > highest) {
                highest = value;
            }//end of if
        }//end of for-each
        return highest;
    }//end of highestValue

    public Integer returnHighestEver() {
        return this.highestValueEver;
    }//end of returnHighestEver
}//end of Registrylist
