package com.agencia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agencia.model.Cliente;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController;

    public ClienteServlet() {
        super();
        clienteController = new ClienteController();
        System.out.println("Objeto clienteController foi inicializado com sucesso.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("adicionar")) {
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                clienteController.adicionarCliente(nome, sobrenome, email, telefone);
                response.sendRedirect("Cliente.jsp"); 
            } else if (action.equals("atualizar")) {
                int ID_Cliente = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");
                clienteController.atualizarCliente(ID_Cliente, nome, sobrenome, email, telefone);
                response.sendRedirect("Cliente.jsp"); 
            } else if (action.equals("excluir")) {
                int ID_Cliente = Integer.parseInt(request.getParameter("id"));
                clienteController.excluirCliente(ID_Cliente);
                response.sendRedirect("Cliente.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            try {
                if (action.equals("listar")) {
                    List<Cliente> clientes = clienteController.listarClientes();
                    request.setAttribute("Cliente", clientes);
                    request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                } else if (action.equals("detalhes")) {
                    int ID_Cliente = Integer.parseInt(request.getParameter("id"));
                    Cliente cliente = clienteController.obterClientePorID(ID_Cliente);
                    request.setAttribute("cliente", cliente);
                    request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }
    }

}
