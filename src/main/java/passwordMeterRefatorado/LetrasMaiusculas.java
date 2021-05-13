package passwordMeterRefatorado;

public class LetrasMaiusculas {

    int bonusUCLetters;
    int countUppercaseLetters;

    public LetrasMaiusculas(String[] candidateArray, int countLength) {
        countLengthUppercaseLetters(candidateArray);
        calculateBonusUppercaseLetters(countLength);
    }

    public void countLengthUppercaseLetters(String[] candidateArray) {
        for (String s : candidateArray) {
            if (s.matches("[A-Z]")) {
                countUppercaseLetters++;
            }
        }
    }

    public void calculateBonusUppercaseLetters(int countLength) {
        int multiplierUppercaseLetters = 2;
        if (countUppercaseLetters > 0 && countUppercaseLetters < countLength) {
            bonusUCLetters = (countLength - countUppercaseLetters) * multiplierUppercaseLetters;
        } else {
            bonusUCLetters = 0;
        }
    }

    public int getBonusUCLetters() {
        return bonusUCLetters;
    }

    public int getCountUppercaseLetters() {
        return countUppercaseLetters;
    }

    public void setBonusUCLetters(int bonusUCLetters) {
        this.bonusUCLetters = bonusUCLetters;
    }

    public void setCountUppercaseLetters(int countUppercaseLetters) {
        this.countUppercaseLetters = countUppercaseLetters;
    }
}
