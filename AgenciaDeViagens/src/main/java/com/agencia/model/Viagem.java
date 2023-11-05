package com.agencia.model;

import java.math.BigDecimal;
import java.util.Date;

public class Viagem {
    private int ID_Viagem;
    private String Destino;
    private Date DataPartida;
    private Date DataRetorno;
    private BigDecimal Preco;
    private int VagasDisponiveis;

    public int getID_Viagem() {
        return ID_Viagem;
    }

    public void setID_Viagem(int ID_Viagem) {
        this.ID_Viagem = ID_Viagem;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Date getDataPartida() {
        return DataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.DataPartida = dataPartida;
    }

    public Date getDataRetorno() {
        return DataRetorno;
    }

    public void setDataRetorno(Date DataRetorno) {
        this.DataRetorno = DataRetorno;
    }

    public BigDecimal Preco() {
        return Preco;
    }

    public void setPreco(BigDecimal Preco) {
        this.Preco = Preco;
    }

    public int getVagasDisponiveis() {
        return VagasDisponiveis;
    }

    public void setVagasDisponiveis(int VagasDisponiveis) {
        this.VagasDisponiveis = VagasDisponiveis;
    }
}
