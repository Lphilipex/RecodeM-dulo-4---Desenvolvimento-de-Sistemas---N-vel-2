package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.agencia.conexao.ConexaoMySQL;
import com.agencia.model.Cliente;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO() {
        conexao = ConexaoMySQL.getConnection();
    }

    public void adicionarCliente(Cliente cliente) {
        String query = "INSERT INTO Clientes (Nome, Sobrenome, Email, Telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente obterClientePorID(int ID_Cliente) {
        Cliente cliente = null;
        String query = "SELECT * FROM Clientes WHERE ID_Cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Cliente);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setID_Cliente(resultado.getInt("ID_Cliente"));
                cliente.setNome(resultado.getString("Nome"));
                cliente.setSobrenome(resultado.getString("Sobrenome"));
                cliente.setEmail(resultado.getString("Email"));
                cliente.setTelefone(resultado.getString("Telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void atualizarCliente(Cliente cliente) {
        String query = "UPDATE Clientes SET Nome = ?, Sobrenome = ?, Email = ?, Telefone = ? WHERE ID_Cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, cliente.getID_Cliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int ID_Cliente) {
        String query = "DELETE FROM Clientes WHERE ID_Cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ID_Cliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setID_Cliente(resultado.getInt("ID_Cliente"));
                cliente.setNome(resultado.getString("Nome"));
                cliente.setSobrenome(resultado.getString("Sobrenome"));
                cliente.setEmail(resultado.getString("Email"));
                cliente.setTelefone(resultado.getString("Telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
