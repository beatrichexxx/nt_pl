import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {

    public static int pointPos(double elipseX, double elipseY, double elipseR1, double elipseR2, double pointX, double pointY)
    {
        double res = (Math.pow(pointX - elipseX, 2)/Math.pow(elipseR1, 2)) + (Math.pow(pointY - elipseY, 2)/Math.pow(elipseR2, 2));
        if (res < 1) return 1;
        if (res == 1) return 0;
        if(res > 1 ) return 2;
        return -1;
    }


    public static void main(String[] args) {
        String ellipseFilePath = "task2/elipse.txt";
        String pointFilePath = "task2/points.txt";
//        String ellipseFilePath = args[0];
//        String pointFilePath = args[1];

        double elipseX=0;
        double elipseY=0;
        double elipseR1=0;
        double elipseR2=0;
        try (Scanner scanner = new Scanner(new File(ellipseFilePath))) {
            if (scanner.hasNextDouble()) {
                elipseX = scanner.nextDouble();
                if (scanner.hasNextDouble()) {
                    elipseY = scanner.nextDouble();
                    if (scanner.hasNextDouble()) {
                        elipseR1 = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            elipseR2 = scanner.nextDouble();
                            System.out.println("Эллипс X=" + elipseX + ", Y=" + elipseY + "; R1=" + elipseR1 + ", R2=" + elipseR2);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        double[] pointX = new double[100];
        double[] pointY = new double[100];
        int pointsCount = 0;
        try (Scanner scanner = new Scanner(new File(pointFilePath))) {
            while (scanner.hasNextDouble() && pointsCount<=100) {
                pointX[pointsCount] = scanner.nextDouble();
                if(scanner.hasNextDouble())
                    pointY[pointsCount] = scanner.nextDouble();
                pointsCount++;
            }
        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i<=pointsCount-1; i++) {
            // System.out.println(pointX[i] + " ==== " + pointY[i]);
            System.out.println(pointPos(elipseX, elipseY, elipseR1, elipseR2, pointX[i], pointY[i]));
        }

    }

}




