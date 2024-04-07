package AdinaPecie;

public class JavaTryCatchFinally {

    public static void main(String[] args) {

        try {
            String cuvant = "cuvant random";
            String rezultat = cuvant.toUpperCase();
            System.out.println("Rezultatul este: " + rezultat);

            int a = 10;
            int b = 2
                    ;
            int result = a / b;
            System.out.println("Dupa ArithmeticException");
        } catch (NullPointerException  e) {
            System.out.println("Am intrat in blocul de catch");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("A intrat in blocul de finally");

            System.out.println("S-a terminat metoda main");

        }
    }
}
