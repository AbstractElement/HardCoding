package com.content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Vladislav on 01.02.2017.
 *
 * Класс, который загружает описание игры из файла.
 */
public class ReadHistory {
    public static StringBuilder getStory(){
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/history"));
            while (bufferedReader.ready())
                text.append(bufferedReader.readLine()).append("\n");
            bufferedReader.close();
            return text;

        } catch (IOException e) {
            return text;
        }
    }
}
