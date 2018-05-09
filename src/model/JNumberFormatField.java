package model;

import java.awt.event.*; 
import java.math.*; 
import java.text.*; 
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
     
public class JNumberFormatField extends JTextField { 
    private static final NumberFormat MONETARY_FORMAT = new DecimalFormat("R$ #,##0.00"); 
    private NumberFormat numberFormat; 
    private int limit = -1; 
     
    public JNumberFormatField(int casasDecimais) { 
        this(new DecimalFormat((casasDecimais == 0 ? "#,##0" : "#,##0.") + makeZeros(casasDecimais))); 
    } 
     
    public JNumberFormatField() { 
        this(MONETARY_FORMAT); 
    } 
     
    public JNumberFormatField(NumberFormat format) { 
        // Define o formato do número         
        numberFormat = format; 
        // Alinhamento horizontal para o texto 
        setHorizontalAlignment(RIGHT); 

        // Documento responsável pela formatação do campo 
        setDocument(new PlainDocument() { 
            @Override 
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException { 
                String text = new StringBuilder(JNumberFormatField.this.getText().replaceAll("[^0-9]", "")).append(str.replaceAll("[^0-9]", "")).toString(); 
                super.remove(0, getLength()); 
                if (text.isEmpty()) { 
                    text = "0"; 
                } else { 
                    text = new BigInteger(text).toString(); 
                } 
                super.insertString(0, numberFormat.format(new BigDecimal(getLimit() > 0 == text.length() > getLimit() ? text.substring(0, getLimit()) : text).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits())))), a); 
            } 

            @Override 
            public void remove(int offs, int len) throws BadLocationException { 
                super.remove(offs, len); 
                if (len != getLength()) { 
                    insertString(0, "", null); 
                } 
            } 
        });

        // Mantém o cursor no final do campo 
        addCaretListener(new CaretListener() { 
            boolean update = false; 

            @Override 
            public void caretUpdate(CaretEvent e) { 
                if (!update) { 
                    update = true; 
                    setCaretPosition(getText().length()); 
                    update = false; 
                } 
            } 
        });

        // Limpa o campo se apertar DELETE 
        addKeyListener(new KeyAdapter() { 
            @Override 
            public void keyPressed(KeyEvent e) { 
                if (e.getKeyCode() == KeyEvent.VK_DELETE) { 
                    setText(""); 
                } 
            } 
        });
        
        // Formato inicial 
        setText("0"); 
        setCaretPosition(getText().length()); 
    } 
     
    public void setValue(BigDecimal value) { 
        super.setText(numberFormat.format(value)); 
    } 

    public final BigDecimal getValue() { 
        return new BigDecimal(getText().replaceAll("[^0-9]", "")).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits()))); 
    } 

    public NumberFormat getNumberFormat() { 
        return numberFormat; 
    } 

    public void setNumberFormat(NumberFormat numberFormat) { 
        this.numberFormat = numberFormat; 
    } 

    private static final String makeZeros(int zeros) { 
        if (zeros >= 0) { 
            StringBuilder builder = new StringBuilder(); 
            for (int i = 0; i < zeros; i++) { 
                builder.append('0'); 
            } 
            return builder.toString(); 
        } else { 
            throw new RuntimeException("Número de casas decimais inválida (" + zeros + ")"); 
        } 
    } 

    public int getLimit() { 
        return limit; 
    } 

    public void setLimit(int limit) { 
        this.limit = limit; 
    } 
}