package dev.gsbenevides2.Conta;

public class ChavePix {

        private String chave;
        private TipoChavePix tipoChavePix;

        public ChavePix(String chave, TipoChavePix tipoChavePix) {
            this.setChave(chave);
            this.setTipoChavePix(tipoChavePix);
        }

        public String getChave() {
            return chave;
        }
        public TipoChavePix getTipoChavePix() {
            return tipoChavePix;
        }

        private void setChave(String chave) {
            this.chave = chave;
        }
        private void setTipoChavePix(TipoChavePix tipoChavePix) {
            this.tipoChavePix = tipoChavePix;
        }

        public boolean equals(ChavePix chavePix) {
            return this.getChave().equals(chavePix.getChave()) && this.getTipoChavePix().equals(chavePix.getTipoChavePix());
        }
}
