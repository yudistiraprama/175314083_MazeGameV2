package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tempat extends JPanel {

    private ArrayList tembok = new ArrayList();
    private ArrayList gawang = new ArrayList();
    private ArrayList tempat = new ArrayList();
    private Pemain pemain;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 20;

    private File Alamatpeta;
    private ArrayList Allperintah = new ArrayList();

    public Tempat(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {
        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                int posisiX = 0;
                int posisiY = 0;
                Tembok wall;
                Gawang a;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                    } else if (item == '#') {
                        wall = new Tembok(posisiX, posisiY);
                        tembok.add(wall);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        a = new Gawang(posisiX, posisiY);
                        gawang.add(a);
                        posisiX += jarak;
                    } else if (item == '@') {
                        pemain = new Pemain(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);	   // Hapus background
        // Tempat Gambar:
        g.setColor(new Color(255, 255, 255));//set panel warna putih
        g.fillRect(0, 0, this.tinggi, this.lebar);// set tinggi lebar sesuai konfigurasi
        tempat.addAll(tembok);
        tempat.addAll(gawang);
        tempat.add(pemain);
        for (int i = 0; i < tempat.size(); i++) {
            if (tempat.get(i) != null) {
                Pixel item = (Pixel) tempat.get(i);//map diterjemahkan dalam kelas pixel.
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);//proses gambar di panel
            }
        }
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split("");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[1].matches("[udrlz]")) {
                Allperintah.add(input);
                if (in[1].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[0])); i++) {
                        if (cekObjekNabrakTembok(pemain, "u")) {
                            return;
                        } else {
                            pemain.Gerak(0, -jarak);
                            repaint();
                        }

                    }
                } else if (in[1].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[0])); i++) {
                        if (cekObjekNabrakTembok(pemain, "d")) {
                            return;
                        } else {
                            pemain.Gerak(0, jarak);
                            repaint();
                        }
                    }
                } else if (in[1].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[0])); i++) {
                        if (cekObjekNabrakTembok(pemain, "r")) {
                            return;
                        } else {
                            pemain.Gerak(jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[1].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[0])); i++) {
                        if (cekObjekNabrakTembok(pemain, "l")) {
                            return;
                        } else {
                            pemain.Gerak(-jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[1].equalsIgnoreCase("z")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[0])); i++) {
                        undo();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah kata hanya satu");
        }
    }

    private boolean cekObjekNabrakTembok(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;//default return false
    }

    public void isCompleted() {
        for (int j = 0; j < gawang.size(); j++) {
            Gawang gaw = (Gawang) gawang.get(j);//ambil posisi gawang
            if (pemain.getPosisiX() == gaw.getPosisiX() && pemain.getPosisiY() == gaw.getPosisiY()) {//cek posisi bola sama dengan bola.
                JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini");
            }
        }
        tempat.clear();
    }

    public void undo() {
        for (int i = Allperintah.size() - 1; i >= 0; i--) {
            String input = Allperintah.get(i).toString();
            String[] undo = input.split("");
            if (undo[1].equalsIgnoreCase("l")) {
                if (cekObjekNabrakTembok(pemain, "r")) {
                    return;
                } else {
                    pemain.Gerak(jarak, 0);
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("r")) {
                if (cekObjekNabrakTembok(pemain,
                        "l")) {
                    return;
                } else {
                    pemain.Gerak(-jarak, 0);
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("u")) {
                if (cekObjekNabrakTembok(pemain,
                        "d")) {
                    return;
                } else {
                    pemain.Gerak(0, jarak);
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("d")) {
                if (cekObjekNabrakTembok(pemain,
                        "u")) {
                    return;
                } else {
                    pemain.Gerak(0, -jarak);
                    repaint();
                }
                break;
            }
        }

    }

    public void restartLevel() {
        Allperintah.clear();//hapus semua perintah yang tersimpan
        gawang.clear();//hapus gawang
        tembok.clear();//hapus tembok
        tempat.clear();//hapus map
        setPeta(Alamatpeta);//set ulang gambar peta
        repaint();//gambar ulang
    }

    public String getTeksPerintah() {
        String bantu = "";
        for (int i = 0; i < Allperintah.size(); i++) {
            bantu = bantu + Allperintah.get(i) + " ";
        }
        return bantu;
    }

}
