import java.io.*;
import java.util.*;

public class Lab10Tsk14 {
     public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t14.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<List<Double>> columns = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                if (columns.size() <= i) {
                    columns.add(new ArrayList<>());
                }
                double value = Double.parseDouble(tokens[i]);
                columns.get(i).add(value);
            }
        }

        reader.close();

        FileWriter fw = new FileWriter(file, true);


        for (int i = 0; i < columns.size(); i++) {
            List<Double> column = columns.get(i);


            double max = Collections.max(column);
            double min = Collections.min(column);
            double avg = column.stream().mapToDouble(a -> a).sum() / column.size();


            String text = "\nColumn " + (i + 1) + ": Max = " + max + ", Min = " + min + ", Average = " + avg;
            fw.write(text);
            fw.write(System.lineSeparator());


            for (double value : column) {
                double deviation = value - avg;

                String deviationStr = String.valueOf(deviation);

                fw.write(deviationStr);
                fw.write(" ");
            }
            fw.write(System.lineSeparator());
        }

        fw.close();
    }
}
