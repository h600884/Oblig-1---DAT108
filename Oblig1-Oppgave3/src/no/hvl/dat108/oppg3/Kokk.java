package no.hvl.dat108.oppg3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import javax.swing.*;

public class Kokk extends Thread {
    private BlockingQueue<Integer> brett;
    private final String navn;
    private static int antall;

    public Kokk(BlockingQueue<Integer> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep((long) (new Random().nextInt(4) + 2) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                antall += 1;
                brett.put(antall);
                System.out.println(navn + "(Kokk) legger på hamburger " + antall + ". Brett" + brett);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
