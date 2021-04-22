package shlyapin.charakter;

import java.io.Serializable;

public class NPS extends Dobro /*implements Serializable*/ {
    public String predmet;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("предмет "+predmet);
    }

    @Override
    public String toString() {
        return  "NPS" +
                " predmet " + predmet +
                " haveAGun " + haveAGun +
                " hp " + hp +
                " name " + name;
    }
}
