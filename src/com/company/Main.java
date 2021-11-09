package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //skrivFil();
        //datFil();
        //laesDatFil();
        Person [] tabel = new Person[20];
        laesTxtFil(tabel);

        //udskriv(tabel, 4);
        //skrivTilFil(p);

    }

    static void laesTxtFil(Person [] a) {
        Person [] tabel = new Person[20];
        try {
            File nyFil = new File("NewFile.txt");
            Scanner ind = new Scanner(nyFil);
            //for (int i = 0; i < 4; i++) {

                tabel[0].setAlder(ind.nextInt());
                System.out.println(tabel[0].getAlder());
                //a[i].setNavn(ind.next());
                //a[i].setTal(ind.nextDouble());
            //}
            ind.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void udskriv (Person [] a, int antal) {
        //for (int i = 0; i < antal; i++) {

            //System.out.format("%d %s %f", a[i].getAlder(), a[i].getNavn(), a[i].getTal());

        //}
    }

    public static void skrivTilFil(Person p) {
        try {
            PrintWriter ud = new PrintWriter("NewPerson.txt");

            ud.format("%d %s %.3f", p.getAlder(), p.getNavn(), p.getTal());
            ud.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void skrivFil() {
        try {
            PrintWriter ud = new PrintWriter("NewFile.txt");
            int i = 1;
            String navn = "Pernille";
            float tal = (float) 10.5;
            ud.format("%d %s %.3f", i, navn, tal);
            ud.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void datFil() {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Newdatfil"));
            int i = 1;
            String navn = "Pernille";
            float tal = (float) 10.5;
            output.writeInt(i);
            output.writeUTF(navn);
            output.writeFloat(tal);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void laesDatFil () {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("Newdatfil"));
            int i;
            String navn;
            float tal;
            i = input.readInt();
            navn = input.readUTF();
            tal = input.readFloat();
            System.out.format("%d %s %f \n", i, navn, tal);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
