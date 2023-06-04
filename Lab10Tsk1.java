import java.io.*;
public class Lab10Tsk1 {



        public static void main(String[] args) throws IOException {
            File file = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t1.txt");
            FileWriter fwr = new FileWriter(file, true);
            BufferedReader br = new BufferedReader(new FileReader(file));
            fwr.write("\n");
            String str = br.readLine();
            char [] arr = str.toCharArray();
            int cnt1 = 0;
            for (char c : arr) {
                if (Character.isUpperCase(c) && Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                    cnt1++;
                }
            }
            fwr.write("Количество прописных букв русского языка: " + cnt1+"\n");
            char a = ',';
            boolean flag = false;
            for (char c : arr) {
                if (c == a) {
                    flag = true;
                    break;
                }
            }
            fwr.write("Знак препинания " + a + " присутствует: " + flag+"\n");
            String word = "ada";
            int cnt2 = 0;
            for (char c : arr) {
                if (word.indexOf(c) != -1) {
                    cnt2++;
                }
                if (cnt2 >= 2) {
                    break;
                }
            }
            fwr.write("Среди символов имеются хотя бы две буквы из слова: " + (cnt2 >= 2)+"\n");
            boolean flag2 = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] == 'т' && arr[i + 1] == 'о') || (arr[i] == 'о' && arr[i + 1] == 'т')) {
                    flag2 = true;
                    break;
                }
            }
            fwr.write("Имеется ли среди символов пара соседствующих букв «то» или «от»: " + flag2+"\n");
            boolean flag3 = false;
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                    flag3 = true;
                    break;
                }
            }
            fwr.write("Имеется ли среди символов три подряд идущих одинаковых символа: " + flag3+"\n");
            boolean flagE = false;
            for (int i = arr.length / 2 + 1; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                    if (Character.isDigit(arr[i]) && Character.isDigit(arr[i + 1]) && Math.abs(arr[i] - arr[i + 1]) == 1 &&
                            Character.isLetter(arr[j]) && Character.isLetter(arr[j + 1]) && arr[j] == arr[j + 1]) {
                        flagE = true;
                        break;
                    }
                }
                if (flagE) {
                    break;
                }
            }
            fwr.write("Верно ли условие е: " + flagE+"\n");
            fwr.flush();
            fwr.close();
        }
    }


