package passwordMeterOriginal;

import passwordMeterOriginal.OriginalCode;

class Main {
    public static void main(String[] args) {
        OriginalCode check = new OriginalCode();
        check.checkPassword("R2*c6%8sZ");
        System.out.println(check);
    }
}
