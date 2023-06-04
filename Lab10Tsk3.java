import java.io.*;
public class Lab10Tsk3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Rirva\\Desktop\\filexsi\\t3.txt"));
        FileWriter fwr = new FileWriter("C:\\Users\\Rirva\\Desktop\\filexsi\\t3.txt", true);
        String line; fwr.write("\nOUT\n");
        while ((line = br.readLine()) != null) {
            if (line.matches(".*[a-z].*")) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.matches(".*[a-z].*")) {
                        fwr.write(word + "\n");
                    }
                }
            }
        }
        fwr.flush();
        fwr.close();
    }
}
