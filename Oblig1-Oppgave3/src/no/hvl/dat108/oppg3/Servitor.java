package no.hvl.dat108.oppg3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor extends Thread {
    private final BlockingQueue<Integer> brett;
    private final String navn;
    private int antall;

    public Servitor (BlockingQueue<Integer> brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep((long)(new Random().nextInt(4) + 2)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                antall = brett.take();
                System.out.println(navn + "(Servitør) tar av hamburger " + antall+ ". Brett" + brett);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
