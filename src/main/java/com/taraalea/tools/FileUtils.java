package com.taraalea.tools;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

public class FileUtils {

    public static String readMsgFromFile (String filename) {
        FileReader fr = null;
        int b = 0;
        StringBuilder sb = new StringBuilder();

        try {
            fr = new FileReader(filename);
            while ((b = fr.read()) != -1) {
                sb.append((char) b); ///!!!
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void writeMsgToFile (String msg, String filename, boolean appendYN){
        FileWriter fw = null;
        int b = 0;
        StringBuilder sb = new StringBuilder();
        try {
            fw = new FileWriter(filename,appendYN);
            fw.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
