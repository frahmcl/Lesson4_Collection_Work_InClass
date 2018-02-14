package us.mattgreen;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();
    private static int max = 0;
    private static String maxWord = "";
    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
        //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_","").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }



        }
        int count =0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if(entry.getValue() ==1) {
                count++;
            }
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();


            }/*else if (entry.getValue() == 1){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }*/

        }
        System.out.println("Number of words used once: " + count);
        System.out.println("Word with the most entries: " + maxWord + "\nIt appeared this many times: " + max);


    }
    
}