package dev.mygame.main.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import dev.mygame.main.enteties.EntityManager;

public class LoadSave{

    public static void createFile() {
        File savefile = new File("res//worlds//saveFile.txt");

        try {
            savefile.createNewFile();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void writeToFile(int ID) {
        File savefile = new File("res//worlds//saveFile.txt");

        try {
            PrintWriter pw = new PrintWriter(savefile);
            pw.println(ID);
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int readFromFile() {
        File savefile = new File("res//worlds//saveFile.txt");
        int savedID = 1;
        try {
            Scanner sc = new Scanner(savefile);
            if(sc.hasNext()) {
                savedID = sc.nextInt();
            }else {
                savedID = 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return savedID;
    }


}
