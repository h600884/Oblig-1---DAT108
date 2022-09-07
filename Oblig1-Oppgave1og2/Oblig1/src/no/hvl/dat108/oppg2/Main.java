package no.hvl.dat108.oppg2;

public class Main {

    public static void main(String[] args) {
        final String[] kokker = {"Lars", "Erik", "Fredrik"};
        final String[] servitorer = {"Sigve", "Vetle"};
        final int KAPASITET = 4;

        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        for (String navn : kokker) {
            new Thread (new Kokk(brett, navn)).start();
        }
        for (String navn : servitorer) {
            new Thread (new Servitor(brett, navn)).start();
        }
    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi: " + "\n" +
                "3 kokker: " + kokker[0] + " " + kokker[1] + " " + kokker[2] + "\n" +
                "2 servitører: " + servitorer[0] + " " + servitorer[1] + "\n" +
                "Kapasiteten til brettet er " + kapasitet + " hamburgere" + "\n" +
                "Vi starter...");
    }
}
