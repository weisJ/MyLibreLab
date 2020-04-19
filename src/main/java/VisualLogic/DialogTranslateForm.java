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

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
/*
 * NewJDialog.java
 *
 * Created on 7. April 2007, 10:26
 */

/**
 * @author Carmelo
 */
public class DialogTranslateForm extends javax.swing.JDialog {
    public DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form NewJDialog
     */
    public DialogTranslateForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

//        model.addColumn("Component");
//        model.addColumn("Current Text");
//        model.addColumn("Current ToolTipText");
//        model.addColumn("Your Translation");

        model = (DefaultTableModel) jTable1.getModel();
//        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Translate Form");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]
                {

                },
            new String[]
                {
                    "Component", "Current Text", "Current ToolTipText", "Your Translation"
                }
        ) {
            boolean[] canEdit = new boolean[]
                {
                    false, false, false, true
                };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Deutsch", "English", "Spanish", "Other"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jTextField1.setEnabled(false);

        jLabel1.setText("Other Language : ");

        jLabel2.setText("Translate to : ");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(layout.createSequentialGroup()
                             .addContainerGap()
                             .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                                        .add(layout.createSequentialGroup()
                                                   .add(jLabel2)
                                                   .add(11, 11, 11)
                                                   .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(jLabel1)
                                                   .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                   .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                             .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                  .add(layout.createSequentialGroup()
                             .addContainerGap()
                             .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel1)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel2))
                             .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                             .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                             .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 445) / 2, (screenSize.height - 332) / 2, 445, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() == 3) {
            jTextField1.setEnabled(true);
        } else jTextField1.setEnabled(false);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_jComboBox1PropertyChange
    {//GEN-HEADEREND:event_jComboBox1PropertyChange

    }//GEN-LAST:event_jComboBox1PropertyChange

    public static void execute(java.awt.Frame parent, Container container, String title) {
        DialogTranslateForm frm = new DialogTranslateForm(parent, true);

        String[] row = new String[5];
        row[0] = new String("Title");
        row[1] = title;
        row[2] = new String("");
        row[3] = new String("");
        row[4] = new String("");

        frm.model.addRow(row);

        frm.rekursion(container);

        frm.setVisible(true);
    }

    public void durchforsteJMenu(JMenu menu) {
        Component[] elements = menu.getMenuComponents();

        for (int i = 0; i < elements.length; i++) {
            Component comp = elements[i];
            if (comp instanceof JMenuItem) {
                JMenuItem mni = (JMenuItem) comp;

                String[] row = new String[5];
                row[0] = new String("");
                row[1] = new String("");
                row[2] = new String("");
                row[3] = new String("");
                row[4] = new String("");

                row[0] = comp.getClass().getName();
                row[1] = mni.getText();
                row[2] = mni.getToolTipText();

                model.addRow(row);
            }
        }
    }

    public void rekursion(Container container) {
        boolean oki;
        String str = "";
        Component[] comps = container.getComponents();
        for (int i = 0; i < comps.length; i++) {
            Component comp = comps[i];

            if (comp != null) {

                String compName = comp.getClass().getName();

                if (!compName.equalsIgnoreCase("VisualLogic.ElementPalette")) {
                    oki = false;

                    String[] row = new String[5];
                    row[0] = new String("");
                    row[1] = new String("");
                    row[2] = new String("");
                    row[3] = new String("");
                    row[4] = new String("");

                    if (comp instanceof JMenuItem) {
                        String text = ((JMenuItem) comp).getText();
                        String tip = ((JMenuItem) comp).getToolTipText();
                        if (text == null) text = "";
                        if (tip == null) tip = "";

                        if (text.length() > 0 || tip.length() > 0) {
                            row[0] = comp.getClass().getName();
                            row[1] = text;
                            row[2] = tip;

                            model.addRow(row);
                            durchforsteJMenu((JMenu) comp);
                        }
                    } else if (comp instanceof JLabel) {
                        String text = ((JLabel) comp).getText();
                        String tip = ((JLabel) comp).getToolTipText();
                        if (text == null) text = "";
                        if (tip == null) tip = "";

                        if (text.length() > 0 || tip.length() > 0) {
                            row[0] = comp.getClass().getName();
                            row[1] = text;
                            row[2] = tip;

                            model.addRow(row);
                        }
                    } else if (comp instanceof JButton) {
                        String text = ((JButton) comp).getText();
                        String tip = ((JButton) comp).getToolTipText();
                        if (text == null) text = "";
                        if (tip == null) tip = "";

                        if (text.length() > 0 || tip.length() > 0) {
                            row[0] = comp.getClass().getName();
                            row[1] = text;
                            row[2] = tip;

                            model.addRow(row);
                        }
                    }

                    rekursion((Container) comp);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
