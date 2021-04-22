package shlyapin.charakter;

import java.io.Serializable;

public class GlavniGeroi extends Dobro /*implements Serializable*/ {
    public String sposobYpravlenia;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("способ управления "+sposobYpravlenia);
    }

    @Override
    public String toString() {
        return  "GG" +
                " sposobYpravlenia " + sposobYpravlenia +
                " haveAGun " + haveAGun +
                " hp " + hp +
                " name " + name;
    }
}
