package com.agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.conexao.ConexaoMySQL;
import com.agencia.model.Reserva;

public class ReservaDAO {
    private Connection conexao;

    public ReservaDAO() {
        conexao = ConexaoMySQL.getConnection();
    }

    public void adicionarReserva(Reserva reserva) {
        String query = "INSERT INTO Reservas (ID_Cliente, ID_Viagem, DataReserva) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, reserva.getID_Cliente());
            stmt.setInt(2, reserva.getID_Viagem());
            stmt.setDate(3, (Date) reserva.getDataReserva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserva obterReservaPorID(int ID_Reserva) {
        String query = "SELECT * FROM Reservas WHERE ID_Reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Reserva);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setID_Reserva(resultado.getInt("ID_Reserva"));
                reserva.setID_Cliente(resultado.getInt("ID_Cliente"));
                reserva.setID_Viagem(resultado.getInt("ID_Viagem"));
                reserva.setDataReserva(resultado.getDate("DataReserva"));
                return reserva;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarReserva(Reserva reserva) {
        String query = "UPDATE Reservas SET ID_Cliente = ?, ID_Viagem = ?, DataReserva = ? WHERE ID_Reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, reserva.getID_Cliente());
            stmt.setInt(2, reserva.getID_Viagem());
            stmt.setDate(3, (Date) reserva.getDataReserva());
            stmt.setInt(4, reserva.getID_Reserva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirReserva(int ID_Reserva) {
        String query = "DELETE FROM Reservas WHERE ID_Reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Reserva);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String query = "SELECT * FROM Reservas";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setID_Reserva(resultado.getInt("ID_Reserva"));
                reserva.setID_Cliente(resultado.getInt("ID_Cliente"));
                reserva.setID_Viagem(resultado.getInt("ID_Viagem"));
                reserva.setDataReserva(resultado.getDate("DataReserva"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
