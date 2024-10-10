import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * trida pro kresleni na platno: zobrazeni pixelu
 * 
 * @author PGRF FIM UHK
 * @version 2020
 */

public class Canvas {

	private JFrame frame;
	private JPanel panel;
	private BufferedImage img;
    private int currentX;
    private int currentY;

	public Canvas(int width, int height) {
		frame = new JFrame();

		frame.setLayout(new BorderLayout());
		frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        currentX = img.getWidth() / 2;
        currentY = img.getHeight() / 2;
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				present(g);
			}
		};

		panel.setPreferredSize(new Dimension(width, height));

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
                    currentY--;
                }
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
                    currentY++;
                }
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
                    currentX--;
                }
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
                    currentX++;
                }
            }
        });
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	public void clear() {
		Graphics gr = img.getGraphics();
		gr.setColor(new Color(0x2f2f2f));
		gr.fillRect(0, 0, img.getWidth(), img.getHeight());
	}

	public void present(Graphics graphics) {
		graphics.drawImage(img, 0, 0, null);
	}

	// public void draw() {
	// 	clear();
    //     int centerX = img.getWidth() / 2;
    //     int centerY = img.getHeight() / 2;
	// 	img.setRGB(centerX, centerY, 0xffff00);
	// }
    public void draw() {
        clear();
        int full = img.getWidth();
        
        int startX = img.getWidth() / 4;
        int endX = 3 * img.getWidth() / 4;
        int startY = img.getHeight() / 4;
        int endY = 3 * img.getHeight() / 4;

        //čtverec

        // for (int x = startX; x < endX; x++) {
        //     for (int y = startY; y < endY; y++) {
        //         img.setRGB(x, y, 0x0000ff); 
        //     }
        // }

        //uhlopříčky

        // for (int x = startX; x < endX; x++) {
        //     img.setRGB(x, startY + x - startX, 0x00ff00);
        //     img.setRGB(x, endY - x + startX, 0x00ff00);
        // }

        //malovani

    }
    

	public void start() {
		draw();
		panel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Canvas(600, 600).start());
	}

}