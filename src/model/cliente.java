
package model;

import dao.cidadeDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class cliente {
    private ResultSet resultadoQ = null;
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private String dataNasc;
    private String telefone;
    private String celular;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private cidade cidadeO;
    private boolean inativo;

    public cliente(int codigo, String nome, String rg, String cpf, Date dataNasc, String telefone, String celular, String logradouro, String numero, String complemento, String bairro, int cidade, String pInativo) throws SQLException {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = Formatacao.ajustaDataDMA(dataNasc.toString());
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidadeO = new cidadeDAO().consultarId(cidade);
        
        this.inativo = false;
        
        if (pInativo.equals("V")) {
            this.inativo = true;
        }
    }
    
    
    
    public cliente() {
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return Formatacao.removerFormatacao(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return Formatacao.removerFormatacao(telefone);
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return Formatacao.removerFormatacao(celular);
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public cidade getCidadeO() {
        return cidadeO;
    }

    public void setCidadeO(cidade cidadeO) {
        this.cidadeO = cidadeO;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
