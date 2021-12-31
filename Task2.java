package IBS_Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args){
        File file = new File(args[0]);
        StringBuffer fileData = new StringBuffer();
        if(file.exists()) {
            System.out.println("Открыт файл " + file.getName());
            System.out.println("Список слов в файле и количество повторений: ");
            try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){


                char[] buf = new char[1024];
                int numRead=0;
                while((numRead=reader.read(buf)) != -1){
                    String readData = String.valueOf(buf, 0, numRead);
                    fileData.append(readData);
                }

                String text = new String(fileData);
                List<String> words = new ArrayList<>();
                Pattern pattern = Pattern.compile("[A-Za-zА-Яа-яёЁ0-9]+");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()){
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
                System.out.println("\nЭти слова повторяются больше всех (" + maxValueInMap + " раз(а)):");
                for(Map.Entry<String, Integer> item : dictionary.entrySet()){
                    if (item.getValue()==maxValueInMap) {
                        System.out.println(item.getKey());     // вывож слов(а) с максимальным повторением
                    }
                }
            }

            catch (IOException e){
                System.out.println(e.getMessage());
            }
        } else System.out.println("Указанного файла не существует!");
    }
}
