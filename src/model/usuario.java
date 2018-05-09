package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainF;

 public class usuario {
        private int codigo;
        private String email;
        private String senha;
        private String tipo;
        private Boolean inativo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
     
    public usuario(int pCodigo, String pEmail, String pSenha, String pTipo, String pInativo) {
        this.codigo  = pCodigo;
        this.email   = pEmail;
        this.senha   = pSenha;
        this.tipo    = pTipo;
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
        
    }

    public usuario() {
        this.inativo = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
    
    public String SenhaMD5(){
         MessageDigest m = null;
         try {
             m = MessageDigest.getInstance("MD5");
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(MainF.class.getName()).log(Level.SEVERE, null, ex);
         }
         m.update(this.senha.getBytes(), 0, this.senha.length());
         return new BigInteger(1, m.digest()).toString(16);
     }

}
