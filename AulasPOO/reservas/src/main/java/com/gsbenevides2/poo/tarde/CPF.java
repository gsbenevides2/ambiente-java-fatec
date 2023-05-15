package com.gsbenevides2.poo.tarde;

public class CPF {
    private String value;
    public CPF(String value){
        if(value.length() != 12) throw new IllegalArgumentException("O CPF precisa ter 12 dígitos!");
        this.value= value;
    }
    @Override
    public String toString(){
        return value;
    }

}
