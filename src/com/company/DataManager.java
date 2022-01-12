package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataManager {



    public int checkTutorial(){
        int check = 0;
        try {
            File datei = new File("C:\\Users\\mvolg\\IdeaProjects\\Text2Speech\\src\\com\\company\\tutorialinfo.txt");
            Scanner scanner = new Scanner(datei);

            check = scanner.nextInt();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return check;
    }

    public void set_tutorial(){
        try {
            File datei = new File("C:\\Users\\mvolg\\IdeaProjects\\Text2Speech\\src\\com\\company\\tutorialinfo.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(datei));
            pw.print(1);
            pw.flush();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
