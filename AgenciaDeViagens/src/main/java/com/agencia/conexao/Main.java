package com.agencia.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        
        Connection conexao = ConexaoMySQL.getConnection();

        if (conexao != null) {
            System.out.println("Conexão com o banco de dados estabelecida.");

            try {
               
                String insertClientesSQL = "INSERT INTO Clientes (Nome, Sobrenome, Email, Telefone) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatementClientes = conexao.prepareStatement(insertClientesSQL);
                preparedStatementClientes.setString(1, "João");
                preparedStatementClientes.setString(2, "Silva");
                preparedStatementClientes.setString(3, "joao@example.com");
                preparedStatementClientes.setString(4, "123-456-7890");

                int linhasAfetadasClientes = preparedStatementClientes.executeUpdate();
                System.out.println("Inseridas " + linhasAfetadasClientes + " linhas na tabela de Clientes.");

               
                String insertViagensSQL = "INSERT INTO Viagens (Destino, DataPartida, DataRetorno, Preco, VagasDisponiveis) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatementViagens = conexao.prepareStatement(insertViagensSQL);
                preparedStatementViagens.setString(1, "Paris");
                preparedStatementViagens.setString(2, "2023-11-15");
                preparedStatementViagens.setString(3, "2023-11-22");
                preparedStatementViagens.setDouble(4, 1500.00);
                preparedStatementViagens.setInt(5, 10);

                int linhasAfetadasViagens = preparedStatementViagens.executeUpdate();
                System.out.println("Inseridas " + linhasAfetadasViagens + " linhas na tabela de Viagens.");

               
                String insertReservasSQL = "INSERT INTO Reservas (ID_Cliente, ID_Viagem, DataReserva) VALUES (?, ?, ?)";
                PreparedStatement preparedStatementReservas = conexao.prepareStatement(insertReservasSQL);
                preparedStatementReservas.setInt(1, 1); 
                preparedStatementReservas.setInt(2, 1); 
                preparedStatementReservas.setString(3, "2023-11-10");

                int linhasAfetadasReservas = preparedStatementReservas.executeUpdate();
                System.out.println("Inseridas " + linhasAfetadasReservas + " linhas na tabela de Reservas.");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados nas tabelas.");
                e.printStackTrace();
            } finally {
                try {
                    conexao.close();
                    System.out.println("Conexão com o banco de dados encerrada.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("Não foi possível estabelecer conexão com o banco de dados.");
        }
    }
}
