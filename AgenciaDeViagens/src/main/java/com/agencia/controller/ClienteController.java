package com.agencia.controller;

import com.agencia.dao.ClienteDAO;
import com.agencia.model.Cliente;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public void adicionarCliente(String nome, String sobrenome, String email, String telefone) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);

        clienteDAO.adicionarCliente(cliente);
    }

    public Cliente obterClientePorID(int ID_Cliente) {
        return clienteDAO.obterClientePorID(ID_Cliente);
    }

    public void atualizarCliente(int ID_Cliente, String nome, String sobrenome, String email, String telefone) {
        Cliente cliente = new Cliente();
        cliente.setID_Cliente(ID_Cliente);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);

        clienteDAO.atualizarCliente(cliente);
    }

    public void excluirCliente(int ID_Cliente) {
        clienteDAO.excluirCliente(ID_Cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
}
