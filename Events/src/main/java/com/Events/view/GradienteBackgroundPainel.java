package com.Events.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class GradienteBackgroundPainel extends JPanel{
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Define as cores para o gradiente
        Color startColor = new Color(35,35,142);
        Color endColor = new Color(141, 197, 252);

        // Configura o ponto inicial e final do gradiente
        Point2D startPoint = new Point2D.Float(0, 0);
        Point2D endPoint = new Point2D.Float(0, getHeight());

        // Configura o gradiente
        GradientPaint gradient = new GradientPaint(startPoint, startColor, endPoint, endColor);

        // Preenche o fundo do painel com o gradiente
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
