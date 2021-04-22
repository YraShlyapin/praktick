package shlyapin.charakter;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public int hp;
    public String name;

    public void printInfo(){
        System.out.println("здоровье "+hp);
        System.out.println("имя "+name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }
}
