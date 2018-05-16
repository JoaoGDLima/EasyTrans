
package model;

import dao.usuarioDAO;


public class funcionario {
    private int codigo;
    private String nome;
    private String cpf;
    private String cnh;
    private String rg;
    private String telefone;
    private String celular;
    private usuario usuarioO;
    private String observacao;
    private boolean inativo;

    public funcionario(int codigo, String nome, String cpf, String cnh, String rg, String telefone, String celular, int usuario, String observacao, String inativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
        this.observacao = observacao;
        this.usuarioO = new usuarioDAO().consultarId(usuario);
        
        this.inativo = false;
        
        if (inativo.equals("V")) {
            this.inativo = true;
        }
    }

    public funcionario() {
        this.usuarioO = new usuario();
        this.usuarioO.setCodigo(0);
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

    public String getCpf() {
        return Formatacao.removerFormatacao(cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return Formatacao.removerFormatacao(this.telefone);
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return Formatacao.removerFormatacao(this.celular);
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public usuario getUsuarioO() {
        return usuarioO;
    }

    public void setUsuarioO(usuario usuarioO) {
        this.usuarioO = usuarioO;
    }
    
    
}
