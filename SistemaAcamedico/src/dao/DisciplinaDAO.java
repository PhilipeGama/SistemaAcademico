/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Curso;
import model.Disciplina;
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
public class DisciplinaDAO {
        private Connection connection;

    public DisciplinaDAO() throws Exception {
        connection = FabricaConexao.getConnection();
    }
    
    public boolean cadastrar(Disciplina disciplina){
        String sql =
                "insert into disciplina values(0,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,disciplina.getSigla());
            ps.setString(2,disciplina.getNome());
            ps.execute();
            connection.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro ao cadastrar disciplina"+e);
            return false;
        }
    
    }
    
      public Vector<Disciplina> consultar(String valorBuscado){
        String sql = "SELECT * FROM disciplina WHERE discnome LIKE ? ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + valorBuscado + '%');
            
            ResultSet rs = ps.executeQuery();
            
            Vector listaDisciplina = new Vector();
            
            while(rs.next()){
                int codigo = rs.getInt("disccodigo"); /** nome do campo no BD **/
                String sigla = rs.getString("discsigla");
                String descricao = rs.getString("discnome");  
                Disciplina disciplina = new Disciplina(codigo, sigla, descricao); 
                listaDisciplina.add(disciplina);
            }
            ps.close();
            connection.close();
            return listaDisciplina;
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public boolean alterar(Disciplina disciplina){
        String sql = "UPDATE disciplina SET discsigla=?, discnome=? WHERE disccodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, disciplina.getSigla());
            ps.setString(2, disciplina.getNome());
            ps.setInt(3, disciplina.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public boolean excluir(int idDisciplina){
        String sql = "DELETE FROM disciplina WHERE disccodigo=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDisciplina);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
       
  
            
    
    
}
