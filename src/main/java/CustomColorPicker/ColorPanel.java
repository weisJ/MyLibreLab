/*
MyOpenLab by Carmelo Salafia www.myopenlab.de
Copyright (C) 2004  Carmelo Salafia cswi@gmx.de

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package CustomColorPicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TexturePaint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author Salafia
 */
public class ColorPanel extends javax.swing.JPanel {

    public static final int MODE_FLAT = 0;
    public static final int MODE_LINEAR = 1;
    public static final int MODE_RADIAL = 2;

    public boolean wiederholung = false;

    public BufferedImage image;

    /**
     * Creates new form MyPanel
     */
    public ColorPanel() {
        initComponents();
    }

    public int modus = MODE_FLAT;

    public Point p1 = new Point(100, 100);
    public Point p2 = new Point(200, 200);

    public Color color1 = new Color(255, 255, 255);
    public Color color2 = new Color(0, 0, 0);

    public int color1Transparency = 255;
    public int color2Transparency = 255;

    public int selected = 0;

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }

            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(0, 296, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseReleased
    {//GEN-HEADEREND:event_formMouseReleased
        selected = 0;
    }//GEN-LAST:event_formMouseReleased

    private void formMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseMoved
    {//GEN-HEADEREND:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMouseDragged
    {//GEN-HEADEREND:event_formMouseDragged
        int x = evt.getX();
        int y = evt.getY();
        if (selected == 1) {
            p1.x = x;
            p1.y = y;
            repaint();
        }

        if (selected == 2) {
            p2.x = x;
            p2.y = y;
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_formMousePressed
    {//GEN-HEADEREND:event_formMousePressed
        int x = evt.getX();
        int y = evt.getY();

        int d = 6;
        if (x >= p1.x - d && y >= p1.y - d && x <= p1.x + d && y <= p1.y + d) {
            selected = 1;
        }

        if (x >= p2.x - d && y >= p2.y - d && x <= p2.x + d && y <= p2.y + d) {
            selected = 2;
        }
    }//GEN-LAST:event_formMousePressed

    public Color withTransparency(Color a, int transp) {
        return new Color(a.getRed(), a.getGreen(), a.getBlue(), transp);
    }

    public void setFillColor(Graphics2D g) {
        if (modus == MODE_FLAT) {
            g.setColor(withTransparency(color1, color1Transparency));
        } else if (modus == MODE_LINEAR) {
            GradientPaint gp = new GradientPaint
                (p1.x, p1.y, withTransparency(color1, color1Transparency),
                    p2.x, p2.y, withTransparency(color2, color2Transparency),
                    wiederholung);

            g.setPaint(gp);
        } else if (modus == MODE_RADIAL) {
            RoundGradientPaint rgp = new RoundGradientPaint(p1.x, p1.y, withTransparency(color1, color1Transparency),
                new Point2D.Double(p2.x, p2.y), withTransparency(color2, color2Transparency));
            g.setPaint(rgp);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (image != null) {
            Rectangle2D tr = new Rectangle2D.Double(0, 0, image.getWidth() / 5, image.getHeight() / 5);
            TexturePaint tp = new TexturePaint(image, tr);
            g2.setPaint(tp);
            g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        }

        setFillColor(g2);

        g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

        if (modus != MODE_FLAT) {
            int d = 6;

            g2.setFont(new Font("Dialog", 1, 12));
            FontMetrics fm = g2.getFontMetrics();
            String txtTemp = "P1 X:" + p1.x + " Y:" + p1.y + " - P2 X:" + p2.x + " Y:" + p2.y;
            Rectangle2D rFont = fm.getStringBounds(txtTemp, g2);
            g2.setColor(new Color(255, 242, 181));
            g2.fillRect((int) (getWidth() - rFont.getWidth() - 12), 3, (int) rFont.getWidth() + d, (int) rFont.getHeight() + 3);
            g2.setColor(new Color(253, 153, 0));
            g2.drawRect((int) (getWidth() - rFont.getWidth() - 12), 3, (int) rFont.getWidth() + d, (int) rFont.getHeight() + 3);
            g2.setColor(Color.BLACK);
            g2.drawString(txtTemp, (int) (getWidth() - rFont.getWidth() - 9), (int) ((rFont.getHeight()) + 3));

            g2.setColor(Color.BLACK);
            g2.fillOval(p1.x - d, p1.y - d, d * 2, d * 2);
            g2.setColor(Color.WHITE);
            g2.drawOval(p1.x - d, p1.y - d, d * 2 - 1, d * 2 - 1);

            g2.setColor(Color.BLACK);
            g2.fillOval(p2.x - d, p2.y - d, d * 2, d * 2);
            g2.setColor(Color.WHITE);
            g2.drawOval(p2.x - d, p2.y - d, d * 2 - 1, d * 2 - 1);

            g2.setXORMode(Color.RED);
            g2.setColor(Color.WHITE);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);

            g2.setPaintMode();
        }
    }
}
