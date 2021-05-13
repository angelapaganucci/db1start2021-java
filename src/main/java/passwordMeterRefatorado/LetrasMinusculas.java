package passwordMeterRefatorado;

public class LetrasMinusculas {

    int bonusLowercaseLetters;
    int countLowercaseLetters;

    public LetrasMinusculas(String[] candidateArray, int countLength) {
        countLengthLowercaseLetters(candidateArray);
        calculateBonusLowercaseLetters(countLength);
    }

    public void countLengthLowercaseLetters(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[a-z]")) {
                countLowercaseLetters++;
            }
        }
    }
    public void calculateBonusLowercaseLetters(int countLength) {
        int multiplierLowercaseLetters = 2;
        if (countLowercaseLetters > 0 && countLowercaseLetters < countLength) {
            bonusLowercaseLetters = (countLength - countLowercaseLetters) * multiplierLowercaseLetters;
        } else {
            bonusLowercaseLetters = 0;
        }
    }

    public int getBonusLowercaseLetters() {
        return bonusLowercaseLetters;
    }

    public int getCountLowercaseLetters() {
        return countLowercaseLetters;
    }

    public void setBonusLowercaseLetters(int bonusLowercaseLetters) {
        this.bonusLowercaseLetters = bonusLowercaseLetters;
    }

    public void setCountLowercaseLetters(int countLowercaseLetters) {
        this.countLowercaseLetters = countLowercaseLetters;
    }
}
