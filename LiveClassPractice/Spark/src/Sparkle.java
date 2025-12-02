

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sparkle extends JPanel implements MouseMotionListener {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	private boolean[][] occupied = new boolean[WIDTH][HEIGHT];
    private final List<Spark> sparks = new ArrayList<>();

    public Sparkle() {
        addMouseMotionListener(this);
        startAnimationTimer();
    }

    // ---- Animation ----
    private void startAnimationTimer() {
        new Timer(16, e -> updateFrame()).start();  // ~60 FPS
    }

    private void updateFrame() {
        updateSparks();
        repaint();
    }

    // ---- Logic ----
    private void updateSparks() {
        Iterator<Spark> it = sparks.iterator();
        while (it.hasNext()) {
            Spark s = it.next();
            s.fall();
            if (s.isDead())
                it.remove();
        }
    }

    // ---- Rendering ----
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSparks(g);
    }

    private void drawSparks(Graphics g) {
        for (Spark s : sparks)
            s.draw(g);
    }

    // ---- Input ----
    @Override
    public void mouseMoved(MouseEvent e) {
        addSpark(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        addSpark(e.getX(), e.getY());
    }

    private void addSpark(int x, int y) {
        sparks.add(new Spark(x, y));
    }

    // ---- Spark class ----
    static class Spark {
        double x, y, dy = 0;
//        final Color color = new Color(
//                200 + (int)(Math.random() * 55),
//                200 + (int)(Math.random() * 55),
//                200 + (int)(Math.random() * 55)
//        );
        
//        final Color color = new Color(
//                (int)(150 + Math.random() * 105),    // Red (150–255)
//                (int)(150 + Math.random() * 105),    // Green (150–255)
//                (int)(150 + Math.random() * 105),    // Blue (150–255)
//                (int)(150 + Math.random() * 105)     // Alpha (150–255)
//        );
        private static final Color[] PALETTE = {
                new Color(255, 100, 100),
                new Color(255, 150, 50),
                new Color(255, 255, 100),
                new Color(150, 255, 150),
                new Color(100, 200, 255),
                new Color(180, 150, 255),
                new Color(255, 120, 220)
        };

		private static final int FLOOR_Y = 760;

        final Color color = PALETTE[(int)(Math.random() * PALETTE.length)];

        Spark(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        void fall() {
//            dy += 0.3;     // gravity
//            y += dy;
//        }
//
//        boolean isDead() {
//            return y > 800; // bottom of the window
//        }
        void fall() {
            if (y < FLOOR_Y) {         // still falling
                dy += 0.3;             // gravity
                y += dy;
            } 
//            else {
//                y = FLOOR_Y;           // rest on floor
//                dy = 0;                // stop moving
//            }
            else {
                y = FLOOR_Y;
                if (Math.random() < 0.1) {
                    x += (Math.random() - 0.5) * 2;  // little side shuffle
                }
            }
        }

        boolean isDead() {
            return false; // never remove sparkles now
        }

//        void draw(Graphics g) {
//            g.setColor(color);
//            g.fillOval((int) x, (int) y, 5, 5);
//        }
        void draw(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // glow
            g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 60));
            g2.fillOval((int)x - 4, (int)y - 4, 12, 12);

            // core sparkle
            g2.setColor(color);
            g2.fillOval((int) x, (int) y, 5, 5);
        }
    }

    // ---- Main ----
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sparkle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Sparkle());
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
