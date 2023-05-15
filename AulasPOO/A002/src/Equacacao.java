import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Equacacao {
    private double coeficienteA;
    private double coeficienteB;
    private double coeficienteC;
    private double raiz1;
    private double raiz2;
    private double delta;

    Equacacao(double coeficienteA, double coeficienteB, double coeficienteC){
        definirCoeficientes(coeficienteA, coeficienteB, coeficienteC);
    }
    Equacacao(String equacacao){
        double[] coeficientes = this.parseString(equacacao);
        definirCoeficientes(coeficientes[0],coeficientes[1],coeficientes[2]);
    }

    private void definirCoeficientes(double coeficienteA, double coeficienteB, double coeficienteC){
        if(coeficienteA == 0) throw new IllegalArgumentException("O coeficiente que ao ser multiplicado pela icognica elevado ao quadrado não pode ser zero. Pois quebra os princípios matemáticos de uma equação de segundo grau!");
        this.coeficienteA = coeficienteA;
        this.coeficienteB = coeficienteB;
        this.coeficienteC = coeficienteC;
        this.calcularDelta();
        this.calcularRaizes();
    }
    private double[] parseString(String eq){
        if(eq == null) throw new IllegalArgumentException("Pelo amor de deus, não acredito nisso.");
        double[] coeficientes = {};
        String regex = "((?:\\-|\\+|)(?:\\d+))x\\^2(?:((?:\\-|\\+|)(?:\\d+))x|)(?:((?:\\-|\\+|)(?:\\d+))|)=0";
        String string = "-12x^2+3=0";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if(matcher.find() == false) throw new IllegalArgumentException("A equação informada está no formato incorreto e não corresponde a uma equação de 2º Grau!");

        coeficientes[0] = Double.parseDouble(matcher.group(1));

        String coef2 = matcher.group(2);
        coeficientes[1] = coef2 == null ? 0 : Double.parseDouble(coef2);

        String coef3 = matcher.group(3);
        coeficientes[2] = coef3 == null ? 0 : Double.parseDouble(coef3);

        return coeficientes;
    }
    private void calcularDelta(){
        delta = Math.pow(coeficienteB,2) - 4 * coeficienteA *coeficienteC;
    }
    private void calcularRaizes(){
        if(delta > 0) {
            double denominador = 2 * coeficienteA;
            double coeficienteBNegativo = coeficienteB * -1;
            double raizDelta = Math.sqrt(delta);
            raiz1 = (coeficienteBNegativo + raizDelta) / denominador;
            raiz2 = (coeficienteBNegativo - raizDelta) / denominador;
        }else if(delta == 0){
            double denominador = 2 * coeficienteA;
            double coeficienteBNegativo = coeficienteB * -1;
            double raizDelta = Math.sqrt(delta);
            raiz1 = (coeficienteBNegativo + raizDelta) / denominador;
            raiz2 = raiz1;
        }
    }

    public double getCoeficienteA() {
        return coeficienteA;
    }
    public double getCoeficienteB() {
        return coeficienteB;
    }
    public double getCoeficienteC() {
        return coeficienteC;
    }
    public double getDelta() {
        return delta;
    }
    public double getRaiz1() {
        if(delta < 0) throw new ArithmeticException("Está equação possui a discriminate delta negativa. Não possuí resultado dentro do intervalo dos números reais!");
        return raiz1;
    }
    public double getRaiz2() {
        if(delta < 0) throw new ArithmeticException("Está equação possui a discriminate delta negativa. Não possuí resultado dentro do intervalo dos números reais!");
        return raiz2;
    }
}
