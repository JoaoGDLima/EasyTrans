package easytrans;

import javax.swing.JOptionPane;
import model.ConexaoBD;
import view.LoginF;

public class EasyTrans {

    public static void main(String[] args) {
        if (ConexaoBD.getInstance().getConnection() != null) {
             new LoginF().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao acessar o sistema!");
        }
    }
    
}
