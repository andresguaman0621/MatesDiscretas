

import java.math.*;

public class Conversion {
    public static String ipv4ABinario(String ipAddress) {
        String[] octets = ipAddress.split("\\.");

        if (octets.length != 4) {
            throw new IllegalArgumentException("Dirección IPv4 no válida: " + ipAddress);
        }

        StringBuilder binaryIP = new StringBuilder();

        for (String octet : octets) {
            int decimal = Integer.parseInt(octet);
            String binary = Integer.toBinaryString(decimal);
            String paddedBinary = String.format("%8s", binary).replace(' ', '0');
            binaryIP.append(paddedBinary).append(".");
        }

        binaryIP.setLength(binaryIP.length() - 1); // Eliminar el último punto
        return binaryIP.toString();
    }

    public static String ipv4AHexa(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        StringBuilder hexIpAddress = new StringBuilder();

        for (String octet : octets) {
            int decimal = Integer.parseInt(octet);
            String hex = Integer.toHexString(decimal);
            hexIpAddress.append(hex).append(".");
        }

        hexIpAddress.deleteCharAt(hexIpAddress.length() - 1); // Eliminar el último punto
        return hexIpAddress.toString();
    }

    public static String ipv6ABinario(String ipv6) {
        String[] grupos = ipv6.split(":");
        StringBuilder resultado = new StringBuilder();

        for (String grupo : grupos) {
            String binario = Integer.toBinaryString(Integer.parseInt(grupo, 16));
            while (binario.length() < 16) {
                binario = "0" + binario;
            }
            resultado.append(binario);
            resultado.append(".");
        }

        resultado.deleteCharAt(resultado.length() - 1);  // Elimina el último punto
        return resultado.toString();
    }
    public static BigInteger ipv6ADecimal(String ipv6Address) {
        // Divide la dirección IPv6 en octetos separados por ":"
        String[] octets = ipv6Address.split(":");

        // Inicializa un objeto BigInteger en cero
        BigInteger decimalValue = BigInteger.ZERO;

        // Itera sobre cada octeto y realiza la conversión
        for (String octet : octets) {
            // Convierte el octeto hexadecimal en un objeto BigInteger
            BigInteger octetValue = new BigInteger(octet, 16);

            // Desplaza el valor del octeto a la izquierda en 16 bits
            decimalValue = decimalValue.shiftLeft(16);

            // Agrega el valor del octeto a la suma total
            decimalValue = decimalValue.add(octetValue);
        }

        // Devuelve el valor decimal resultante
        return decimalValue;
    }


/*    public static int numCombinaciones(int n, int r) {
        if (r > n) {
            return 0; // No se pueden seleccionar más elementos de los disponibles
        }

        // Calcula el factorial de un número
        int factorial = 1;
        for (int i = 1; i <= r; i++) {
            factorial *= i;
        }

        // Calcula el número de combinaciones utilizando la fórmula n! / (r! * (n - r)!)
        int combinaciones = 1;
        for (int i = 0; i < r; i++) {
            combinaciones *= (n - i);
            combinaciones /= (i + 1);
        }

        return combinaciones;
    }*/
public static int calcularCombinacionSinRepeticion(int n, int r) {
    if (n < r) {
        return 0;  // Caso inválido, r no puede ser mayor que n
    }

    int numerator = 1;
    int denominator = 1;

    for (int i = 0; i < r; i++) {
        numerator *= n - i;
        denominator *= i + 1;
    }

    return numerator / denominator;
}

    public static int calcularCombinacionConRepeticion(int n, int r) {
        if (n == 0 || r == 0) {
            return 0;  // Caso inválido, n y r deben ser mayores que cero
        }

        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < r; i++) {
            numerator *= n + i;  // Utilizar n + i en lugar de n en cada iteración
            denominator *= i + 1;
        }

        return numerator / denominator;
    }



    public static int calculatePermutations(int n, int r) {
        if (n < r) {
            return 0;  // La cantidad de elementos para permutar (n) no puede ser menor que la cantidad a seleccionar (r)
        }

        int permutations = 1;
        for (int i = 0; i < r; i++) {
            permutations *= (n - i);
        }
        return permutations;
    }

    public static int calculatePermutationsWithRepetition(int n, int r) {
        if (n <= 0 || r <= 0) {
            return 0;  // Ambos 'n' y 'r' deben ser mayores que cero
        }

        int permutations = (int) Math.pow(n, r);
        return permutations;
    }
}
