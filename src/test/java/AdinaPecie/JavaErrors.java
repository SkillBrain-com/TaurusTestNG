package AdinaPecie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaErrors {

    public static void main(String[] args) {
        //throw - il utilizam pentru a arunca explicit o eroare
        //throws- o atentionare ca o metoda sau un constructor arunca o eroare/ exceptie
        //try - catch - finally ->Handler



//        checkedExceptions();
//        uncheckedExceptions();
//        int i = 1;
//        metodaRecursiva(5 ,i);
//        System.out.println("S a terminat metoda main");
//        throwsException();
        try{
        throw new MyCustomException("Am trimis acest mesaj");
    }catch(MyCustomException e){
            System.out.println("Am intrat in ramura catch");
        }finally{
            System.out.println("S-a terminat metoda main");
        }

        }

    public static void throwsException() {
        throw new ArithmeticException();
    }
        //checked exceptions

        public static void checkedExceptions() throws IOException {

            FileReader file = new FileReader("C:\\Users\\adina\\Desktop\\Text.txt");
            BufferedReader fileInput = new BufferedReader(file);
            System.out.println(fileInput.readLine());
            fileInput.close();

        }

        //unchecked exceptions

    public static void uncheckedExceptions() {

        //NullPointerException
//        String cuvant = null;
//        cuvant.length();

        //ArithmeticException
        int a = 10;
        int b = 0;
        int result = a/b;

        System.out.println("Rezultatul este: " + result);

    }

    public static void metodaRecursiva (int numar, int i) {
        if( numar==0) {

            return;
        }else{
            System.out.println("Numarul este:" + i);
            i++;
            metodaRecursiva(numar, i);
        }
    }
}

