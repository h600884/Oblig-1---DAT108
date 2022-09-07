package no.hvl.dat108.oppg2;

import javax.swing.*;
import java.util.Random;

public class Kokk implements Runnable {

    private final HamburgerBrett brett;
    private final String navn;
    private static int antall = 0;

    public Kokk(HamburgerBrett brett, String navn) {
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
            } synchronized (brett) {
                while (brett.erFull()) {
                    try {
                        System.out.println(navn + "(Kokk) klar med hamburger, men brettet er fullt. Venter!");
                        brett.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                antall++;
            }
            Hamburger burger = new Hamburger(antall);
            brett.leggTil(burger);
            System.out.println(navn + "(Kokk) legger på hamburger " + burger + ". Brett" + brett);
            synchronized (brett) {
                brett.notifyAll();
            }

        }
    }
}
