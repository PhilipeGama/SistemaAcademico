/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Aluno;
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
public class AlunoDAO {
    private Connection connection;
    public AlunoDAO() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(Aluno aluno){
        String sql = 
                "insert into aluno values(0,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1,aluno.getNome());
            ps.setString(2,aluno.getSexo());
            ps.execute();
            ps.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao cadastrar aluno "+e);
            return false;
        }
    }
    
    public Vector<Aluno> consultar(String valorBuscado){
        String sql = "select *from aluno where alunome like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,'%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            Vector listaAlunos = new Vector();
            
            while(rs.next()){
                int codigo  = rs.getInt("alucodigo");
                String nome = rs.getString("alunome");
                String sexo = rs.getString("alusexo");
                Aluno aluno = new Aluno(codigo,nome,sexo);
                listaAlunos.add(aluno);
            }
           ps.close();
           connection.close();
           return listaAlunos;
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
                
    }
    
     public boolean alterar(Aluno aluno){
        String sql = "UPDATE ALUNO SET alunome=?, alusexo=? WHERE alucodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getSexo());
            ps.setInt(3, aluno.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
     
     public boolean excluir(int idAluno){
        String sql = "DELETE FROM CURSO WHERE alucodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  
     
     

}


