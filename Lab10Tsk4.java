import java.io.*;
public class Lab10Tsk4 {
    public static void main(String[] args) throws IOException{
        File fileIN = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t4.1.txt");
        File fileOUT = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t4.2.txt");
        FileReader fread = new FileReader(fileIN);
        BufferedReader bufferedReader = new BufferedReader(fread);
        FileWriter fwr = new FileWriter(fileOUT);
        BufferedWriter bufferedWriter = new BufferedWriter(fwr);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("[_.,;:\\n\\t!?\\s]+");
            for (String word : words) {
                if (isBalanced(word)) {
                    bufferedWriter.write(word);
                    bufferedWriter.newLine();
                }
            }
        }
        fwr.flush();
        bufferedReader.close();
        bufferedWriter.close();
        fwr.close();
    }

    private static boolean isBalanced(String word) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'а' || c == 'е' || c == 'ё' || c == 'и' || c == 'о' || c == 'у' || c == 'ы' || c == 'э' || c == 'ю' || c == 'я') {
                cnt1++;
            } else if (c >= 'а' && c <= 'я') {
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
}
