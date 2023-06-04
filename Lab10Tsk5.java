import java.io.*;
public class Lab10Tsk5 {
    public static void main(String[] args) throws IOException {
        File fileIN = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t5.1.txt");
        File fileOUT = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t5.2.txt");
        BufferedReader fread = new BufferedReader(new FileReader(fileIN));
        BufferedWriter fwr = new BufferedWriter(new FileWriter(fileOUT, true));
        String line1;
        fwr.write("\nOUT\n");
        while ((line1 = fread.readLine()) != null) {
            String [] words = line1.split("\\s");
            for (String word : words){
                if (isPalindrome(word)) {
                    fwr.write(word + "\n");
                }
            }
        }
        fwr.flush();
        fwr.close();
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
