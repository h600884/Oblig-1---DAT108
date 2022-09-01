package no.hvl.dat108.oppg2;

public class Hamburger {

    public final int nummer;

    public Hamburger(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return "(" + nummer + ')';
    }
}
