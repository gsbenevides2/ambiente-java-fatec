package com.gsbenevides2.Urna;

import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UrnaEletronicaTest {
    @Test
    public void testeDeCriaçãoDaUrna() {
        UrnaEletronica urna = new UrnaEletronica("233-3");
        String sessao = urna.getSessao();
        Assert.assertEquals(sessao, "233-3");
    }

    @Test
    public void cadastrarCandidato() {
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        urna.cadastrarCandidato(paulinho);
        List<Candidato> candidatosList = urna.getCandidatos();
        Candidato candidato = candidatosList.get(0);

        Assert.assertEquals(candidato.getNome(), "Paulinho do Posto");
        Assert.assertEquals(candidato.getNumero(), "22");
        Assert.assertEquals(candidato.getCargo(), Cargo.PREFEITO);
    }

    @Test
    public void cadastrarEleitor(){
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Eleitor eleitor = new Eleitor("José da Silva", "123456789", "233-3");
        urna.cadastrarEleitor(eleitor);
        Optional<Eleitor> eleitorCadastrado = urna.obterEleitor("123456789");
        Assert.assertTrue(eleitorCadastrado.isPresent());
        Assert.assertEquals(eleitorCadastrado.get().getNome(), "José da Silva");
        Assert.assertEquals(eleitorCadastrado.get().getNumeroDoTitulo(), "123456789");
        Assert.assertEquals(eleitorCadastrado.get().getNumeroDaSessao(), "233-3");
    }

    @Test
    public void cadastrarDoisEleitoresComMesmoNumeroEMesmaSessao(){
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Eleitor eleitor = new Eleitor("José da Silva", "123456789", "233-3");
        urna.cadastrarEleitor(eleitor);
        Eleitor eleitor2 = new Eleitor("José da Silva", "123456789", "233-3");
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> urna.cadastrarEleitor(eleitor2)
        );

        Assert.assertEquals(thrown.getMessage(), "Eleitor já cadastrado");
    }

    @Test
    public void cadastrarDoisCandidatosComMesmoNumeroEMesmoCargo() {
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Candidato maria = new Candidato(Cargo.PREFEITO, "Maria do Posto", "22", partido);
        urna.cadastrarCandidato(paulinho);

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> urna.cadastrarCandidato(maria)
        );

        Assert.assertEquals(thrown.getMessage(), "Candidato com esse número já cadastrado");

    }

    @Test
    public void cadastrarDoisCandidatosComMesmoNumeroMasCargosDiferentes() {
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Candidato maria = new Candidato(Cargo.VEREADOR, "Maria do Posto", "22", partido);
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarCandidato(maria);
        List<Candidato> candidatosList = urna.getCandidatos();
        Assert.assertEquals(candidatosList.size(), 2);
    }

    @Test
    public void obterCandidatosPorCargo() {
        UrnaEletronica urna = new UrnaEletronica("233-3");
        Partido partidoDoPosto = new Partido("Partido do Posto", "22");
        Partido partidoDaEsquina = new Partido("Partido da Esquina", "33");
        Partido partidoDoBairro = new Partido("Partido do Bairro", "44");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partidoDoPosto);
        Candidato maria = new Candidato(Cargo.PREFEITO, "Maria do Posto", "33", partidoDaEsquina);
        Candidato joao = new Candidato(Cargo.VEREADOR, "João da Silva", "44", partidoDoBairro);
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarCandidato(maria);
        urna.cadastrarCandidato(joao);

        List<Candidato> candidatosPrefeito = urna.getCandidatosPorCargo(Cargo.PREFEITO);
        List<Candidato> candidatosVereador = urna.getCandidatosPorCargo(Cargo.VEREADOR);

        Assert.assertEquals(candidatosPrefeito.size(), 2);
        Assert.assertEquals(candidatosVereador.size(), 1);

    }

    @Test
    public void votarEmUmCandidato() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarEleitor(eleitor);
        urna.votar("123.456.789-00", "22", Cargo.PREFEITO);
        Assert.assertEquals(urna.getVotos().size(), 1);
    }

    @Test
    public void anularVoto() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarEleitor(eleitor);

        urna.votar("123.456.789-00", "33", Cargo.PREFEITO);

        HashMap<Candidato, Integer> resultado = urna.obterResultado(Cargo.PREFEITO);
        Assert.assertEquals(resultado.get(paulinho), Integer.valueOf(0));
        Assert.assertEquals(urna.contarVotosBrancos(Cargo.PREFEITO), 0);
        Assert.assertEquals(urna.contarVotosNulos(Cargo.PREFEITO), 1);
    }

    @Test
    public void votarEmBranco() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarEleitor(eleitor);

        urna.votar("123.456.789-00", "", Cargo.PREFEITO);

        HashMap<Candidato, Integer> resultado = urna.obterResultado(Cargo.PREFEITO);
        Assert.assertEquals(resultado.get(paulinho), Integer.valueOf(0));
        Assert.assertEquals(urna.contarVotosBrancos(Cargo.PREFEITO), 1);
        Assert.assertEquals(urna.contarVotosNulos(Cargo.PREFEITO), 0);
    }

