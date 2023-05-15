package com.gsbenevides2.Urna;

public class VotoNulo implements Voto{
    private Cargo cargo;

    public VotoNulo(Cargo cargo){
        this.cargo = cargo;
    }

    public Cargo getCargo(){
        return this.cargo;
    }
}
