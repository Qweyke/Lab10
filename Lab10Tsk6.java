import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Lab10Tsk6 {
    public static void main(String[] args) throws IOException{
        int cnt = 0;
        BufferedReader fread = new BufferedReader(new FileReader("C:\\Users\\Rirva\\Desktop\\filexsi\\t6.txt"));
        BufferedWriter fwr = new BufferedWriter(new FileWriter("C:\\Users\\Rirva\\Desktop\\filexsi\\t6.txt",true));
        String line; fwr.write("\nOUT\n");
        while ((line = fread.readLine()) != null) {
            String[] coffeeData = line.split(",");
            if (coffeeData.length >= 3) {
                String type = coffeeData[2].trim();
                int weight = Integer.parseInt(coffeeData[1].trim());
                if ("зерно".equals(type) && weight >= 150 && weight <= 380) {
                    cnt++;
                    fwr.write(line);
                    fwr.newLine();
                }
            }
        }
        fwr.write("Количество пачек с зерном и массой от 150 до 380 гр.: " + cnt);
        fwr.flush();
        fwr.close();
    }
}
