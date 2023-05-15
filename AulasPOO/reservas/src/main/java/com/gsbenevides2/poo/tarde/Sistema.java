package com.gsbenevides2.poo.tarde;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Reserva> reservas = new ArrayList<>();
    /*
    private List<Voo> voos = new ArrayList<>();
    private List<Hotel> hoteis = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
*/
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    /*
    public void addEvento(Evento evento){
        eventos.add(evento);
    }
    public void addVoo(Voo voo){
        voos.add(voo);
    }
    public void addHotels(Hotel hotel){
        hoteis.add(hotel);
    }
    public void addVeiculos(Veiculo veiculo){
        veiculos.add(veiculo);
    }
*/
    public List<Reserva> getReservas() {
        return reservas;
    }
    /*
    public List<Voo> getVoos() {
        return voos;
    }
    public List<Hotel> getHoteis() {
        return hoteis;
    }
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    public List<Evento> getEventos() {
        return eventos;
    }
     */
}
