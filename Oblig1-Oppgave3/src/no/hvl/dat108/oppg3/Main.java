package no.hvl.dat108.oppg3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Lars", "Erik", "Fredrik"};
        final String[] servitorer = {"Sigve", "Vetle"};

        skrivUtHeader(kokker, servitorer);

        BlockingQueue<Integer> brett = new ArrayBlockingQueue<>(4);

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }
    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer) {
        System.out.println("I denne simuleringen har vi: " + "\n" +
                "3 kokker: " + kokker[0] + " " + kokker[1] + " " + kokker[2] + "\n" +
                "2 servitører: " + servitorer[0] + " " + servitorer[1] + "\n" +
                "Kapasiteten til brettet er 4 hamburgere" + "\n" +
                "Vi starter...");
    }
}
