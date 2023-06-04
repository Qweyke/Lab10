import java.io.*;
import java.text.DecimalFormat;
import static java.lang.Math.*;
public class Lab10Tsk11 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t11.txt");
        FileWriter fwr = new FileWriter(file);
        DecimalFormat dec = new DecimalFormat("#.#");
        fwr.write("z = sin(x)+cos^2(x),\n" +
                "x:[0;4]; шаг 0.2\ny:[0;4]; шаг 0.2\n" +
                "\t\t\t\t\t\t\t\nx/y\t");
        for (double y = 0; y <= 4; y+=0.2){
            fwr.write(dec.format(y) + "\t");
        }
        fwr.write("\n");
        for (double x = 0; x <= 4; x+=0.2){
            fwr.write(dec.format(x) + "\t|");
            for (double y = 0; y <= 4; y+=0.2){
                Double z = sin(x)+cos(x)*cos(x);
                fwr.write(dec.format(z) + "|\t|");
            }
            fwr.write("\n");
        }
        fwr.flush();
        fwr.close();
    }

}
