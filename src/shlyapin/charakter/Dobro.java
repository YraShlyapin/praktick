package shlyapin.charakter;

import java.util.ArrayList;

public class Dobro extends Person{
    public boolean haveAGun;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("имеет ли оружие "+haveAGun);
    }

    @Override
    public String toString() {
        return "Dobro{" +
                "haveAGun=" + haveAGun +
                ", hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }
}
