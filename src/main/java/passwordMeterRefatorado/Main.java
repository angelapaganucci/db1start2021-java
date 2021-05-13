package passwordMeterRefatorado;

public class Main {
    public static void main(String[] args) {
        passwordMeterRefatorado.CodigoRefatorado check = new passwordMeterRefatorado.CodigoRefatorado();
        check.checkPassword("1+s*c6%8sZ");
        System.out.println(check);
    }
}