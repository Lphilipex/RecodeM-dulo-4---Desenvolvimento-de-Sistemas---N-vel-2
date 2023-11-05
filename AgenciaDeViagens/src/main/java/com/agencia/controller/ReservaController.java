package com.agencia.controller;

import com.agencia.dao.ReservaDAO;
import com.agencia.model.Reserva;
import java.util.List;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController() {
        reservaDAO = new ReservaDAO();
    }

    public void adicionarReserva(int ID_Cliente, int ID_Viagem) {
        Reserva reserva = new Reserva();
        reserva.setID_Cliente(ID_Cliente);
        reserva.setID_Viagem(ID_Viagem);
        reservaDAO.adicionarReserva(reserva);
    }

    public Reserva obterReservaPorID(int ID_Reserva) {
        return reservaDAO.obterReservaPorID(ID_Reserva);
    }

    public void atualizarReserva(int ID_Reserva, int ID_Cliente, int ID_Viagem) {
        Reserva reserva = new Reserva();
        reserva.setID_Reserva(ID_Reserva);
        reserva.setID_Cliente(ID_Cliente);
        reserva.setID_Viagem(ID_Viagem);
        reservaDAO.atualizarReserva(reserva);
    }

    public void excluirReserva(int ID_Reserva) {
        reservaDAO.excluirReserva(ID_Reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaDAO.listarReservas();
    }
}
