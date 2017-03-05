package P4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Fourth {
    private static int checkWords(String word){
        String string = null;
        int counter = 0;

        try( BufferedReader fileReader = Files.newBufferedReader(Paths.get("FirstTask.txt"))){
            while ((string = fileReader.readLine()) != null){
             while (string.contains(word)){
                 counter++;
                 string = string.substring(string.indexOf(word) + word.length());
             }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return counter;
    }

    public static void main(String[] args) {

        try(BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("FourthTask.txt"), Charset.defaultCharset())){
            String string = "Hello, world!";
            fileWriter.write(string, 0, string.length());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        String word1 = "world";
        String word2 = "my";

        System.out.println(checkWords(word1));
        System.out.println(checkWords(word2));

    }
}
