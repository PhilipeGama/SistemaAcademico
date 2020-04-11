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
public class Administrador {
    private int codigo;
    private String login;
    private String senha;

    public Administrador() {
     
    }

    public Administrador(int codigo, String login, String senha) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
    }

    public Administrador(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    
    public  boolean logar(){
        if(login.equals("admin") && senha.equals("123"))
            return true;
        else
            return false;                   
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
