package com.agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.conexao.ConexaoMySQL;
import com.agencia.model.Viagem;

public class ViagemDAO {
    private Connection conexao;

    public ViagemDAO() {
        conexao = ConexaoMySQL.getConnection();
    }

    public void adicionarViagem(Viagem viagem) {
        String query = "INSERT INTO Viagens (Destino, DataPartida, DataRetorno, Preco, VagasDisponiveis) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, viagem.getDestino());
            stmt.setDate(2, (Date) viagem.getDataPartida());
            stmt.setDate(3, (Date) viagem.getDataRetorno());
            stmt.setBigDecimal(4, viagem.Preco());
            stmt.setInt(5, viagem.getVagasDisponiveis());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Viagem obterViagemPorID(int ID_Viagem) {
        String query = "SELECT * FROM Viagens WHERE ID_Viagem = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Viagem);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                Viagem viagem = new Viagem();
                viagem.setID_Viagem(resultado.getInt("ID_Viagem"));
                viagem.setDestino(resultado.getString("Destino"));
                viagem.setDataPartida(resultado.getDate("DataPartida"));
                viagem.setDataRetorno(resultado.getDate("DataRetorno"));
                viagem.setPreco(resultado.getBigDecimal("Preco"));
                viagem.setVagasDisponiveis(resultado.getInt("VagasDisponiveis"));
                return viagem;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarViagem(Viagem viagem) {
        String query = "UPDATE Viagens SET Destino = ?, DataPartida = ?, DataRetorno = ?, Preco = ?, VagasDisponiveis = ? WHERE ID_Viagem = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, viagem.getDestino());
            stmt.setDate(2, (Date) viagem.getDataPartida());
            stmt.setDate(3, (Date) viagem.getDataRetorno());
            stmt.setBigDecimal(4, viagem.Preco());
            stmt.setInt(5, viagem.getVagasDisponiveis());
            stmt.setInt(6, viagem.getID_Viagem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirViagem(int ID_Viagem) {
        String query = "DELETE FROM Viagens WHERE ID_Viagem = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Viagem);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Viagem> listarViagens() {
        List<Viagem> viagens = new ArrayList<>();
        String query = "SELECT * FROM Viagens";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Viagem viagem = new Viagem();
                viagem.setID_Viagem(resultado.getInt("ID_Viagem"));
                viagem.setDestino(resultado.getString("Destino"));
                viagem.setDataPartida(resultado.getDate("DataPartida"));
                viagem.setDataRetorno(resultado.getDate("DataRetorno"));
                viagem.setPreco(resultado.getBigDecimal("Preco"));
                viagem.setVagasDisponiveis(resultado.getInt("VagasDisponiveis"));
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viagens;
    }
}
