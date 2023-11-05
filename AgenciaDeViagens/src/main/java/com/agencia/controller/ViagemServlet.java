package com.agencia.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agencia.model.Viagem;

@SuppressWarnings("serial")
@WebServlet("/viagem")
public class ViagemServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ViagemController viagemController;

    public ViagemServlet() {
        super();
        viagemController = new ViagemController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("adicionar")) {
                String destino = request.getParameter("destino");
                Date dataPartida = Date.valueOf(request.getParameter("dataPartida"));
                Date dataRetorno = Date.valueOf(request.getParameter("dataRetorno"));
                BigDecimal preco = new BigDecimal(request.getParameter("preco"));
                int vagasDisponiveis = Integer.parseInt(request.getParameter("vagasDisponiveis"));
                viagemController.adicionarViagem(destino, dataPartida, dataRetorno, preco, vagasDisponiveis);
                response.sendRedirect("viagens.jsp"); 
            } else if (action.equals("excluir")) {
                int ID_Viagem = Integer.parseInt(request.getParameter("id"));
                viagemController.excluirViagem(ID_Viagem);
                response.sendRedirect("viagens.jsp"); 
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("listar")) {
                List<Viagem> viagens = viagemController.listarViagens();
               
                request.setAttribute("viagens", viagens);
                request.getRequestDispatcher("viagens.jsp").forward(request, response);
            } else if (action.equals("detalhes")) {
                int ID_Viagem = Integer.parseInt(request.getParameter("id"));
                Viagem viagem = viagemController.obterViagemPorID(ID_Viagem);
                request.setAttribute("viagem", viagem);
                request.getRequestDispatcher("detalhes_viagem.jsp").forward(request, response);
            }
        }
    }

	public ViagemController getViagemController() {
		return viagemController;
	}

	public void setViagemController(ViagemController viagemController) {
		this.viagemController = viagemController;
	}
}
