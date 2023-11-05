package com.agencia.controller;

import com.agencia.dao.ViagemDAO;
import com.agencia.model.Viagem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ViagemController {
    private ViagemDAO viagemDAO;

    public ViagemController() {
        viagemDAO = new ViagemDAO();
    }

    public void adicionarViagem(String destino, Date dataPartida, Date dataRetorno, BigDecimal preco, int vagasDisponiveis) {
        Viagem viagem = new Viagem();
        viagem.setDestino(destino);
        viagem.setDataPartida(dataPartida);
        viagem.setDataRetorno(dataRetorno);
        viagem.setPreco(preco);
        viagem.setVagasDisponiveis(vagasDisponiveis);
        viagemDAO.adicionarViagem(viagem);
    }

    public Viagem obterViagemPorID(int ID_Viagem) {
        return viagemDAO.obterViagemPorID(ID_Viagem);
    }

    public void atualizarViagem(int ID_Viagem, String destino, Date dataPartida, Date dataRetorno, BigDecimal preco, int vagasDisponiveis) {
        Viagem viagem = new Viagem();
        viagem.setID_Viagem(ID_Viagem);
        viagem.setDestino(destino);
        viagem.setDataPartida(dataPartida);
        viagem.setDataRetorno(dataRetorno);
        viagem.setPreco(preco);
        viagem.setVagasDisponiveis(vagasDisponiveis);
        viagemDAO.atualizarViagem(viagem);
    }

    public void excluirViagem(int ID_Viagem) {
        viagemDAO.excluirViagem(ID_Viagem);
    }

    public List<Viagem> listarViagens() {
        return viagemDAO.listarViagens();
    }
}
