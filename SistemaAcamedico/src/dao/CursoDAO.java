/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Curso;
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
public class CursoDAO {
    private Connection connection;

    public CursoDAO() throws Exception {
        connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(Curso curso){
        String sql =
                "insert into curso values(0,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,curso.getSigla());
            ps.setString(2,curso.getDescricao());
            ps.execute();
            connection.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao cadastrar curso"+e);
            return false;
        }
    
    }
            
      
       public Vector<Curso> consultar(String valorBuscado){
        String sql = "SELECT * FROM curso WHERE curdescricao LIKE ? ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + valorBuscado + '%');
            
            ResultSet rs = ps.executeQuery();
            
            Vector listaCursos = new Vector();
            
            while(rs.next()){
                int codigo = rs.getInt("curcodigo"); /** nome do campo no BD **/
                String sigla = rs.getString("cursigla");  
                String descricao = rs.getString("curdescricao");  
                Curso curso = new Curso(codigo, sigla, descricao); 
                listaCursos.add(curso);
            }
            ps.close();
            connection.close();
            return listaCursos;
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public boolean alterar(Curso curso){
        String sql = "UPDATE CURSO SET cursigla=?, curdescricao=? WHERE curcodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getDescricao());
            ps.setInt(3, curso.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public boolean excluir(int idCurso){
        String sql = "DELETE FROM CURSO WHERE curcodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
       

        
        
    }
    
    

