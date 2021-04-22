package shlyapin.charakter;

import java.io.Serializable;

public class GlavnoeZlo extends Zlo /*implements Serializable*/ {
    public int mana;


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("мана "+mana);
    }

    @Override
    public String toString() {
        return  "GZ" +
                " mana " + mana +
                " pafos " + pafos +
                " hp " + hp +
                " name " + name;
    }
}
