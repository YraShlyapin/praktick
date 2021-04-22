package shlyapin.charakter;

public class Zlo extends Person{
    public String pafos;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("пафос "+pafos);
    }

    @Override
    public String toString() {
        return "Zlo{" +
                "pafos='" + pafos + '\'' +
                ", hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }
}
