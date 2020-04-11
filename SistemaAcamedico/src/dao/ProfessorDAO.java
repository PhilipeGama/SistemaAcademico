/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Aluno;
import bean.Professor;
import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Aluno
 */
public class ProfessorDAO {
private Connection connection;

    public ProfessorDAO() throws Exception {
        connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(Professor professor){
        String sql =
                "insert into professor values(0,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
          
            ps.setString(1,professor.getNome());
            ps.setString(2,professor.getFormacao());
            ps.execute();
            connection.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao cadastrar professor"+e);
            return false;
        }
    
    }
    
    public Vector<Professor> consultar(String valorBuscado){
        String sql = "select *from professor where pronome like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector listaProfessor = new Vector();
            
            while(rs.next()){
                int codigo  = rs.getInt("procodigo");
                String nome = rs.getString("pronome");
                String formacao = rs.getString("proformacao");
                Professor professor = new Professor(codigo,nome,formacao);
                listaProfessor.add(professor);
            }
           ps.close();
           connection.close();
           return listaProfessor;
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
                
    }
    
     public boolean alterar(Professor professor){
        String sql = "UPDATE professor SET pronome=?, proformacao=? WHERE procodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getFormacao());
            ps.setInt(3, professor.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
     
     public boolean excluir(int idProfessor){
        String sql = "DELETE FROM professor WHERE procodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  
         
}
