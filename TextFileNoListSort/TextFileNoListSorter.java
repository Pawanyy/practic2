import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TextFileNoListSorter {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers = ReadFileDataToList("input.txt");
        
        System.out.println("Numbers Before Sort: "+ numbers.toString());
        
        Collections.sort(numbers);

        WriteListToFile(numbers, "output.txt");

        System.out.println("Numbers After Sort: " + numbers.toString());
    }

    private static void WriteListToFile(ArrayList<Integer> numbers, String filePath) {
        try {
            File outputFile = new File(filePath);

            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            if (!outputFile.canWrite()) {
                outputFile.setWritable(true);
            }

            FileWriter fileWriter = new FileWriter(outputFile);
            String str = "";
            for (Integer number : numbers) {
                str += (number + "\n");
            }

            fileWriter.write(str.trim());

            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Output File Write Failed!");
        }
    }

    private static ArrayList<Integer> ReadFileDataToList(String filePath) {
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        File file = new File(filePath);

        if(!file.canRead()){
            file.setReadable(true);
        }

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                try {
                    int num = Integer.parseInt(data);
                    numbers.add(num);
                } catch(NumberFormatException e){

                }
            }

            sc.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Input File Not Available!!");
        }
        return numbers;
    }
}