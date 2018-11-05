
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.ComboItens;
import model.ConexaoBD;

public class CombosDAO {

    ResultSet resultado = null;

    public void popularCombo(String tabela, String campos, String where, String order, JComboBox combo) {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            if (where!="") {
                where = " and " + where;
            }
            
            resultado = new ConexaoBD().getConnection().createStatement().executeQuery(
                    "select " + campos + 
                    " from " + tabela + 
                    " where inativo = 'F' " + where +
                    " order by " + order);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItens();
                    item.setCodigo(resultado.getInt(1));
                    item.setDescricao(resultado.getString(2));

                    combo.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
    
    public void popularComboSemanas(JComboBox combo) {

        ArrayList<ComboItens> AItens = new ArrayList();
        AItens.add(new ComboItens(0, "Selecionar"));
        AItens.add(new ComboItens(1, "Segunda"));
        AItens.add(new ComboItens(2, "Terça"));
        AItens.add(new ComboItens(3, "Quarta"));
        AItens.add(new ComboItens(4, "Quinta"));
        AItens.add(new ComboItens(5, "Sexta"));
        
        for (int i = 0; i < AItens.size(); i++) {
            combo.addItem(AItens.get(i));
        }
    }
    
    
    public void definirItemCombo (JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if ( ((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo() ) ) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    public void popularComboSituacao(JComboBox combo) {
        ArrayList<ComboItens> AItens = new ArrayList();
        AItens.add(new ComboItens(0, "Todos"));
        AItens.add(new ComboItens(1, "Ativo"));
        AItens.add(new ComboItens(2, "Inativo"));
        
        for (int i = 0; i < AItens.size(); i++) 
        {
            combo.addItem(AItens.get(i));
        }
    }
    
    public void popularComboSituacaoParc(JComboBox combo) {
        ArrayList<ComboItens> AItens = new ArrayList();
        AItens.add(new ComboItens(0, "Todos"));
        AItens.add(new ComboItens(1, "Abertas"));
        AItens.add(new ComboItens(2, "Pagas"));
        
        for (int i = 0; i < AItens.size(); i++) 
        {
            combo.addItem(AItens.get(i));
        }
    }
    
    public void AddComboItem(JComboBox combo, int codigo, String descricao) {
        combo.addItem(new ComboItens(codigo, descricao));
    }
}
