import com.gsbenevides2.Abc.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        GerenciadorDePesquisas gerenciadorDePesquisas = GerenciadorDePesquisas.getInstance();

        gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Oliveiras",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514129",
                1200
        );
        gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Palmeiras",
                new Endereco(
                        "Rua B",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514128",
                4000
        );
        gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Flores",
                new Endereco(
                        "Rua C",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514127",
                2000
        );
        gerenciadorDePesquisas.cadastrarResidencial(
                "Vila das Oliveiras",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Velha",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_NORTE
                ),
                4,
                "1147514126",
                1000
        );
        gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Vilas",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514125",
                1100
        );
        gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Casas",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                3,
                "1147514124",
                1400
        ); gerenciadorDePesquisas.cadastrarResidencial(
                "Monte das Arvores",
                new Endereco(
                        "Rua A",
                        15,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147517129",
                1200
        ); gerenciadorDePesquisas.cadastrarResidencial(
                "Casa das Oliveiras",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                2,
                "1147514123",
                1300
        ); gerenciadorDePesquisas.cadastrarResidencial(
                "Casa das Rosas",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514122",
                1400
        ); gerenciadorDePesquisas.cadastrarResidencial(
                "Casinha das Oliveiras",
                new Endereco(
                        "Rua A",
                        12,
                        "Casa Verde",
                        "Suzano",
                        "SP",
                        Regiao.ZONA_SUL
                ),
                5,
                "1147514121",
                4400
        );


        Pesquisa pesquisa = gerenciadorDePesquisas.fazerPesquisa(
                1000,
                5000,
                "SP",
                "Suzano",
                Regiao.ZONA_SUL,
                "Guilherme da Silva Benevides",
                "1147514129",
                "Gertrudes",
                "gsbenevides2@gmail.com"
        );
        System.out.println("Resultados da busca de residenciais entre 1000 e 5000 reais em Suzano/SP na ZONA_SUL: ");
        pesquisa.getResidenciaisEncontrados().forEach(residencial -> {
            System.out.println("Nome do Residencial: " +residencial.getNome());
            System.out.println("Valor do Residencial: " + residencial.getPreco());
            System.out.println("Endereco do Residencial: " + residencial.getEndereco().toString());
            System.out.println("Avaliação do Residencial: " + residencial.getAvaliacao());
            System.out.println("Telefone do Residencial: "+ residencial.getTelefone());
            System.out.println("----------------------------------------");
        });

        System.out.println("Pesquisando Novamente");

        gerenciadorDePesquisas.fazerPesquisa(
                1000,
                5000,
                "SP",
                "Suzano",
                Regiao.ZONA_SUL,
                "Guilherme da Silva Benevides",
                "1147514129",
                "Gertrudes",
                "gsbenevides2@gmail.com"
        );
        pesquisa.getResidenciaisEncontrados().subList(3,6).forEach(residencial -> {
            System.out.println("Nome do Residencial: " +residencial.getNome());
            System.out.println("Valor do Residencial: " + residencial.getPreco());
            System.out.println("Endereco do Residencial: " + residencial.getEndereco().toString());
            System.out.println("Avaliação do Residencial: " + residencial.getAvaliacao());
            System.out.println("Telefone do Residencial: "+ residencial.getTelefone());
            System.out.println("----------------------------------------");
        });


        System.out.println("Vamos ver as pesquisas realizadas...");

        List<Pesquisa> pesquisas = gerenciadorDePesquisas.obterPesquisarRealizadas();
        pesquisas.forEach(pesquisaRealizada -> {
            System.out.println("Nome do Interessado: "+ pesquisaRealizada.getInteressado().getNome());
            System.out.println("Telefone do Interessado: " +pesquisaRealizada.getInteressado().getTelefone());
            System.out.println("Data da Pesquisa: "+ pesquisaRealizada.getDataDaPesquisa().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Qtd de Tentativas de Pesquisa: " + pesquisaRealizada.getQtdDeTentativas());
            System.out.println("Qtd de Resultados: " + pesquisaRealizada.getResidenciaisEncontrados().size());
        });




    }
}