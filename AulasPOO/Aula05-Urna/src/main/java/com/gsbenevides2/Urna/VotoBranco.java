package com.gsbenevides2.Urna;

public class VotoBranco implements Voto{
    private Cargo cargo;

    public VotoBranco(Cargo cargo){
        this.cargo = cargo;
    }

    public Cargo getCargo(){
        return this.cargo;
    }
}
