package lesson6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Vovik
 * 2/8/2019
 */

public class FileMain {
    public static void main(String[] args) throws IOException {

        System.out.println("\n By stream iterator\n");
        final Stream<String> lines = Files.lines(Paths.get("d:/1.txt"), StandardCharsets.UTF_8);
        Iterator<String> it =  lines.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(" \n By stream lambde\n");
        Files.lines(Paths.get("d:/1.txt"), StandardCharsets.UTF_8).forEach(System.out::println);

        System.out.println(" \n By Bufferedreader\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:/1.txt"), StandardCharsets.UTF_8));
        String line;
        while((line=reader.readLine()) != null){
            System.out.println(line);
        }
    }
}
