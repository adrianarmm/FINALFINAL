public class SUMADIGITOS {
    public static void main(String[] args) {
        int number = 102;
        int sum = SUMADIGITOS(number);
        System.out.println("La suma de numeros  " + number + " es " + sum);
    }

    public static int SUMADIGITOS(int number) {
        if (number < 10) {
            return number;
        } else {
            return number % 10 + SUMADIGITOS(number / 10);
        }
    }
}