@Test
public void obterInformacoesDeEleitoresNaoCadastrados() {
        UrnaEletronica urna = new UrnaEletronica("123");

        Assert.assertTrue(
                urna.obterEleitor("123.456.789-00").isEmpty()
        );
        Assert.assertTrue(
                urna.obterEleitor("123.456.789-01").isEmpty()
        );
        Assert.assertFalse(
                urna.obterEleitor("123.456.789-02").isPresent()
        );
        Assert.assertFalse(
                urna.eleitorJaVotouParaCargo("123.456.789-00", Cargo.PREFEITO)
        );

}


    @Test
    public void cadastraEleitorEmUrnaDaSessaoErrada() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "333");
        urna.cadastrarCandidato(paulinho);

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> urna.cadastrarEleitor(eleitor)
        );

        Assert.assertEquals(thrown.getMessage(), "Eleitor não pode votar nessa sessão favor verificar o número da sessão");
    }

    @Test
    public void eleitorNaoCadastradoTentaVotar(){
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> urna.votar("123.456.789-00", "22", Cargo.PREFEITO)
        );

        Assert.assertEquals(thrown.getMessage(), "Eleitor não cadastrado");
    }

    @Test
    public void votarEmMultiplosCargos(){
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Candidato vereador = new Candidato(Cargo.VEREADOR, "Vereador do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarCandidato(vereador);
        urna.cadastrarEleitor(eleitor);
        urna.votar("123.456.789-00", "22", Cargo.PREFEITO);
        urna.votar("123.456.789-00", "22", Cargo.VEREADOR);
        HashMap<Candidato, Integer> votosParaPrefeito = urna.obterResultado(Cargo.PREFEITO);
        HashMap<Candidato, Integer> votosParaVereador = urna.obterResultado(Cargo.VEREADOR);

        Assert.assertEquals(votosParaPrefeito.get(paulinho), Integer.valueOf(1));
        Assert.assertEquals(votosParaVereador.get(vereador), Integer.valueOf(1));
    }

    @Test
    public void eleitorVotarNovamente() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido = new Partido("Partido do Posto", "22");
        Candidato paulinho = new Candidato(Cargo.PREFEITO, "Paulinho do Posto", "22", partido);
        Eleitor eleitor = new Eleitor("João da Silva", "123.456.789-00", "123");
        urna.cadastrarCandidato(paulinho);
        urna.cadastrarEleitor(eleitor);
        urna.votar("123.456.789-00", "22", Cargo.PREFEITO);

        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> urna.votar("123.456.789-00", "22", Cargo.PREFEITO)
        );

        Assert.assertEquals(thrown.getMessage(), "Eleitor já votou para esse cargo");
    }

    @Test
    public void testarEleicao() {
        UrnaEletronica urna = new UrnaEletronica("123");
        Partido partido1 = new Partido("Partido dos Vencedores", "22");
        Partido partido2 = new Partido("Partido dos Perdedores", "23");
        Candidato candidato1 = new Candidato(Cargo.PREFEITO, "Paulo da Silva", "22", partido1);
        Candidato candidato2 = new Candidato(Cargo.PREFEITO, "Armando da Costa", "23", partido2);
        Eleitor eleitor1 = new Eleitor("Paulinho", "1234", "123");
        Eleitor eleitor2 = new Eleitor("Zezinho", "1235", "123");
        Eleitor eleitor3 = new Eleitor("Alerrandro", "1236", "123");
        Eleitor eleitor4 = new Eleitor("Maria", "1233", "123");

        urna.cadastrarCandidato(candidato1);
        urna.cadastrarCandidato(candidato2);

        urna.cadastrarEleitor(eleitor1);
        urna.cadastrarEleitor(eleitor2);
        urna.cadastrarEleitor(eleitor3);
        urna.cadastrarEleitor(eleitor4);

        urna.votar("1234", "22", Cargo.PREFEITO);
        urna.votar("1235", "22", Cargo.PREFEITO);
        urna.votar("1236", "22", Cargo.PREFEITO);
        urna.votar("1233", "23", Cargo.PREFEITO);

        HashMap<Candidato, Integer> apuracao = urna.obterResultado(Cargo.PREFEITO);
        Integer re1 = apuracao.get(candidato1);
        Integer re2 = apuracao.get(candidato2);
        Assert.assertEquals(re1, Integer.valueOf(3));
        Assert.assertEquals(re2, Integer.valueOf(1));
    }
}
