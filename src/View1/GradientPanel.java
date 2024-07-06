//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View1;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {
    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    public static int DIAGONAL_DOWN = 2;
    public static int DIAGONAL_UP = 3;
    private Color color1;
    private Color color2;
    private int direction;

    public GradientPanel() {
        this.color1 = Color.black;
        this.color2 = Color.white;
    }

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public GradientPanel(Color color1, Color color2, int direction) {
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint gradientPaint;
        if (this.direction == HORIZONTAL) {
            gradientPaint = new GradientPaint(0.0F, (float)(this.getHeight() / 2), this.color1, (float)this.getWidth(), (float)(this.getHeight() / 2), this.color2);
        } else if (this.direction == DIAGONAL_DOWN) {
            gradientPaint = new GradientPaint(0.0F, (float)this.getHeight(), this.color1, (float)this.getWidth(), 0.0F, this.color2);
        } else if (this.direction == DIAGONAL_UP) {
            gradientPaint = new GradientPaint(0.0F, 0.0F, this.color1, (float)this.getWidth(), (float)this.getHeight(), this.color2);
        } else {
            gradientPaint = new GradientPaint(0.0F, 0.0F, this.color1, 0.0F, (float)this.getHeight(), this.color2);
        }

        graphics2d.setPaint(gradientPaint);
        graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public Color getColor1() {
        return this.color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return this.color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}

