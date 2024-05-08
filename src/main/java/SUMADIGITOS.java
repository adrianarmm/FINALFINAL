public class SUMADIGITOS {
    public static void main(String[] args) {
        int number = 102; // Ejemplo de número
        int sum = SUMADIGITOS(number);
        System.out.println("La suma de los dígitos del número " + number + " es " + sum);
    }

    public static int SUMADIGITOS(int number) {
        if (number < 0) {
            number = -number;  // Convierte el número a positivo si es negativo
        }

        if (number < 10) {
            return number;  // Caso base: si el número tiene un solo dígito, retorna ese dígito
        } else {
            return number % 10 + SUMADIGITOS(number / 10);  // Paso recursivo: suma el último dígito y aplica recursividad al número sin el último dígito
        }
    }
}
