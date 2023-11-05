package com.agencia.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/AgenciaDeViagens";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
