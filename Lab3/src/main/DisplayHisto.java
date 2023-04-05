package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayHisto extends JFrame {

	private static final long serialVersionUID = 6089213178564858171L;
	private JPanel contentPane;

	public DisplayHisto(int[] tablo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanelDessin panel = new JPanelDessin(tablo);
		contentPane.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	private class JPanelDessin extends JPanel {
		private static final long serialVersionUID = -6332726921677894704L;
		private int[] tablo;

		public JPanelDessin(int[] tablo) {
			super();
			this.tablo = tablo;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setBackground(Color.white);
			double tailleX = (double) this.getWidth() / tablo.length;
			double tailleY = (double) this.getHeight() / (max() + 5);
			int i;
			for (i = 0; i < tablo.length; i++) {
				if (i % 2 == 0) g.setColor(new Color(50, 50, 50));
						else g.setColor(Color.black);
				g.fillRect((int) (i * tailleX), 
						this.getHeight() - ((int) (tailleY * tablo[i])) - 1,
						(int) tailleX,
						(int) (tailleY * tablo[i]));
			}

		}

		private int max() {
			int i;
			int max = 0;
			for (i = 0; i < tablo.length; i++) {
				if (max < tablo[i])
					max = tablo[i];
			}
			return max;
		}
	}
}
