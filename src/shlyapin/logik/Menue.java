package shlyapin.logik;

import shlyapin.charakter.*;
import shlyapin.window.Window;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menue  {
    Scanner sc = new Scanner(System.in);
    Scanner scanner;
    //массив строк
    String[] stroki;
    //путь до файла
    File my;
    Scanner scan;
    //имя файла в пути
    String name = "";
    //путь до файла
    File myFile;
    //выбор ответа
    int a;
    //аррай лист всех элементов
    ArrayList<Person> processes = new ArrayList<>();
    //index save_t
    int t = 0;
    //index
    int ind = 0;
    //проверка по имени
    String proverka = "";
    //проверка по хп
    int proverka1 = 0;
    //счетчик
    int count = 0;

    public void start(){
        findingT();
        while (true) {
            printText();
            prov(1, 10);
            switch (a) {
                case 1:
                    vivodArraylista();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    vivodArraylista();
                    System.out.println("введите index того что вы хотите удалить");
                    ind = Integer.parseInt(sc.nextLine());
                    delete(ind);
                    break;
                case 4:
                    System.out.println("введите index того что хотите изменить");
                    ind = Integer.parseInt(sc.nextLine());
                    edit(ind);
                    break;
                case 5:
                    poisk();
                    break;
                case 6:
                    loadingInFile();
                    break;
                case 7:
                    System.out.println("введите 1)добавить 2)изменить");
                    prov(1,2);
                    unloadingOutFile(a);
                    break;
                case 8:
                    deleteFile();
                    break;
                case 9:
                    System.out.println("вы уверены 1)да 2)нет");
                    prov(1,2);
                    if (a==1){
                        return;
                    }
                    break;
//                case 10:
//                    Window app = new Window();
//                    app.setVisible(true);
//                    break;
            }
        }
    }

    //удаление файла
    private void deleteFile(){
        System.out.println("введите имя файла");
        name = sc.nextLine();
        File file = new File("C:\\Users\\Дети\\Desktop\\мои_проЕкты\\java\\homeWorkIerarhia7OOP\\src\\shlyapin\\save\\"+name+".txt");
        if (file.delete()){
            System.out.println("файл "+name+" был успешно удален");
        }else System.out.println("файл "+name+" не был найден");
    }

    //вывод текста меню
    private void printText(){
        System.out.println("Фунцкии приложения:\n" +
                "1) Вывод всего списка\n" +
                "2) Добавление\n" +
                "3) Удаление\n" +
                "4) Изменение\n" +
                "5) Поиск\n" +
                "6) Загрузка в файл\n" +
                "7) Выгрузка из файла\n" +
                "8) удаление файла\n" +
                "9) Выход из программы");
    }

    //вывод всего списка
    private void vivodArraylista(){
        count=0;
        for (Person f : processes) {
            System.out.println("index этемента "+count);
            f.printInfo();
            System.out.println("\n");
            count++;
        }
    }

    //изменение элемента в списке
    private void edit(int ind){
        delete(ind);
        add();
    }

    //удаление элемента из списка
    private void delete(int ind){
        try {
            processes.remove(ind);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Элемента под этим индексом не существует\n+");
        }

    }

    //поиск и вывод элемента
    private void poisk(){
        count = 0;
        System.out.println("введите по какому параметру вы хотите искать 1)искать по hp 2)искать по имени");
        prov(1,2);
        switch (a){
            case 1:
                System.out.println("введите количиство злоровья ");
                proverka1 = Integer.parseInt(sc.nextLine());
                for (Person f : processes) {
                    if (f.hp == proverka1){
                        System.out.println("index этемента "+count);
                        f.printInfo();
                        System.out.println("\n");
                    }
                    count++;
                }

                break;
            case 2:
                System.out.println("введите имя ");
                proverka = sc.nextLine();
                for (Person f : processes) {
                    if (f.name.equals(proverka)){
                        System.out.println("index этемента "+count);
                        f.printInfo();
                        System.out.println("\n");
                    }
                    count++;
                }
                break;
        }
    }

    //проверка ввода
    private void prov(int i,int ii){
        a = Integer.parseInt(sc.nextLine());
        while (a<i||a>ii){
            System.out.println("вы ввели не то");
            a = Integer.parseInt(sc.nextLine());
        }
    }

    private void loadingInFile(){
        try {
            System.out.println("введите имя файла");
            name = sc.nextLine();
            if (name.equals("")){
                name = "save_"+t;
                BufferedWriter writer1 = new BufferedWriter(new FileWriter(myFile));
                writer1.write((++t)+"");
                writer1.flush();
                writer1.close();
            }
            FileOutputStream outputStream = new FileOutputStream("resours\\save\\"+name+".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(processes);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unloadingOutFile(int b){
        try {
            System.out.println("введите имя файла");
            name = sc.nextLine();
            FileInputStream fileInputStream = new FileInputStream("resours\\save\\"+name+".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            if (b == 1){
                //каждый раз добавляет а не изменяет
                 for (Person f:(ArrayList<Person>) objectInputStream.readObject()){
                     processes.add(f);
                 }
            }else {
                //перезапись списка
                processes = (ArrayList<Person>) objectInputStream.readObject();
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //добавление элемента в список
    private void add(){
        System.out.println("выберите 1)добро 2)зло");
        prov(1,2);
        if(a==1){
            System.out.println("выберите 1)NPS 2)главный герой");
            prov(1,2);
            if (a == 1){
                NPS nps = new NPS();
                System.out.println("введите hp");
                nps.hp = Integer.parseInt(sc.nextLine());
                System.out.println("введите имя");
                nps.name = sc.nextLine();
                System.out.println("введите имеет ли оружие");
                nps.haveAGun = Boolean.parseBoolean(sc.nextLine());
                System.out.println("введите предмет");
                nps.predmet = sc.nextLine();
                processes.add(nps);
            }else {
                GlavniGeroi glavniGeroi = new GlavniGeroi();
                System.out.println("введите имеет ли оружие");
                glavniGeroi.haveAGun = Boolean.parseBoolean(sc.nextLine());
                System.out.println("введите hp");
                glavniGeroi.hp = Integer.parseInt(sc.nextLine());
                System.out.println("введите имя");
                glavniGeroi.name = sc.nextLine();
                System.out.println("введите способ управления");
                glavniGeroi.sposobYpravlenia = sc.nextLine();
                processes.add(glavniGeroi);
            }
        }else {
            System.out.println("выберите 1)расходник зла 2)главное зло");
            prov(1,2);
            if (a == 1){
                RashodnikZlo rashodnikZlo = new RashodnikZlo();
                System.out.println("введите hp");
                rashodnikZlo.hp = Integer.parseInt(sc.nextLine());
                System.out.println("введите имя");
                rashodnikZlo.name = sc.nextLine();
                System.out.println("введите настроение");
                rashodnikZlo.nastroenie = sc.nextLine();
                System.out.println("введите пафос");
                rashodnikZlo.pafos = sc.nextLine();
                processes.add(rashodnikZlo);
            }else {
                GlavnoeZlo glavnoeZlo = new GlavnoeZlo();
                System.out.println("введите hp");
                glavnoeZlo.hp = Integer.parseInt(sc.nextLine());
                System.out.println("введите ману");
                glavnoeZlo.mana = Integer.parseInt(sc.nextLine());
                System.out.println("введите пафос");
                glavnoeZlo.pafos = sc.nextLine();
                System.out.println("введите имя");
                glavnoeZlo.name = sc.nextLine();
                processes.add(glavnoeZlo);
            }
        }
    }

    //нахождение т ((т это индех если сохранение не имеет имени тогда он записывается save_t
    private void findingT(){
        try {
            myFile = new File("resours\\systemFile\\levl.txt");
            scan = new Scanner(myFile);
            String line1 = scan.nextLine();
            t=Integer.parseInt(line1);
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
    }

    //выгрузка из файла OldVersion
    private void unloadingOutFileOldVersion(){
        try {
            name = sc.nextLine();
            my = new File("C:\\Users\\Дети\\Desktop\\мои_проЕкты\\java\\homeWorkIerarhia7OOP\\src\\shlyapin\\save\\"+name+".txt");
            scanner = new Scanner(my);
            String line = scanner.nextLine();
            stroki = line.split(" !!@PROBELII!! ");
            for (int i = 0; i < stroki.length; i++) {
                String[] slova = stroki[i].split(" ");
                if (slova[0].equals("NPS")) {
                    NPS nps = new NPS();
                    nps.predmet = slova[2];
                    nps.haveAGun = Boolean.parseBoolean(slova[4]);
                    nps.hp = Integer.parseInt(slova[6]);
                    nps.name = slova[8];
                    processes.add(nps);
                }else if (slova[0].equals("GZ")) {
                    GlavnoeZlo gZ = new GlavnoeZlo();
                    gZ.mana = Integer.parseInt(slova[2]);
                    gZ.pafos = slova[4];
                    gZ.name = slova[8];
                    gZ.hp = Integer.parseInt(slova[6]);
                    processes.add(gZ);
                }else if (slova[0].equals("GG")) {
                    GlavniGeroi GG = new GlavniGeroi();
                    GG.sposobYpravlenia = slova[2];
                    GG.name = slova[8];
                    GG.hp = Integer.parseInt(slova[6]);
                    GG.haveAGun = Boolean.parseBoolean(slova[4]);
                    processes.add(GG);
                }else if (slova[0].equals("RZ")) {
                    RashodnikZlo RZ = new RashodnikZlo();
                    RZ.nastroenie = slova[2];
                    RZ.pafos = slova[4];
                    RZ.name = slova[8];
                    RZ.hp = Integer.parseInt(slova[6]);
                    processes.add(RZ);
                }
            }
        }catch (FileNotFoundException f){
            System.out.println("Файл не найден, исключение");
        }
    }

    //загрузка в файл OldVersion
    private void loadingInFileOldVersion(){
        name = sc.nextLine();
        if (name.equals("")){
            name = "save_"+t;
        }
        my = new File("C:\\Users\\Дети\\Desktop\\мои_проЕкты\\java\\homeWorkIerarhia7OOP\\src\\shlyapin\\save\\"+name+".txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(my));
            for (Person n:processes){
                writer.write(n.toString()+" !!@PROBELII!! ");
            }
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(myFile));
            writer1.write((++t)+"");
            writer1.flush();
            writer1.close();

            writer.flush();
            writer.close();
        }catch (IOException ex){
            System.out.println("IO исключение");
        }
    }

}