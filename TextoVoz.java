package voz;

import java.io.*;
import com.sun.speech.freetts.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextoVoz extends JPanel {
	private JButton btnFalar;
    private JLabel lbTitulo;
    private JTextArea txtArea;

    public TextoVoz() {
		inicializarComponentes(); 
		definirEventos();
	}
    
	private void inicializarComponentes() {
        //construir componentes
		btnFalar = new JButton ("Falar");
		btnFalar.setFont(new Font("Serif", Font.BOLD, 20));
        lbTitulo = new JLabel ("Texto-para-voz");
        lbTitulo.setFont(new Font("Serif", Font.BOLD, 30));
        txtArea = new JTextArea (5, 5);
        txtArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        //adjustar tamanho e definir layout
        setPreferredSize (new Dimension (441, 361));
        setLayout (null);

        //adicionar componentes
        add (btnFalar);
        add (lbTitulo);
        add (txtArea);

        //delimitar os componentes
        btnFalar.setBounds (160, 255, 120, 45);
        lbTitulo.setBounds (125, 20, 190, 55);
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setVerticalAlignment(JLabel.CENTER);
        txtArea.setBounds (125, 75, 190, 140);
        }
	
	private void definirEventos() {
		final String nomevoz="kevin16"; //kevin, kevin16, mbrola_us1, mbrola_us2, mbrola_us3
		
		btnFalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voice voz;
				VoiceManager vm = VoiceManager.getInstance();
				voz = vm.getVoice(nomevoz);
				
				voz.allocate();
				try {
					voz.speak(txtArea.getText());
				} catch (Exception e1) {
					
				}
			}
		});
		
	}
    

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Texto-para-voz");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TextoVoz());
        frame.pack();
        frame.setVisible (true);
    }
}
