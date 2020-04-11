/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Administrador;
import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Philipe
 */
public class AdministradorDAO {
    private Connection connection;
    public AdministradorDAO() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public Vector<Administrador> consultar(String valorBuscado){
        String sql = "select *from administrador where admlogin like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector listaAdmins = new Vector();
            
            while(rs.next()){
                int codigo  = rs.getInt("admcodigo");
                String login = rs.getString("admlogin");
                String senha = rs.getString("admsenha");
                Administrador admin = new Administrador(codigo,login,senha);
                listaAdmins.add(admin);
            }
           ps.close();
           connection.close();
           return listaAdmins;
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
                
    }  
}
