import java.io.*;
import java.util.Scanner;

import static java.lang.Math.*;

public class Lab10Tsk10 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t10.txt");
        FileWriter fwr = new FileWriter(file1, true);
        Scanner in = new Scanner(System.in);
        double x;
        System.out.println("Введите значение x");
        while (Math.abs(x = in.nextDouble()) <= 1){
            System.out.println("Ошибка! Введите другое значение x");
        }

        for (double ep = 0.0001; ep <= 0.01; ep*=10){
            int n=0;
            double sum=0;
            while ((abs(atan(x)-((PI/2)+sum)))>ep) {
                sum += (pow(-1,n+1))*(1d/(((2*n)+1)*(pow(x,((2*n)+1)))));
                n++;
            }
            sum=PI/2+sum;
            fwr.write("Функция f(x) = arctg(x) для x = " + x + " равняется " + sum + "\n"
                    +"Результаты определения значений функции f(x) = arctg(x) с помощью ряда Маклорена\n"
                    +"Погрешность итерационной процедуры "+ep+"\n"
                    +"Значение функции по Маклорену\t\tПогрешность, %\tЧисло итераций\n"
                    +"\t"+sum+"\t\t\t\t"+ep*100+"\t\t\t"+n+"\n\n");
        }
        fwr.flush();
        fwr.close();
    }
}
