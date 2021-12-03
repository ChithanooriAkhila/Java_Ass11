import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileFun {
    public static void main(String[] args) {
        HashMap<Character,Integer> map=new HashMap<>();
        Scanner file;
        String line;
        try {
           file = new Scanner(new File(args[0]));
            PrintWriter pw = new PrintWriter("outputFile.txt");
           while (file.hasNextLine()){
               line=file.nextLine();
               for(char ch:line.toCharArray()){
                   map.put(ch,map.getOrDefault(ch,0)+1);
               }
           }
           for(Map.Entry mapElement : map.entrySet()) {
                pw.println("count of " + mapElement.getKey() + " is :" + mapElement.getValue());
           }
           file.close();
           pw.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
