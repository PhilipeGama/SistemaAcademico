/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno
 */
public class FabricaConexao {
     public static Connection getConnection()throws Exception{
        try {
           String host = "jdbc:mysql://localhost/sistemaacademico";
           String user = "root";
           String password = "";
           Connection connection = 
                   DriverManager.getConnection(host, user, password);
           return connection;
        } catch (Exception e) {
            throw new Exception("Erro ao conecta com o banco de dado"+e.getMessage());
        }
    }
}
