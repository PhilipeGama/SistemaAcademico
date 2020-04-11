/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Philipe
 */
public class Turma {
    private int codigo;
    private String nome;

    public Turma(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Turma(String nome) {
        this.nome = nome;
    }

    public Turma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
