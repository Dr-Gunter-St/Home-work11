package P1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class First {

    private static String replacer(Map<String, String> map){
        String string = "";


        try( BufferedReader fileReader = Files.newBufferedReader(Paths.get("FirstTask.txt"))){
            string = fileReader.readLine();
            for(String s: map.keySet()){
                string = string.replaceAll(s, map.get(s));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return string;
    }

    public static void main(String[] args) {

        try(BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("FirstTask.txt"), Charset.defaultCharset())){
            String string = "Hello, world!";
            fileWriter.write(string, 0, string.length());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        Map<String, String> map = new HashMap<>();
        map.put("world", "earth");

        System.out.println(replacer(map) + "\n");

    }

}
