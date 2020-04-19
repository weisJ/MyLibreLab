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
package VisualLogic;

import java.awt.Color;

/**
 * @author Carmelo
 */
public class FrameDoc extends javax.swing.JDialog {

    public MyImage image = new MyImage();
    public PanelDokumentation panel;

    /**
     * Creates new form FrameDoc
     */
    public FrameDoc(java.awt.Frame parent) {
        super(parent);
        initComponents();

        image.setBackground(Color.WHITE);

        jScrollPane1.add(image);
        jScrollPane1.setViewportView(image);

        panel = new PanelDokumentation();
        jTabbedPane1.addTab(java.util.ResourceBundle.getBundle("VisualLogic/FrameDoc").getString("DOCUMENTATION"), panel);
        jTabbedPane1.setSelectedComponent(panel);

        jTabbedPane1.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel2.setPreferredSize(new java.awt.Dimension(14, 30));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("VisualLogic/FrameDoc"); // NOI18N
        jLabel1.setText(bundle.getString("ELEMENT :")); // NOI18N

        label.setText("???");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                         .add(jPanel2Layout.createSequentialGroup()
                                           .add(jLabel1)
                                           .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                           .add(label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                         .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                           .add(jLabel1)
                                           .add(label))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jTabbedPane1.addTab(bundle.getString("PINS"), jScrollPane1); // NOI18N

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void openDoc(FrameMain owner, Element element) {

        try {
            panel.openElementDocFile(owner, element);
        } catch (Exception ex) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
