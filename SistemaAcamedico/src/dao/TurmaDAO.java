/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Turma;
import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Philipe
 */
public class TurmaDAO {
     private Connection connection;
    public TurmaDAO() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(Turma turma){
        String sql = 
                "insert into turma values(0,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1,turma.getNome());
           
            ps.execute();
            ps.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao cadastrar turma "+e);
            return false;
        }
    }
    
    public Vector<Turma> consultar(String valorBuscado){
        String sql = "select *from turma where turnome like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector listaTurma = new Vector();
            
            while(rs.next()){
                int codigo  = rs.getInt("turcodigo");
                String nome = rs.getString("turnome");
                
                Turma turma = new Turma(codigo,nome);
                listaTurma.add(turma);
            }
           ps.close();
           connection.close();
           return listaTurma;
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
                
    }
    
     public boolean alterar(Turma turma){
        String sql = "UPDATE turma SET turnome=? WHERE turcodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, turma.getNome());
            
            ps.setInt(2, turma.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
     
     public boolean excluir(int idTurma){
        String sql = "DELETE FROM CURSO WHERE turcodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idTurma);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  
     
}
