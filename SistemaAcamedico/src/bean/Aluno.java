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
public class Aluno {
    private int codigo;    
    private String nome;
    private String sexo;

    public Aluno() {
    }

    public Aluno(int codigo, String nome, String sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
    }

    public Aluno(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    
    
    
    

   
}
