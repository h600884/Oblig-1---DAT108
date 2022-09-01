package no.hvl.dat108.oppg1;

import javax.swing.*;

public class Main {
    // Dette er start setningen
    private static String nyTekst = "Hallo verden";

    public static void main(String[] args)  {

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                while(!nyTekst.equals("stopp")) {
                    nyTekst = JOptionPane.showInputDialog("Skriv melding, 'stopp' for å avslutte");
                }
            }
        });
        t1.start();

        Runnable r = new MinRunnable();
        while (!nyTekst.equals("stopp")) {
            Thread t2 = new Thread(r, nyTekst);
            t2.start();
            try {
                t2.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MinRunnable implements Runnable {
    @Override
    public void run() {
        String navn = Thread.currentThread().getName();
        System.out.println(navn);
    }
}

