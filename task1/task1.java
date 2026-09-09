public class task1 {

    public static String getPath(int n, int m)
    {
        int ind = 1;
        String path = "";
        do {
            path += ind;
            ind = (ind + m - 1);

            if (ind > n) ind =(ind % n);

        }
        while (ind!=1);
        return path;
    }

    public static void main(String[] args) {
        // Ввод первого числа
        int n1 = Integer.parseInt(args[0]);
        // Ввод второго числа
        int m1 = Integer.parseInt(args[1]);
        // Ввод третьего числа
        int n2 = Integer.parseInt(args[2]);
       // Ввод четвёртого числа
        int m2 = Integer.parseInt(args[3]);
        if (n1 <= 0 || m1 <= 0) {
            System.out.println("Ошибка: аргументы n и m должны быть натуральными числами");
            return;
        }
        if (n2 <= 0 || m2 <= 0) {
            System.out.println("Ошибка: аргументы n и m должны быть натуральными числами");
            return;
        }

        System.out.println(getPath(n1, m1) + getPath(n2, m2));

        }

}




