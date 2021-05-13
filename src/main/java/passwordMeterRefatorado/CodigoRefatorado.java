package passwordMeterRefatorado;

public class CodigoRefatorado {

    public String password;
    public Score score;

    public NumerosDeCaracteres numerosDeCaracteres;
    public LetrasMaiusculas letrasMaiusculas;
    public LetrasMinusculas letrasMinusculas;
    public Numeros numeros;
    public Simbolos simbolos;
    public NumerosOuSimbolosNoMeio numerosOuSimbolosNoMeio;
    public Requerimentos requerimentos;
    public SomenteLetras somenteLetras;
    public SomenteNumeros somenteNumeros;
    public CaracteresRepetidos caracteresRepetidos;
    public LetrasMaiusculasConsecutivas letrasMaiusculasConsecutivas;
    public LetrasMinusculasConsecutivas letrasMinusculasConsecutivas;
    public NumerosConsecutivos numerosConsecutivos;
    public LetrasSequenciais letrasSequenciais;
    public NumerosSequenciais numerosSequenciais;
    public SimbolosSequenciais simbolosSequenciais;


    public void checkPassword(String candidate) {
        password = candidate;
        String[] arrPwd = candidate.replaceAll("\\s+", "").split("\\s*");

        numerosDeCaracteres = new NumerosDeCaracteres(candidate);
        int countLength = numerosDeCaracteres.getCountLength();

        letrasMaiusculas = new LetrasMaiusculas(arrPwd,countLength);
        int countAlphaUC = letrasMaiusculas.getCountUppercaseLetters();

        letrasMinusculas = new LetrasMinusculas(arrPwd, countLength);
        int countAlphaLC = letrasMinusculas.getCountLowercaseLetters();

        numeros = new Numeros(arrPwd, countLength);
        int countNumber = numeros.getCountNumbers();

        simbolos = new Simbolos(arrPwd);
        int countSymbol = simbolos.getCountSymbols();

        numerosOuSimbolosNoMeio = new NumerosOuSimbolosNoMeio(arrPwd);
        requerimentos = new Requerimentos(countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol, candidate);
        somenteLetras = new SomenteLetras(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        somenteNumeros = new SomenteNumeros(countLength, countAlphaLC, countAlphaUC, countSymbol, countNumber);
        caracteresRepetidos = new CaracteresRepetidos(arrPwd);
        letrasMaiusculasConsecutivas = new LetrasMaiusculasConsecutivas(arrPwd);
        letrasMinusculasConsecutivas = new LetrasMinusculasConsecutivas(arrPwd);
        numerosConsecutivos = new NumerosConsecutivos(arrPwd);
        letrasSequenciais = new LetrasSequenciais(candidate);
        numerosSequenciais = new NumerosSequenciais(candidate);
        simbolosSequenciais = new SimbolosSequenciais(candidate);

        score = new Score(numerosDeCaracteres.getBonusLength(), letrasMaiusculas.getBonusUCLetters(), letrasMinusculas.getBonusLowercaseLetters(),
                numeros.getBonusNumbers(), simbolos.getBonusSymbols(), numerosOuSimbolosNoMeio.getBonusMiddleNumberOrSymbols(),
                requerimentos.getBonusRequirements(), somenteLetras.getBonusLetterOnly(), somenteNumeros.getBonusNumbersOnly(),
                caracteresRepetidos.getBonusRepeatCharacters(), letrasMaiusculasConsecutivas.getBonusConsecutiveUppercaseLetters(),
                letrasMinusculasConsecutivas.getBonusConsecutiveLowercaseLetters(), numerosConsecutivos.getBonusConsecutiveNumber(),
                letrasSequenciais.getBonusSequencialLetters(), numerosSequenciais.getBonusSequencialNumbers(), simbolosSequenciais.getBonusSequencialSymbols());
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score.getScore()+"%"
                + "\nComplexity: " + score.getsComplexity()

                + "\nAddictions"
                + "\n[C: " + numerosDeCaracteres.getCountLength() + " | B: " + numerosDeCaracteres.getBonusLength() + "] Number of Characters"
                + "\n[C: " + letrasMaiusculas.getCountUppercaseLetters() + " | B: " + letrasMaiusculas.getBonusUCLetters() + "] Uppercase Letters"
                + "\n[C: " + letrasMinusculas.getCountLowercaseLetters() + " | B: " + letrasMinusculas.getBonusLowercaseLetters() + "] Lowercase Letters"
                + "\n[C: " + numeros.getCountNumbers() + " | B: " + numeros.getBonusNumbers() + "] Numbers"
                + "\n[C: " + simbolos.getCountSymbols() + " | B: " + simbolos.getBonusSymbols() + "] Symbols"
                + "\n[C: " + numerosOuSimbolosNoMeio.getCountMiddleNumbersOrSymbols() + " | B: " + numerosOuSimbolosNoMeio.getBonusMiddleNumberOrSymbols() + "] Middle Numbers or Symbols"
                + "\n[C: " + requerimentos.getCountRequirements() + " | B: " + requerimentos.getBonusRequirements() + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + somenteLetras.getCountLetterOnly() + " | B: " + somenteLetras.getBonusLetterOnly() + "] Letters Only"
                + "\n[C: " + somenteNumeros.getCountNumbersOnly() + " | B: " + somenteNumeros.getBonusNumbersOnly() + "] Numbers Only"
                + "\n[C: " + caracteresRepetidos.getCountRepeatCharacters() + " | B: " + caracteresRepetidos.getBonusRepeatCharacters() + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + letrasMaiusculasConsecutivas.getCountConsecutiveUppercaseLetters() + " | B: " + letrasMaiusculasConsecutivas.getBonusConsecutiveUppercaseLetters() + "] Consecutive Uppercase Letters"
                + "\n[C: " + letrasMinusculasConsecutivas.getCountConsecutiveLowercaseLetters() + " | B: " + letrasMinusculasConsecutivas.getBonusConsecutiveLowercaseLetters() + "] Consecutive Lowercase Letters"
                + "\n[C: " + numerosConsecutivos.getCountConsecutiveNumber() + " | B: " + numerosConsecutivos.getBonusConsecutiveNumber() + "] Consecutive Numbers"
                + "\n[C: " + letrasSequenciais.getCountSequencialLetters() + " | B: " + letrasSequenciais.getBonusSequencialLetters() + "] Sequential Letters"
                + "\n[C: " + numerosSequenciais.getCountSequencialNumbers() + " | B: " + numerosSequenciais.getBonusSequencialNumbers() + "] Sequential Numbers"
                + "\n[C: " + simbolosSequenciais.getCountSequencialSymbols() + " | B: " + simbolosSequenciais.getBonusSequencialSymbols() + "] Sequential Symbols";
    }
}