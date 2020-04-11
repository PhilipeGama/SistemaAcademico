/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public class Professor {
    private int codigo;
    private String nome;
    private String formacao;

    public Professor() {
    }

    public Professor(int codigo, String nome, String formacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.formacao = formacao;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
    
    
   
    
    
    
    
}
