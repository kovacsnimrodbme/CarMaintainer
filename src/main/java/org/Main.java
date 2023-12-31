package main.java.org;

import GUI.java.org.*;
import IO.java.org.*;

import java.io.FileNotFoundException;

/**
 * The main class.
 */
public class Main {
    /**
     * The main function.
     *
     * @param args Basic args.
     */
    public static void main(String[] args) {
        Data data = new Data();
        try {
            data = FileIO.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GUI_Init screen = new GUI_Init(data);
        screen.run();
    }
}