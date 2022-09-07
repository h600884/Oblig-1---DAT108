package no.hvl.dat108.oppg2;

import java.util.Random;

public class Servitor implements Runnable{
    private final HamburgerBrett brett;
    private final String navn;
    private static int antall;

    public Servitor (HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
        antall = 0;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep((long)(new Random().nextInt(4) + 2)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } synchronized (brett) {
                while (brett.erTom()) {
                    try {
                        System.out.println(navn + "(Servitør) klar for å hente, men brettet er tomt. Venter!");
                        brett.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Hamburger burger = brett.fjern();
            System.out.println(navn + "(Servitør) tar av hamburger " + burger.toString() + ". Brett" + brett.toString());
            synchronized (brett) {
                brett.notifyAll();
            }

        }
    }
}
