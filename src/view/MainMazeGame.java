package view;

import model.Tempat;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainMazeGame extends javax.swing.JFrame {

    Tempat tempat;
    File file;

    public MainMazeGame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        perintah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRestar = new javax.swing.JButton();
        pixelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        pintasButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        perintah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perintahActionPerformed(evt);
            }
        });

        jLabel1.setText("PERINTAH");

        btnRestar.setText("RESTART");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });

        pixelPanel.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout pixelPanelLayout = new javax.swing.GroupLayout(pixelPanel);
        pixelPanel.setLayout(pixelPanelLayout);
        pixelPanelLayout.setHorizontalGroup(
            pixelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        pixelPanelLayout.setVerticalGroup(
            pixelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        undoButton.setText("UNDO");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        redoButton.setText("REDO");
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });

        pintasButton.setText("PINTAS");
        pintasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pintasButtonActionPerformed(evt);
            }
        });

        gameMenu.setText("Game");
        gameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameMenuActionPerformed(evt);
            }
        });

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(saveMenuItem);

        exitMenuItem.setText("exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        gameMenu.add(exitMenuItem);

        menuBar.add(gameMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pixelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(okButton)
                        .addGap(12, 12, 12)
                        .addComponent(undoButton)
                        .addGap(12, 12, 12)
                        .addComponent(redoButton)
                        .addGap(7, 7, 7)
                        .addComponent(pintasButton)
                        .addGap(7, 7, 7)
                        .addComponent(btnRestar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(pixelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(okButton)
                    .addComponent(undoButton)
                    .addComponent(redoButton)
                    .addComponent(pintasButton)
                    .addComponent(btnRestar))
                .addContainerGap())
        );

        pixelPanel.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(638, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            tempat = new Tempat(file);
            pixelPanel.add(tempat);
            tempat.setSize(tempat.getLebar(), tempat.getTinggi());
            //setelah diset panel pixel, kita letakkan posisi tempat sekoban
            int lebar = pixelPanel.getWidth();
            int tinggi = pixelPanel.getHeight();
            //mendapatkan titik koordinat x,y
            int x = (lebar - tempat.getWidth()) / 2;
            int y = (tinggi - tempat.getHeight()) / 2;
            tempat.setLocation(x, y);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void perintahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perintahActionPerformed
        tempat.PerintahGerak(perintah.getText());
        perintah.setText("");
        tempat.setIsi(tempat.getIsi());
        tempat.isCompleted();
    }//GEN-LAST:event_perintahActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void gameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameMenuActionPerformed

    }//GEN-LAST:event_gameMenuActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        tempat.restartLevel();
        perintah.setText("");
    }//GEN-LAST:event_btnRestarActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        tempat.PerintahGerak(perintah.getText());
        perintah.setText("");
        tempat.isCompleted();
    }//GEN-LAST:event_okButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        tempat.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        tempat.redo();
    }//GEN-LAST:event_redoButtonActionPerformed

    private void pintasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pintasButtonActionPerformed
        tempat.jalanPintas();
        tempat.isCompleted();
    }//GEN-LAST:event_pintasButtonActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tempat.setIsi(tempat.getIsi());
            tempat.simpanKonfigurasi(fc.getSelectedFile());
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMazeGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestar;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton okButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField perintah;
    private javax.swing.JButton pintasButton;
    private javax.swing.JPanel pixelPanel;
    private javax.swing.JButton redoButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
