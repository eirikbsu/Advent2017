public class Day13 {
    public static void main(String[] args) {
        Firewall firewall = new Firewall();

        firewall.generateFirewall("day13input.txt");
        System.out.println("Total severity: " + firewall.traverseFirewall());
        System.out.println("Minimum delay: " + firewall.delayPacket()); //Doesn't return the right answer :/
    }
}
