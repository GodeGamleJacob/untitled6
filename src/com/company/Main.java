package com.company;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person [] tabel = new Person[20];
        for (int i = 0; i < 20; i++) {
            tabel[i] = new Person();
        }
        laesTxtFil(tabel);
        udskriv(tabel, 4);
        //skrivTilFil(p);
        skrivDatFil(tabel, 4);
        laesDatFil(tabel, 4);
        udskriv(tabel, 4);
        skrivObjFil(tabel, 4);
        laesObjFil(tabel, 4);
    }

    static void laesTxtFil(Person [] a) {
        try {
            File nyFil = new File("NewFile.txt");
            Scanner ind = new Scanner(nyFil);
            for (int i = 0; i < 4; i++) {
                a[i].setAlder(ind.nextInt());
                a[i].setNavn(ind.next());
                a[i].setTal(ind.nextDouble());
            }
            ind.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void udskriv (Person [] a, int antal) {
        for (int i = 0; i < antal; i++) {
            System.out.format("%d %s %f \n", a[i].getAlder(), a[i].getNavn(), a[i].getTal());
        }
    }

    public static void skrivDatFil(Person [] a, int antal) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("PersonDatFil.dat"));
            for (int i = 0; i < antal; i++) {
                out.writeInt(a[i].getAlder());
                out.writeUTF(a[i].getNavn());
                out.writeDouble(a[i].getTal());
            }
            out.close();
        }
        catch(FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void laesDatFil(Person[] a, int antal) {
        try{
            DataInputStream in = new DataInputStream(new FileInputStream("PersonDatFil.dat"));
            for (int i = 0; i < antal; i++) {
                a[i].setAlder(in.readInt());
                a[i].setNavn(in.readUTF());
                a[i].setTal(in.readDouble());
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void skrivObjFil (Person[] a, int antal) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PersonSerFil.ser"));
            for (int i = 0; i < antal; i++) {
                out.writeObject(a[i]);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void laesObjFil (Person[] a, int antal) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("PersonSerFil.ser"));
            for (int i = 0; i < antal; i++) {
                a[i] = (Person) in.readObject();
            }
            in.close();
            System.out.println("Hej.");
            udskriv(a,4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


        /*public static void skrivTilFil(Person p) {
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

         */
}
