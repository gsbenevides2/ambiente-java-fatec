package com.gsbenevides2.Urna;

import java.util.*;

public class UrnaEletronica {
    private String sessao;
    private List<Candidato> candidatos = new ArrayList<>();
    private List<Voto> votos = new ArrayList<>();
    private List<Eleitor> eleitoresAptos = new ArrayList<>();
    private HashMap<Cargo, List<Eleitor>> eleitoresQueVotaram= new HashMap<>();
    public UrnaEletronica(String sessao){
        this.sessao = sessao;
    }
    public void cadastrarCandidato(Candidato candidato){
        candidatos.stream()
                .filter(cand -> cand.getNumero().equals(candidato.getNumero()) && cand.getCargo().equals(candidato.getCargo()))
                .findFirst()
                .ifPresentOrElse(
                        cand -> {throw new IllegalArgumentException("Candidato com esse número já cadastrado");},
                        () -> candidatos.add(candidato)
                );

    }
    public List<Candidato> getCandidatos(){
        return this.candidatos;
    }
    public List<Candidato> getCandidatosPorCargo(Cargo cargo){
        List<Candidato> candidatosPorCargo = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if(candidato.getCargo().equals(cargo)){
                candidatosPorCargo.add(candidato);
            }
        }
        return candidatosPorCargo;
    }
    public void cadastrarEleitor(Eleitor eleitor){
        if(eleitoresAptos.contains(eleitor)){
            throw new IllegalArgumentException("Eleitor já cadastrado");
        }
        if(eleitor.getNumeroDaSessao().equals(this.getSessao()) == false) {
            throw new IllegalArgumentException("Eleitor não pode votar nessa sessão favor verificar o número da sessão");
        }
        eleitoresAptos.add(eleitor);
    }
    public Optional<Eleitor> obterEleitor(String numeroDoTitulo){
        return eleitoresAptos.stream()
                .filter(eleitor -> eleitor.getNumeroDoTitulo().equals(numeroDoTitulo))
                .findFirst()
                .or(() -> Optional.empty());
    }
    public void votar(String numeroDoTitulo, String numeroDoCandidato, Cargo cargo){
        Optional<Eleitor> eleitor = obterEleitor(numeroDoTitulo);

        if(eleitor.isEmpty()){
            throw new IllegalArgumentException("Eleitor não cadastrado");
        }

        Eleitor eleitor1 = eleitor.get();

        if(eleitorJaVotouParaCargo(eleitor1.getNumeroDoTitulo(), cargo)){
            throw new IllegalArgumentException("Eleitor já votou para esse cargo");
        }

        if(numeroDoCandidato.isEmpty()){
            this.votos.add(new VotoBranco(cargo));
        }else {
            Optional<Candidato> candidato = getCandidatoPorNumero(numeroDoCandidato, cargo);
            if (candidato.isEmpty()) {
                this.votos.add(new VotoNulo(cargo));
            } else {
                votos.add(new VotoCandidato(candidato.get()));
            }
        }
        eleitoresQueVotaram.get(cargo).add(eleitor1);
    }
    public Optional<Candidato> getCandidatoPorNumero(String numeroDoCandidato, Cargo cargo){
        return candidatos.stream()
                .filter(cand -> cand.getNumero().equals(numeroDoCandidato) && cand.getCargo().equals(cargo))
                .findFirst();
    }
    public HashMap<Candidato,Integer> obterResultado(Cargo cargo){
        HashMap<Candidato, Integer> votosContabilizados = new HashMap<>();

        this.candidatos.stream().forEach(candidato -> {
            if(candidato.getCargo().equals(cargo)){
                votosContabilizados.put(candidato, 0);
            }
        });

        this.votos.stream()
                .filter(vot->{
                  if(vot instanceof VotoCandidato){
                      VotoCandidato votoCandidato = (VotoCandidato) vot;
                      return votoCandidato.getCandidato().getCargo().equals(cargo);
                  } else return false;
                })
                .forEach(voto ->{
                    VotoCandidato votoCandidato = (VotoCandidato) voto;
                    Candidato cand = votoCandidato.getCandidato();
                    votosContabilizados.put(cand, votosContabilizados.get(cand) + 1);
                });

        return votosContabilizados;
    }
    public long contarVotosNulos(Cargo cargo){
        return this.votos.stream()
                .filter(vot-> vot instanceof VotoNulo)
                .filter(vot-> ((VotoNulo) vot).getCargo().equals(cargo))
                .count();
    }
    public long contarVotosBrancos(Cargo cargo){
        return this.votos.stream()
                .filter(vot-> vot instanceof VotoBranco)
                .filter(vot-> ((VotoBranco) vot).getCargo().equals(cargo))
                .count();
    }
    public String getSessao(){
        return this.sessao;
    }
    public List<Voto> getVotos(){
        return this.votos;
    }

    public boolean eleitorJaVotouParaCargo(String numeroDoTitulo, Cargo cargo) {
        if(eleitoresQueVotaram.containsKey(cargo) == false){
            eleitoresQueVotaram.put(cargo, new ArrayList<>());
        }
        Optional<Eleitor> eleitor = obterEleitor(numeroDoTitulo);
        if(eleitor.isEmpty()){
            return false;
        }
        return eleitoresQueVotaram.get(cargo).contains(eleitor.get());
    }
}
