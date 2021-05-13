package passwordMeterRefatorado;

public class NumerosDeCaracteres {

    int bonusLength;
    int countLength;

    public NumerosDeCaracteres(String candidate) {
        countLengthNumberOfCharacters(candidate);
        calculateBonusNumberOfCharacters(candidate);
    }

    public void countLengthNumberOfCharacters(String candidate) {
        countLength = candidate.length();
    }

    public void calculateBonusNumberOfCharacters(String candidate) {
        int multiplierLength = 4;
        int countLength = candidate.length();
        bonusLength = multiplierLength * countLength;
    }

    public int getBonusLength() {
        return bonusLength;
    }

    public int getCountLength() {
        return countLength;
    }

    public void setBonusLength(int bonusLength) {
        this.bonusLength = bonusLength;
    }

    public void setCountLength(int countLength) {
        this.countLength = countLength;
    }
}