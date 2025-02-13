package com.Events.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
    
    public Janela(){
		JPanel contentPane = new GradienteBackgroundPainel();
        setContentPane(contentPane);
		setResizable(false);
		setTitle("Cadastro de Eventos");
		setSize(550, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
    }

}
