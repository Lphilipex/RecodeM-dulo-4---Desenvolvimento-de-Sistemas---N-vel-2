package com.agencia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agencia.model.Reserva;
@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReservaController reservaController;

    public ReservaServlet() {
        super();
        reservaController = new ReservaController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("adicionar")) {
                int ID_Cliente = Integer.parseInt(request.getParameter("cliente_id"));
                int ID_Viagem = Integer.parseInt(request.getParameter("viagem_id"));
                reservaController.adicionarReserva(ID_Cliente, ID_Viagem);
                response.sendRedirect("reservas.jsp"); 
            } else if (action.equals("excluir")) {
                int ID_Reserva = Integer.parseInt(request.getParameter("id"));
                reservaController.excluirReserva(ID_Reserva);
                response.sendRedirect("reservas.jsp"); 
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("listar")) {
                List<Reserva> reservas = reservaController.listarReservas();
                
                request.setAttribute("reservas", reservas);
                request.getRequestDispatcher("reservas.jsp").forward(request, response);
            } else if (action.equals("detalhes")) {
                int ID_Reserva = Integer.parseInt(request.getParameter("id"));
                Reserva reserva = reservaController.obterReservaPorID(ID_Reserva);
                
                request.setAttribute("reserva", reserva);
                request.getRequestDispatcher("detalhes_reserva.jsp").forward(request, response);
            }
        }
    }
}

