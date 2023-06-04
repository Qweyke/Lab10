import java.io.*;
import java.util.*;
public class Lab10Tsk9 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t9.txt");
        FileWriter fwr = new FileWriter(file, true);

        BufferedReader fread = new BufferedReader(new FileReader(file));

        String[] array = new String[3];

        for (int i = 0; i < array.length ; i++) {
            array[i] = fread.readLine();
        }

        int cntOver1Mln = 0;
        int cntWithGP = 0;

        for (String row : array) {

            String[] data = row.split(" ");

            int funding = Integer.parseInt(data[1]);
            int groupSize= Integer.parseInt(data[2]);

            if (funding > 1000000 && groupSize < 5)
                cntOver1Mln++;

            int students = Integer.parseInt(data[3]);
            int aspirants = Integer.parseInt(data[4]);

            if (students >= 2 && aspirants > 0)
                cntWithGP++;
        }

        fwr.write("Количество проектов с финансированием более 1 млн: " + cntOver1Mln + "\n");

        fwr.write("Количество проектов с аспирантами и студентами: " + cntWithGP + "\n");

        Map<String, Integer> facultyCnt = new HashMap<>();

        for (String row : array) {
            String[] data = row.split(" ");
            String faculty = data[0];
            facultyCnt.put(faculty, facultyCnt.getOrDefault(faculty, 0) + 1);
        }

        String mapAsString = facultyCnt.toString();
        fwr.write(mapAsString);
        fwr.flush();
        fwr.close();
    }

}

