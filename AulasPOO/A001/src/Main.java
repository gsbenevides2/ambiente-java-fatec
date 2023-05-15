public class Main {
    public static void oldmain(String[] args) {
        double coeficiente1 = 3, coeficiente2 = -1, coeficiente3= -2;
        double delta = Math.pow(coeficiente2, 2) + (-4 * coeficiente1 * coeficiente3);
        if(delta < 0) System.out.println("Não possue raizes reais!");
        else {
            double primeiroResultado = ((-1 * coeficiente2) + Math.sqrt(delta)) / (2 * coeficiente1);
            double segundoResultado = ((-1 * coeficiente2) - Math.sqrt(delta)) / (2 * coeficiente1);
            System.out.println("O x1 é: " + primeiroResultado + " (valor esperado: 1)");
            System.out.println("O x2 é: " + segundoResultado + " (valor esperado -0.6 dizima periódica)");
        }
    }

    public static void main(String[] args) throws Exception {
        Equacacao eq = new Equacacao(3, -1, -2);
        double[] resultados = eq.resolverBaskara();
        double primeiroResultado = resultados[0];
        double segundoResultado = resultados[1];
        System.out.println("O x1 é: " + primeiroResultado + " (valor esperado: 1)");
        System.out.println("O x2 é: " + segundoResultado + " (valor esperado -0.6 dizima periódica)");
    }
}