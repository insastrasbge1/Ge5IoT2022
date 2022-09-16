/*
 Copyright 2000-2014 Francois de Bertrand de Beuvron

 This file is part of CoursBeuvron.

 CoursBeuvron is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 CoursBeuvron is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.beuvron.cours.multiTache.utils.testSimulationClock;

/**
 *
 * @author francois
 */
public class BosseurPannel extends javax.swing.JPanel {
    
    private Bosseur edited;
    private int state = 0;
    private Thread curThread=null;

    /**
     * Creates new form BosseurPannel
     */
    public BosseurPannel() {
        initComponents();
        
        this.jbInterrompt.setEnabled(false);
    }

    /**
     *
     * @param edited
     */
    public BosseurPannel(Bosseur edited) {
        this.initBosseur(edited);
    }
    
    
    
    /**
     * doit être appelée après avoir utilisé le constructeur sans paramètre
     * (fourni pour pouvoir utiliser le generateur netbeans)
     * @param b
     */
    public final void initBosseur(Bosseur b) {
        if (this.edited != null) {
            throw new Error("interdit de changer le bosseur");
        }
        this.edited = b;
        this.jlNom.setText(b.getNom());
        this.jtfDuree.setText(""+b.getDureeJobEnUT());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDuree = new javax.swing.JTextField();
        jbChange = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbStart = new javax.swing.JButton();
        jbInterrompt = new javax.swing.JButton();

        jlNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNom.setText("Vous devez faire setBosseur");

        jLabel2.setText("durée Job (en UT) :");

        jtfDuree.setText("5");

        jbChange.setText("change");
        jbChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChangeActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jbStart.setText("Start");
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });
        jPanel1.add(jbStart);

        jbInterrompt.setText("Interrompt");
        jbInterrompt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInterromptActionPerformed(evt);
            }
        });
        jPanel1.add(jbInterrompt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtfDuree, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbChange, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlNom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbChange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChangeActionPerformed
        // TODO add your handling code here:
        this.edited.setDureeJobEnUT(Long.parseLong(this.jtfDuree.getText()));
    }//GEN-LAST:event_jbChangeActionPerformed

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        // TODO add your handling code here:
        if (this.state == 0) {
            this.edited.setDoitArreter(false);
            this.curThread = new Thread(this.edited);
            this.curThread.start();
            this.jbStart.setText("Stop");
            this.jbInterrompt.setEnabled(true);
            this.state = 1;
        } else {
            this.edited.setDoitArreter(true);
            this.edited.getClock().interromptAttente(this.curThread);
            this.jbStart.setText("Restart");
            this.jbInterrompt.setEnabled(false);
            this.state = 0;
        }
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbInterromptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInterromptActionPerformed
        this.edited.getClock().interromptAttente(this.curThread);
    }//GEN-LAST:event_jbInterromptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbChange;
    private javax.swing.JButton jbInterrompt;
    private javax.swing.JButton jbStart;
    private javax.swing.JLabel jlNom;
    private javax.swing.JTextField jtfDuree;
    // End of variables declaration//GEN-END:variables
}
