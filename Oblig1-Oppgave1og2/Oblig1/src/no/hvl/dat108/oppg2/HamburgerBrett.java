package no.hvl.dat108.oppg2;

import java.util.ArrayList;

public class HamburgerBrett {
   private ArrayList<Hamburger> koe;

   public HamburgerBrett(int KAPASITET) {
      koe = new ArrayList<Hamburger>(KAPASITET);
   }

   public synchronized boolean erFull() {
      return (koe.size() >= 4);
   }

   public synchronized void leggTil(Hamburger hamburger) {
      koe.add(hamburger);
   }

   public synchronized Hamburger fjern() {
      return koe.remove(0);
   }

   public boolean erTom() {
      return koe.isEmpty();
   }

   @Override
   public String toString() {
      synchronized (this) {
         return koe.toString();
      }
   }
}