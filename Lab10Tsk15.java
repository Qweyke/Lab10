import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Lab10Tsk15 {
    public static void main(String[] args) {

        ArrayList<Polygon> plots = readPlotsFromFile("C:\\Users\\Rirva\\Desktop\\filexsi\\plots.txt");
        ArrayList<AnimalArea> animalAreas = readAnimalAreasFromFile("C:\\Users\\Rirva\\Desktop\\filexsi\\animal_areas.txt");
        ArrayList<NatureObject> natureObjects = readNatureObjectsFromFile("C:\\Users\\Rirva\\Desktop\\filexsi\\nature_objects.txt");

        // Определение для каждого участка количества животных и наличия водоема
        ArrayList<PlotInfo> plotInfos = new ArrayList<>();
        for (int i = 0; i < plots.size(); i++) {
            Polygon plot = plots.get(i);
            int animalAreaCount = 0;
            double animalAreaFraction = 0.0;
            int waterBodyCount = 0;
            for (AnimalArea animalArea : animalAreas) {
                if (plot.contains(animalArea.getCenter())) {
                    animalAreaCount++;
                    animalAreaFraction += animalArea.getArea() / plot.getArea();
                }
            }
            for (NatureObject natureObject : natureObjects) {
                if (plot.contains(natureObject.getCenter())) {
                    waterBodyCount++;
                }
            }
            plotInfos.add(new PlotInfo(i + 1, animalAreaCount, animalAreaFraction, waterBodyCount));
        }

        // Вывод результатов в файл
        writePlotInfosToFile("C:\\Users\\Rirva\\Desktop\\filexsi\\plot_infos.txt", plotInfos);
    }

    // Класс для хранения информации об участке
    public static class PlotInfo {
        public int plotNumber;
        public int animalAreaCount;
        public double animalAreaFraction;
        public int waterBodyCount;

        public PlotInfo(int plotNumber, int animalAreaCount, double animalAreaFraction, int waterBodyCount) {
            this.plotNumber = plotNumber;
            this.animalAreaCount = animalAreaCount;
            this.animalAreaFraction = animalAreaFraction;
            this.waterBodyCount = waterBodyCount;
        }
    }

    // Чтение участков из файла
    public static ArrayList<Polygon> readPlotsFromFile(String filename) {
        ArrayList<Polygon> plots = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                Polygon plot = new Polygon();
                for (int i = 0; i < parts.length; i += 2) {
                    double x = Double.parseDouble(parts[i]);
                    double y = Double.parseDouble(parts[i + 1]);
                    plot.addPoint(x, y);
                }
                plots.add(plot);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return plots;
    }

    // Чтение областей обитания животных из файла
    public static ArrayList<AnimalArea> readAnimalAreasFromFile(String filename) {
        ArrayList<AnimalArea> animalAreas = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                double radius1 = Double.parseDouble(parts[2]);
                double radius2 = Double.parseDouble(parts[3]);
                animalAreas.add(new AnimalArea(x, y, radius1, radius2));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return animalAreas;
    }

    // Чтение природных объектов из файла
    public static ArrayList<NatureObject> readNatureObjectsFromFile(String filename) {
        ArrayList<NatureObject> natureObjects = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                double radius = Double.parseDouble(parts[2]);
                natureObjects.add(new NatureObject(x, y, radius));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return natureObjects;
    }

    // Запись информации об участках в файл
    public static void writePlotInfosToFile(String filename, ArrayList<PlotInfo> plotInfos) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filename);
            writer.write("N участка\tКол-во зон с животными\t\t\t% S, занимаемой животными\tкол-во водоемов\n");
            for (PlotInfo plotInfo : plotInfos) {
                writer.write(String.format("%d\t\t\t\t%d\t\t\t\t%.2f\t\t\t\t%d\n",
                        plotInfo.plotNumber,
                        plotInfo.animalAreaCount,
                        plotInfo.animalAreaFraction * 100,
                        plotInfo.waterBodyCount));
            }
            writer.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    // Класс для хранения точки на плоскости
    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Класс для хранения многоугольника
    public static class Polygon {
        private ArrayList<Point> points = new ArrayList<>();

        public void addPoint(double x, double y) {
            points.add(new Point(x, y));
        }

        public double getArea() {
            double area = 0.0;
            int j = points.size() - 1;
            for (int i = 0; i < points.size(); i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                area += (p2.x + p1.x) * (p2.y - p1.y);
                j = i;
            }
            return Math.abs(area / 2.0);
        }

        public boolean contains(Point p) {
            int i, j;
            boolean c = false;
            for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
                if (((points.get(i).y > p.y) != (points.get(j).y > p.y)) &&
                        (p.x < (points.get(j).x - points.get(i).x) * (p.y - points.get(i).y) /
                                (points.get(j).y - points.get(i).y) + points.get(i).x)) {
                    c = !c;
                }
            }
            return c;
        }
    }

    // Класс для хранения области обитания животного
    public static class AnimalArea {
        public Point center;
        public double radius1;
        public double radius2;

        public AnimalArea(double x, double y, double radius1, double radius2) {
            this.center = new Point(x, y);
            this.radius1 = radius1;
            this.radius2 = radius2;
        }

        public Point getCenter() {
            return center;
        }

        public double getArea() {
            return Math.PI * radius1 * radius2;
        }
    }

    // Класс для хранения природного объекта
    public static class NatureObject {
        public Point center;
        public double radius;

        public NatureObject(double x, double y, double radius) {
            this.center = new Point(x, y);
            this.radius = radius;
        }

        public Point getCenter() {
            return center;
        }

    }
}
