/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Aluno
 */
public class Curso {
    private int codigo;
    private String sigla;
    private String descricao;

    public Curso(int codigo,String sigla, String descricao) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.descricao = descricao;
    }
    
    public Curso(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return codigo+sigla+descricao;
    }
     
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    
}
