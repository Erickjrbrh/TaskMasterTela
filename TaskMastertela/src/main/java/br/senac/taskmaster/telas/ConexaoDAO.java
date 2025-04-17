package br.senac.taskmaster.telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/TaskMaster?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root"; // ou "usuario_comum"
    private static final String SENHA = "33984357Dede!"; // ou "senha123"

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver do MySQL
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado.");
            throw new SQLException(e);
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
