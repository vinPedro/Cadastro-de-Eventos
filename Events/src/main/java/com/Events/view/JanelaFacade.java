package com.Events.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;


public abstract class JanelaFacade {
	
	/**
	 * Cria um panel
	 */
	public static JPanel criarPanel(Janela janela, int x, int y, int largura, int altura, Color cor) {
		JPanel panel = new JPanel();
		panel.setBounds(x, y, largura, altura);
		panel.setBackground(cor);
		janela.add(panel);
		return panel;
	}
	
	/**
	 * Cria um texto
	 */
	public static void criarTexto(Janela janela, int x, int y, int largura, int altura, String texto, Font fonte, int alinhamento, Color cor){
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, largura, altura);
		label.setFont(fonte);
		label.setHorizontalAlignment(alinhamento);
		label.setForeground(cor);
		janela.add(label);
	}
	
	/**
	 * Cria um campo de texto com quebra de linha
	 */
	public static void criarTextoComQuebra(Janela janela, int x, int y, int largura, int altura, String texto, Font fonte, int alinhamento, Color cor) {
		final JTextArea label = new JTextArea(texto); 
		label.setEditable(false); 
		label.setLineWrap(true);
		label.setBounds(x, y, largura, altura);
		label.setForeground(cor);
		label.setOpaque(false);
		label.setFont(fonte);
		janela.add(label);
	}
	
	/**
	 * Cria um campo de texto mascarado
	 */
	public static JTextField criarCampoTextoMascarado(Janela janela, int x, int y, int largura, int altura,LineBorder borda, String formato) {
		try {
			MaskFormatter formatador = new MaskFormatter(formato);
			JTextField campoDeTexto = new JFormattedTextField(formatador);
			campoDeTexto.setFont(new Font("TimesRoman", Font.PLAIN, 17));
			campoDeTexto.setBorder(borda);
			campoDeTexto.setBounds(x, y, largura, altura);
			janela.add(campoDeTexto);
			return campoDeTexto;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Cria um campo de texto comum
	 */
	public static JTextField criarCampoTextoComum(Janela janela, int x, int y, int largura, int altura,LineBorder borda) {
		JTextField campoDeTexto = new JTextField();
		campoDeTexto.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		campoDeTexto.setBorder(borda);
		campoDeTexto.setBounds(x, y, largura, altura);
		janela.add(campoDeTexto);
		return campoDeTexto;
	}
	
	/**
	 * Cria um botão com imagem ou texto
	 */
	public static JButton criarBotao(Janela janela, ActionListener ouvinte, String titulo, Font fonte, Color corFonte, int x, int y, int largura, int altura, Color cor, LineBorder borda, String nomeImagem, int larguraImagem, int alturaImagem) {
		JButton botao = new JButton();
		
		botao.setBounds(x, y, largura, altura);
		botao.setBorder(borda);
		
		if(nomeImagem == null) {
			botao.setText(titulo);
			botao.setBackground(cor);
			botao.setFont(fonte);
			botao.setForeground(corFonte);
		}
		else {
			ImageIcon icon = new ImageIcon(janela.getClass().getResource("../../../resources/imagens/" + nomeImagem));
	        Image image = icon.getImage();
	        Image novaImagem = image.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
	        ImageIcon novoIcone = new ImageIcon(novaImagem);
	        botao.setIcon(novoIcone);
	        botao.setContentAreaFilled(false);
			
		}
		
		
		botao.addActionListener(ouvinte);
		janela.add(botao);
		return null;
	}

	/**
	 * Cria uma tabela com os dados passados
	 * Configurando para que não seja possível editar os dados
	 * @param dado
	 * @param colunas
	 * @return JTable
	 */
	public static JTable criarTabela(Object[][] dado, String [] colunas) {
		JTable tabela = new JTable(dado, colunas){

            private static final long serialVersionUID = 1L;
    
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };

        };

		return tabela;
	}

	/**
	 * Recebe uma tabela e retorna o id selecionado
	 * @param tabela
	 * @return String id
	 */
	public static String getIdSelecionadoDaTabela(JTable tabela){

		if(tabela.getSelectedColumnCount() > 1 || tabela.getSelectedRowCount() > 1){
			JOptionPane.showMessageDialog(null, "Selecione apenas um ID!", "Selecione apenas um Id", JOptionPane.INFORMATION_MESSAGE);
		}else if(tabela.getSelectedColumnCount() == 1 && tabela.getSelectedRowCount() == 1){
			if(tabela.getSelectedColumn() == 0){
                return tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
            }else{
				JOptionPane.showMessageDialog(null, "Selecione um ID!", "Selecione um Id", JOptionPane.INFORMATION_MESSAGE);
            }
		}

        return null;
    }
}
