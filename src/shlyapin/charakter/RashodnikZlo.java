package shlyapin.charakter;

import java.io.Serializable;

public class RashodnikZlo extends Zlo /*implements Serializable*/ {
    public String nastroenie;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("настроение "+nastroenie);
    }

    @Override
    public String toString() {
        return  "RZ" +
                " nastroenie " + nastroenie +
                " pafos " + pafos +
                " hp " + hp +
                " name " + name;
    }
}
