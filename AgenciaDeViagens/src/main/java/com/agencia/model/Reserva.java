package com.agencia.model;

public class Reserva {
    private int ID_Reserva;
    private int ID_Cliente;
    private int ID_Viagem;
    private java.sql.Date DataReserva;

    public int getID_Reserva() {
        return ID_Reserva;
    }

    public void setID_Reserva(int ID_Reserva) {
        this.ID_Reserva = ID_Reserva;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Viagem() {
        return ID_Viagem;
    }

    public void setID_Viagem(int ID_Viagem) {
        this.ID_Viagem = ID_Viagem;
    }

    public java.sql.Date getDataReserva() {
        return DataReserva;
    }

    public void setDataReserva(java.sql.Date DataReserva) {
        this.DataReserva = DataReserva;
    }
}
