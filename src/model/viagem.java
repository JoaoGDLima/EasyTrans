
package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import dao.*;

public class viagem {
    private int codigo;
    private universidade OUniversidade;
    private String diaSemana;
    private String horaSaida;
    private String horaVolta;
    private funcionario OFuncionario;
    private veiculo OVeiculo;
    private Float Valor;
    private String dataIni;
    private String dataFim;
    private ArrayList<cliente> AClientes;
    private boolean inativo;

    public viagem() {
    }

    public viagem(int codigo, int Universidade, Time horaSaida, Time horaVolta, int Funcionario, int Veiculo, Float Valor, Date dataIni, Date dataFim, ArrayList<cliente> AClientes, String inativo) {
        this.codigo = codigo;
        this.OUniversidade = new universidadeDAO().consultarId(Universidade);
        this.horaSaida = horaSaida.toString();
        this.horaVolta = horaVolta.toString();
        this.OFuncionario = new funcionarioDAO().consultarId(Funcionario);
        this.OVeiculo = new veiculoDAO().consultarId(Veiculo);
        this.Valor = Valor;
        this.dataIni = Formatacao.ajustaDataDMA(dataIni.toString());
        this.dataFim = Formatacao.ajustaDataDMA(dataFim.toString());
        this.AClientes = AClientes;
        
        this.inativo = false;
        
        if (inativo.equals("V")) {
            this.inativo = true;
        }
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public universidade getOUniversidade() {
        return OUniversidade;
    }

    public void setOUniversidade(universidade OUniversidade) {
        this.OUniversidade = OUniversidade;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana.toUpperCase().substring(0, 3);
    }

    public funcionario getOFuncionario() {
        return OFuncionario;
    }

    public void setOFuncionario(funcionario OFuncionario) {
        this.OFuncionario = OFuncionario;
    }

    public veiculo getOVeiculo() {
        return OVeiculo;
    }

    public void setOVeiculo(veiculo OVeiculo) {
        this.OVeiculo = OVeiculo;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float Valor) {
        this.Valor = Valor;
    }

    public ArrayList<cliente> getAClientes() {
        return AClientes;
    }

    public void setAClientes(ArrayList<cliente> AClientes) {
        this.AClientes = AClientes;
    }
    
    public void AdicionarCliente(cliente pCliente)
    {
        AClientes.add(pCliente);
    }
    
    public void RemoverCliente(cliente pCliente)
    {
        AClientes.remove(pCliente);
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraVolta() {
        return horaVolta;
    }

    public void setHoraVolta(String horaVolta) {
        this.horaVolta = horaVolta;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
