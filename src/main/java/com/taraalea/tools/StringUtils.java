package com.taraalea.tools;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    static String replaceDefaults(String message, HashMap<String, String> description) {
        //$Name with Alex taken from HashMap
        for (Map.Entry<String, String> entry : description.entrySet()) {
            message = message.replaceAll("\\$"+entry.getKey(),entry.getValue());
            System.out.println(String.format("Trying to replace %s with %s","$"+entry.getKey(),entry.getValue()));
        }
        return message;
    }

    static String replaceDefaults(String message, File description) {
        //${Name} with Alex taken from File
        return "1.2";
    }

    static String replaceTimeVars(String message) {
        // $today[+-][1-1000]
        Pattern today = Pattern.compile("(\\$today)([+-]\\d+)?");
        Matcher m = today.matcher(message);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            Calendar calendar = new GregorianCalendar();
            System.out.println("Found pattern: " + m.group());
            try {
             //   System.out.println("Increment is " + m.group(2));
                calendar.add(Calendar.DATE,Integer.parseInt(m.group(2)));
            } catch (Exception e) {
             //   System.out.println("No such group");
            }
            Date date = calendar.getTime();
            m.appendReplacement(sb,date.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    static String replaceTimeVarsNoMatcher(String message){
        String regex = "\\$\\{([a-z]{2})\\:([a-z]{2})\\}";
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE,-2);
        Date date = calendar.getTime();
        System.out.println(date);
        //Shit load of Date Formats tba
        String finalMsg = message.replaceAll(regex,"$1");
        return finalMsg;
    }


    static String replaceCustomVars(String message) {
        //$random4(a-z)  $random5(1-10)
        byte[] array = new byte[4]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return "3";
    }

    static String normalize(String message) {
        //<Name>Ellen Adams</Name>  ->  <Name>${Name}</Name>
        // XML тэг в формате <xxx></xxx>
        Pattern pattern = Pattern.compile("^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
        return "3";
    }

    static String replaceAlternatives(String message){
        //if after all alternative exists and 1st choice is not a var (starts with $), 1st is taken, otherwise 2nd
        String regex = "\\$\\{([a-z]{2})\\:([a-z]{2})\\}";
        String finalMsg = message.replaceAll(regex,"$1");
        return finalMsg;
    }

    static String replaceFromContext (String message){
        return "5";
    }
}
