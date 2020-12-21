package com.taraalea.tools;

import java.util.HashMap;

public class Tools {
    public static void main (String[] args){
        HashMap<String,String> defaultsMap = new HashMap<String,String>();
        defaultsMap.put("Country","USA");
        defaultsMap.put("USPrice","11.22");

        String messge = FileUtils.readMsgFromFile("C:\\Users\\AlexZen\\IdeaProjects\\Tools\\src\\main\\resources\\Example.xml");

        messge = StringUtils.replaceDefaults(messge,defaultsMap);
        messge = StringUtils.replaceTimeVars(messge);
        messge = StringUtils.replaceAlternatives(messge);

        FileUtils.writeMsgToFile(messge,"C:\\Users\\AlexZen\\IdeaProjects\\Tools\\src\\main\\resources\\New.xml",false);
    }
}
