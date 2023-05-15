public class Equacacao {
        private double coeficiente1;
        private double coeficiente2;
        private double coeficiente3;
        Equacacao(int coef1, int coef2, int coef3){
            this.coeficiente1 = Double.valueOf(coef1);
            this.coeficiente2 = Double.valueOf(coef2);
            this.coeficiente3 = Double.valueOf(coef3);
        }
        double[] resolverBaskara() throws Exception{
            double delta = Math.pow(this.coeficiente2, 2) + (-4 * this.coeficiente1 * this.coeficiente3);
            if(delta < 0) throw new Exception("Não possue raizes reais!");
            double primeiroResultado = ((-1 * this.coeficiente2) + Math.sqrt(delta)) / (2 * this.coeficiente1);
            double segundoResultado =  ((-1 * this.coeficiente2) - Math.sqrt(delta)) / (2 * this.coeficiente1);
            double[] resultados = {primeiroResultado, segundoResultado};
            return resultados;
        }

}
