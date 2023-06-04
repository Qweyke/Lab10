import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lab10Tsk12 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t12.txt");
        BufferedReader fread = new BufferedReader(new FileReader(file));
        BufferedWriter fwr = new BufferedWriter(new FileWriter(file,true));
        String line = fread.readLine();
        fwr.write("\nOUT\n");
        String [] array = line.split(";");
        Pattern pattern = Pattern.compile("(\\d+)\\s+учащихся,\\s+(\\d+)\\s+отличник");
        for (String month : array) {
            fwr.write("Исходная строка: " + month+"\n");
            Matcher matcher = pattern.matcher(month);
            if (matcher.find()) {
                int students = Integer.parseInt(matcher.group(1));
                int excellent = Integer.parseInt(matcher.group(2));
                String newMonth = month.replaceAll("(\\d+)\\s+учащихся", getDeclension(students, "учащийся", "учащихся", "учащих"))
                        .replaceAll("(\\d+)\\s+отличник", getDeclension(excellent, "отличник", "отличника", "отличников"));

                fwr.write("Измененная строка: " + newMonth+"\n");
            } else {
                fwr.write("Ошибка: не найдены данные о численности учащихся и отличников"+"\n");
            }
        }
        fwr.flush();
        fwr.close();
    }
    private static String getDeclension(int number, String one, String two, String five) {
        int mod10 = number % 10;
        int mod100 = number % 100;
        if (mod10 == 1 && mod100 != 11) {
            return number + " " + one;
        } else if (mod10 >= 2 && mod10 <= 4 && (mod100 < 10 || mod100 >= 20)) {
            return number + " " + two;
        } else {
            return number + " " + five;
        }
    }
}
