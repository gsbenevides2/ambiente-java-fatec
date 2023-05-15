package com.gsbenevides2.Urna;

public class VotoCandidato implements Voto {
    private Candidato candidato;

    public VotoCandidato(Candidato candidato){
        this.candidato = candidato;
    }

    public Candidato getCandidato(){
        return this.candidato;
    }
}
