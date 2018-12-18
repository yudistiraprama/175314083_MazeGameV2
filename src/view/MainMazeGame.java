package view;

import model.Tempat;
import java.io.File;
import javax.swing.JOptionPane;


public class MainMazeGame extends javax.swing.JFrame {

    Tempat tempat;
    File file;

    public MainMazeGame() {
        initComponents();
        this.setTitle("Maze Game");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        perintah = new javax.swing.JTextField();
        perintahLabel = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        tempatPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        autoButton = new javax.swing.JButton();
        langkahLabel = new javax.swing.JLabel();
        langkahText = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        caraBermainTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        mapMenu = new javax.swing.JMenu();
        map1MenuItem = new javax.swing.JMenuItem();
        map2MenuItem = new javax.swing.JMenuItem();
        map3MenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        perintah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perintahActionPerformed(evt);
            }
        });

        perintahLabel.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        perintahLabel.setText("PERINTAH");

        restartButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        restartButton.setText("RESTART");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        tempatPanel.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout tempatPanelLayout = new javax.swing.GroupLayout(tempatPanel);
        tempatPanel.setLayout(tempatPanelLayout);
        tempatPanelLayout.setHorizontalGroup(
            tempatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        tempatPanelLayout.setVerticalGroup(
            tempatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        okButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        undoButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        undoButton.setText("UNDO");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        autoButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        autoButton.setText("AUTO");
        autoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoButtonActionPerformed(evt);
            }
        });

        langkahLabel.setText("Jumlah Langkah :");

        langkahText.setText("0");

        saveButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        loadButton.setText("LOAD");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        caraBermainTextArea.setEditable(false);
        caraBermainTextArea.setColumns(20);
        caraBermainTextArea.setRows(5);
        caraBermainTextArea.setText("  === WELCOME TO MAZE GAME! ===\n\n Map dapan dipilih secara manual\n dengan menu OPEN atau Map dapat\n dipilih pada menu MAP\n\n Cara menggerakkan pemain :\n\n\t       N(spasi)X\n\n N = Arah Gerakan\n X = Jumlah Langkah\n\n Arah Gerakan :\n U = Up/naik\n D = Down/turun\n L = Left/kiri\n R = Roght/Kanan\n\n OK/Enter = Menjalankan pemain\n UNDO\t = balik ke tempat \n\t   sebelumnya\n AUTO\t = Menuju targe dengan\n\t   otomatis\n SAVE\t = Menyimpan posisi \n\t   terakhir pemain\n LOAD\t = Mengload posisi pemain \n\t   yang di save\n\n *SAVE dan LOAD hanya berlaku \n  untuk map yang sama\n\n\t=== SELAMAT BERMAIN ===");
        caraBermainTextArea.setToolTipText("");
        caraBermainTextArea.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(caraBermainTextArea);

        jLabel1.setText("By : Prama & Bayu");

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

        mapMenu.setText("Map");
        mapMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        map1MenuItem.setText("Map 1");
        map1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map1MenuItemActionPerformed(evt);
            }
        });
        mapMenu.add(map1MenuItem);

        map2MenuItem.setText("Map 2");
        map2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map2MenuItemActionPerformed(evt);
            }
        });
        mapMenu.add(map2MenuItem);

        map3MenuItem.setText("Map 3");
        map3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map3MenuItemActionPerformed(evt);
            }
        });
        mapMenu.add(map3MenuItem);

        gameMenu.add(mapMenu);

        exitMenuItem.setText("Exit");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(perintahLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(undoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(autoButton)
                                .addGap(12, 12, 12)
                                .addComponent(restartButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(langkahLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(langkahText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(tempatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(tempatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(langkahLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(langkahText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(perintahLabel)
                            .addComponent(perintah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton)
                        .addComponent(undoButton)
                        .addComponent(autoButton)
                        .addComponent(restartButton)
                        .addComponent(saveButton)
                        .addComponent(loadButton)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        tempatPanel.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(1046, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            tempatPanel.removeAll();
            tempat = new Tempat(file);
            tempatPanel.add(tempat);
            tempat.setSize(tempat.getLebar(), tempat.getTinggi());
            int lebar = tempatPanel.getWidth();
            int tinggi = tempatPanel.getHeight();
            int x = (lebar - tempat.getWidth()) / 2;
            int y = (tinggi - tempat.getHeight()) / 2;
            tempat.setLocation(x, y);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void perintahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perintahActionPerformed
        tempat.PerintahGerak(perintah.getText());
        perintah.setText("");
        langkahText.setText(String.valueOf(tempat.getAllperintah().size()));
        tempat.Completed();
    }//GEN-LAST:event_perintahActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void gameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameMenuActionPerformed

    }//GEN-LAST:event_gameMenuActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        tempat.restart();
        perintah.setText("");
        langkahText.setText("0");
    }//GEN-LAST:event_restartButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        tempat.PerintahGerak(perintah.getText());
        perintah.setText("");
        langkahText.setText(String.valueOf(tempat.getAllperintah().size()));
        tempat.Completed();
    }//GEN-LAST:event_okButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        tempat.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void autoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoButtonActionPerformed
        tempat.restart();
        int a = tempat.getTarget().getPosisiX() - tempat.getPemain().getPosisiX();
        int b = tempat.getTarget().getPosisiY() - tempat.getPemain().getPosisiY();
        tempat.getPemain().Gerak(a, b);
        tempat.repaint();
        JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini dengan perintah AUTO");
        tempat.restart();
        langkahText.setText("0");
        tempat.Completed();
    }//GEN-LAST:event_autoButtonActionPerformed

    private void map1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_map1MenuItemActionPerformed
        tempatPanel.removeAll();
        tempat = new Tempat(new File("map1.txt"));
        tempatPanel.add(tempat);
        tempat.setSize(tempat.getLebar(), tempat.getTinggi());
        int lebar = tempatPanel.getWidth();
        int tinggi = tempatPanel.getHeight();
        int x = (lebar - tempat.getWidth()) / 2;
        int y = (tinggi - tempat.getHeight()) / 2;
        tempat.setLocation(x, y);
        langkahText.setText("0");
        JOptionPane.showMessageDialog(null, "              WELCOME!\n           === MAP 1 ===");
    }//GEN-LAST:event_map1MenuItemActionPerformed

    private void map2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_map2MenuItemActionPerformed
        tempatPanel.removeAll();
        tempat = new Tempat(new File("map2.txt"));
        tempatPanel.add(tempat);
        tempat.setSize(tempat.getLebar(), tempat.getTinggi());
        int lebar = tempatPanel.getWidth();
        int tinggi = tempatPanel.getHeight();
        int x = (lebar - tempat.getWidth()) / 2;
        int y = (tinggi - tempat.getHeight()) / 2;
        tempat.setLocation(x, y);
        langkahText.setText("0");
        JOptionPane.showMessageDialog(null, "              WELCOME!\n           === MAP 2 ===");
    }//GEN-LAST:event_map2MenuItemActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        tempat.save();
        JOptionPane.showMessageDialog(null, "Konfigurasi Tersimpan!\nSAMPAI JUMPA !");
        tempatPanel.removeAll();
        tempatPanel.setBackground(null);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        tempat.load();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void map3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_map3MenuItemActionPerformed
        tempatPanel.removeAll();
        tempat = new Tempat(new File("map3.txt"));
        tempatPanel.add(tempat);
        tempat.setSize(tempat.getLebar(), tempat.getTinggi());
        int lebar = tempatPanel.getWidth();
        int tinggi = tempatPanel.getHeight();
        int x = (lebar - tempat.getWidth()) / 2;
        int y = (tinggi - tempat.getHeight()) / 2;
        tempat.setLocation(x, y);
        langkahText.setText("0");
        JOptionPane.showMessageDialog(null, "              WELCOME!\n           === MAP 3 ===");
    }//GEN-LAST:event_map3MenuItemActionPerformed

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
    private javax.swing.JButton autoButton;
    private javax.swing.JTextArea caraBermainTextArea;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu gameMenu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel langkahLabel;
    private javax.swing.JLabel langkahText;
    private javax.swing.JButton loadButton;
    private javax.swing.JMenuItem map1MenuItem;
    private javax.swing.JMenuItem map2MenuItem;
    private javax.swing.JMenuItem map3MenuItem;
    private javax.swing.JMenu mapMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton okButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField perintah;
    private javax.swing.JLabel perintahLabel;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel tempatPanel;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
