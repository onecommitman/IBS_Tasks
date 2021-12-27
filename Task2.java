package IBS_Tasks;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws IOException{
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\Doc\\Text.txt"));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }

        String text = new String(fileData);
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[А-Яа-яёЁ0-9]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            //System.out.println(matcher.group());
            list.add(matcher.group().toLowerCase());
        }
        Collections.sort(list);

        for(String s:list){
            System.out.println(s);
        }
    }
}
