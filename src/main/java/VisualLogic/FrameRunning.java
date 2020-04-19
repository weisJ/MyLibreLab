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

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

/**
 * @author Homer
 */
public class FrameRunning extends javax.swing.JFrame {

    private Basis basis;

    /**
     * Creates new form FrameRunning
     */
    public FrameRunning(Basis basis, boolean unDecorated) {
        this.setVisible(false);
        this.setUndecorated(unDecorated);

        initComponents();

        this.basis = basis;

        SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 5000, 1);
        jSpinnerDebugDelay.setModel(model1);

        JPanel panelFront = new BasisPanel(basis.getFrontBasis());
        panelFront.setSize(basis.getFrontBasis().getWidth(), basis.getFrontBasis().getHeight());
        panelFront.setPreferredSize(new Dimension(basis.getFrontBasis().getWidth(), basis.getFrontBasis().getHeight()));
        this.getContentPane().add(panelFront);
        //basis.getFrontBasis().panel=panelFront;

        basis.delay = 0;
        if (basis.frameCircuit != null) {
            try {
                setIconImage(basis.frameCircuit.getIconImage());
            } catch (Exception ex) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton_PauseVM = new javax.swing.JButton();
        jButtonStopVM = new javax.swing.JButton();
        jButtonStepVM = new javax.swing.JButton();
        jButtonAnalogWindow = new javax.swing.JButton();
        jButtonDigitalWindow = new javax.swing.JButton();
        jButtonTestPoint = new javax.swing.JButton();
        jButtonDebugConsole = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelDebugDelay = new javax.swing.JLabel();
        jSpinnerDebugDelay = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 33));

        jButton_PauseVM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/pause24.gif"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("VisualLogic/FrameCircuit"); // NOI18N
        jButton_PauseVM.setToolTipText(bundle.getString("Pause_VM")); // NOI18N
        jButton_PauseVM.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton_PauseVM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PauseVMActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_PauseVM);

        jButtonStopVM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/stop24.gif"))); // NOI18N
        jButtonStopVM.setToolTipText(bundle.getString("Stop_VM")); // NOI18N
        jButtonStopVM.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonStopVM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopVMActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonStopVM);

        jButtonStepVM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/Resume.GIF"))); // NOI18N
        jButtonStepVM.setToolTipText(bundle.getString("Weiter_VM")); // NOI18N
        jButtonStepVM.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonStepVM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepVMActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonStepVM);

        jButtonAnalogWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/graphDouble.gif"))); // NOI18N
        jButtonAnalogWindow.setToolTipText(bundle.getString("NumerikGraphWindow")); // NOI18N
        jButtonAnalogWindow.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonAnalogWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalogWindowActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAnalogWindow);

        jButtonDigitalWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/graphBoolean.gif"))); // NOI18N
        jButtonDigitalWindow.setToolTipText(bundle.getString("DigitalGraphWindow")); // NOI18N
        jButtonDigitalWindow.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonDigitalWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDigitalWindowActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDigitalWindow);

        jButtonTestPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/testpoint.PNG"))); // NOI18N
        jButtonTestPoint.setToolTipText(bundle.getString("TestpointWindow")); // NOI18N
        jButtonTestPoint.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonTestPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestPointActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonTestPoint);

        jButtonDebugConsole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/utilities-terminal.png"))); // NOI18N
        jButtonDebugConsole.setToolTipText("Console");
        jButtonDebugConsole.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonDebugConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDebugConsoleActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDebugConsole);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabelDebugDelay.setText(bundle.getString("Delay")); // NOI18N
        jPanel1.add(jLabelDebugDelay);

        jSpinnerDebugDelay.setPreferredSize(new java.awt.Dimension(50, 20));
        jSpinnerDebugDelay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerDebugDelayStateChanged(evt);
            }
        });
        jPanel1.add(jSpinnerDebugDelay);

        jToolBar1.add(jPanel1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDebugConsoleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDebugConsoleActionPerformed
    {//GEN-HEADEREND:event_jButtonDebugConsoleActionPerformed
        if (basis.frameCircuit != null) {
            basis.console.setVisible(true);
        }
    }//GEN-LAST:event_jButtonDebugConsoleActionPerformed

    private void jSpinnerDebugDelayStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSpinnerDebugDelayStateChanged
    {//GEN-HEADEREND:event_jSpinnerDebugDelayStateChanged

        basis.delay = ((Integer) jSpinnerDebugDelay.getValue()).intValue();
    }//GEN-LAST:event_jSpinnerDebugDelayStateChanged

    private void jButtonAnalogWindowActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAnalogWindowActionPerformed
    {//GEN-HEADEREND:event_jButtonAnalogWindowActionPerformed
        if (basis.frameCircuit != null) {
            basis.frameDoubleGraph.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAnalogWindowActionPerformed

    private void jButtonStepVMActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonStepVMActionPerformed
    {//GEN-HEADEREND:event_jButtonStepVMActionPerformed
        basis.resume();
    }//GEN-LAST:event_jButtonStepVMActionPerformed

    private void jButton_PauseVMActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton_PauseVMActionPerformed
    {//GEN-HEADEREND:event_jButton_PauseVMActionPerformed
        basis.pause();
    }//GEN-LAST:event_jButton_PauseVMActionPerformed

    private void jButtonStopVMActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonStopVMActionPerformed
    {//GEN-HEADEREND:event_jButtonStopVMActionPerformed

        basis.stop();
        if (basis.frameCircuit != null) {
            //basis.frameCircuit.stopBasis();
            //basis.frameCircuit.setVisible(true);
        }
    }//GEN-LAST:event_jButtonStopVMActionPerformed

    private void jButtonTestPointActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTestPointActionPerformed
    {//GEN-HEADEREND:event_jButtonTestPointActionPerformed
        if (basis.frameCircuit != null) {
            basis.dialogTestpoint.setVisible(true);
        }
    }//GEN-LAST:event_jButtonTestPointActionPerformed

    private void jButtonDigitalWindowActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonDigitalWindowActionPerformed
    {//GEN-HEADEREND:event_jButtonDigitalWindowActionPerformed
        if (basis.frameCircuit != null) {
            basis.frameBooleanGraph.setVisible(true);
        }
    }//GEN-LAST:event_jButtonDigitalWindowActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //removeAll();

        basis.stop();
        if (basis.panelMode) basis.closeCircuitWindow();
        else basis.frameCircuit.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalogWindow;
    private javax.swing.JButton jButtonDebugConsole;
    private javax.swing.JButton jButtonDigitalWindow;
    private javax.swing.JButton jButtonStepVM;
    private javax.swing.JButton jButtonStopVM;
    private javax.swing.JButton jButtonTestPoint;
    private javax.swing.JButton jButton_PauseVM;
    private javax.swing.JLabel jLabelDebugDelay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerDebugDelay;
    public javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
