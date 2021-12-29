package IBS_Tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args){
        StringBuffer fileData = new StringBuffer();
        //BufferedReader reader = new BufferedReader(new FileReader("D:\\Doc\\Text.txt"));
        try(BufferedReader reader = new BufferedReader(new FileReader("Text.txt"));){
            char[] buf = new char[1024];
            int numRead=0;
            while((numRead=reader.read(buf)) != -1){
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


        String text = new String(fileData);
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[А-Яа-яёЁ0-9]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            //System.out.println(matcher.group());
            words.add(matcher.group().toLowerCase());
        }
        Collections.sort(words);

        Map<String, Integer> dictionary = new HashMap<>();
        for (String word: words) {
            Integer frequency = dictionary.get(word);
            dictionary.put(word, frequency == null ? 1 : frequency + 1);
        }

        //Выводим результат
        dictionary.forEach((key, value) -> System.out.println(key + " " + value));

        int maxValueInMap=(Collections.max(dictionary.values())); //поиск максимального повторения
        for(Map.Entry<String, Integer> item : dictionary.entrySet()){
            if (item.getValue()==maxValueInMap) {
                System.out.println("Самое повторяющееся слово: " + item.getKey());     // вывож слов(а) с максимальным повторением
            }
        }
    }
}
