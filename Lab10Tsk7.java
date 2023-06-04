import static java.lang.Math.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
public class Lab10Tsk7 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t7.txt");
        FileWriter fwr = new FileWriter(file1);
        fwr.write("Условия:\n\n(x >= -3 && x <= 3); x += 0.5\n\nПри x >= 0, x^2-5\n\nВ противном -x^2+5\n\nИтог\n\n"
                );
        DecimalFormat d = new DecimalFormat("#.#");
        double x = -3;
        while (x <= 3){
            if (x >= 0) fwr.write( "f(" + x + ")\t=\t" + d.format(pow(x,2)-5) + "\n");
            else fwr.write("f(" + x + ")\t=\t" + d.format(-pow(x,2)+5) + "\n");
            x += 0.5;
        }
        fwr.flush();
        fwr.close();
    }
}
