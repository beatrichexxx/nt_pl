import java.io.File; // подключаем класс для работы с файлами
import java.io.FileNotFoundException; // исключение, если файл не найден
import java.util.Scanner; // класс для чтения данных из файла

public class task2 {
   //метод проверки местоположения точки относительно эллипса
    public static int pointPos(double elipseX, double elipseY, double elipseR1, double elipseR2, double pointX, double pointY)
    {
        double res = (Math.pow(pointX - elipseX, 2)/Math.pow(elipseR1, 2)) + (Math.pow(pointY - elipseY, 2)/Math.pow(elipseR2, 2)); //каноническое уравнение эллипса , если значение равно 1, то точка на эллипсе, если больше, то снаружи, если меньше-внуутри
        if (res < 1) return 1;
        if (res == 1) return 0;
        if(res > 1 ) return 2;
        return -1;
    }


    public static void main(String[] args) {
        //String ellipseFilePath = "task2/elipse.txt"; //путь к файлу с параметрами эллипса
        //String pointFilePath = "task2/points.txt"; //путь к файлу с параметрами точек
       String ellipseFilePath = args[0]; //путь к файлу с параметрами эллипса
       String pointFilePath = args[1]; //путь к файлу с параметрами точек

        double elipseX=0;   // координата центра эллипса по оси Х
        double elipseY=0;   // координата центра эллипса по оси У
        double elipseR1=0;  // радиус по оси Х
        double elipseR2=0;  // радиус по оси У
        try (Scanner scanner = new Scanner(new File(ellipseFilePath))) { //создаём объект scanner для чтения файла с параметрами эллипса
              if (scanner.hasNextDouble()) { //проверка, есть ли следующее число типа double
                elipseX = scanner.nextDouble(); //чтение числа (координаты центра по Х) и сохранение в переменную
                if (scanner.hasNextDouble()) {
                    elipseY = scanner.nextDouble(); //чтение числа (координаты центра по У) и сохранение в переменную
                    if (scanner.hasNextDouble()) {
                        elipseR1 = scanner.nextDouble(); //чтение числа первого радиуса и сохранение в переменную
                        if (scanner.hasNextDouble()) {
                            elipseR2 = scanner.nextDouble(); //чтение числа второго радиуса и сохранение в переменную
                           // System.out.println("Эллипс X=" + elipseX + ", Y=" + elipseY + "; R1=" + elipseR1 + ", R2=" + elipseR2); //вывод в консоль значений переменных
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e); // исключение, если файл не найден
        }

        double[] pointX = new double[100]; //создаём массив  для сохранения координат точек по Х
        double[] pointY = new double[100]; //создаём массив  для сохранения координат точек по У
        int pointsCount = 0; //счётчик  точек
        try (Scanner scanner = new Scanner(new File(pointFilePath))) { //создаём объект scanner для чтения файла с координатами точек
            while (scanner.hasNextDouble() && pointsCount<=100) {
                pointX[pointsCount] = scanner.nextDouble(); //чтение Х координаты точки
                if(scanner.hasNextDouble())
                    pointY[pointsCount] = scanner.nextDouble(); //чтение У координаты точки
                pointsCount++;
            }
        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e); // исключение, если файл не найден
        }

        for (int i = 0; i<=pointsCount-1; i++) {
            // System.out.println(pointX[i] + " ==== " + pointY[i]);
            System.out.println(pointPos(elipseX, elipseY, elipseR1, elipseR2, pointX[i], pointY[i])); //вывод в консоль результата метода проверки положения заданной точки относительно эллипса
        }

    }

}




