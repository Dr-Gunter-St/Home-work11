package P2n3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Second {
    private static String fileContentReplacer(Map<String, String> map){
        String string = null;

        try{
            string = new String(Files.readAllBytes(Paths.get("SecondTask.txt")), Charset.defaultCharset());
            for (String s : map.keySet()){
                string = string.replaceAll(s, map.get(s));
            }
            Files.write(Paths.get("SecondTask.txt"), string.getBytes(Charset.defaultCharset()), StandardOpenOption.APPEND); // the last parameter completes the third task
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return string;
    }

    public static void main(String[] args) {

        try(BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("SecondTask.txt"), Charset.defaultCharset())){
            String string = "Hello, world!";
            fileWriter.write(string, 0, string.length());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        Map<String, String> map = new HashMap<>();
        map.put("world", "earth");

        System.out.println(fileContentReplacer(map) + "\n");

    }
}
