package com.sparkle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SparklePanel extends JPanel implements MouseMotionListener {

    private final List<Spark> sparks = new ArrayList<>();

    private final WindEngine windEngine = new WindEngine();
    private final PhysicsEngine physics = new PhysicsEngine(800, 800);
    private final Renderer renderer = new Renderer();

    public SparklePanel() {
        addMouseMotionListener(this);

        new javax.swing.Timer(16, e -> {
            windEngine.updateWind();
            physics.updateParticles(sparks, windEngine.getWind());
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Spark s : sparks)
            renderer.draw(g, s);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        addSpark(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        addSpark(e.getX(), e.getY());
    }

    private void addSpark(int x, int y) {
        Color color = new Color(
                240 + (int)(Math.random()*15),
                200 + (int)(Math.random()*55),
                80  + (int)(Math.random()*30)
        );
        sparks.add(new Spark(x, y, color));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Sparkle Sand Wind SRP");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        f.add(new SparklePanel());
        f.setVisible(true);
    }
}

