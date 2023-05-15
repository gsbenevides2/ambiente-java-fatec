package com.gsbenevides2.poo.tarde;

public class ServicoHotel extends ServicoDeReserva {
    private int quantidadeDeDiarias;
    private Hotel hotel;

    public ServicoHotel(Hotel hotel, int quantidadeDeDiarias) {
        setQuantidadeDeDiarias(quantidadeDeDiarias);
        setHotel(hotel);
    }

    private void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    private void setQuantidadeDeDiarias(int quantidadeDeDiarias) {
        this.quantidadeDeDiarias = quantidadeDeDiarias;
    }

    @Override
    public double getValor() {
        return quantidadeDeDiarias * this.hotel.getValorDiaria();
    }
}
