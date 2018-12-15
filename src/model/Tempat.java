package model;

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
    private ArrayList tempat = new ArrayList();
    private Pemain pemain;
    private Target target;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 40;

    private File Alamatpeta;
    private ArrayList Allperintah = new ArrayList();
    private ArrayList<String> simpanPerintah = new ArrayList<String>();
    private ArrayList<String> undo = new ArrayList<String>();

    private String isi;

    public Tempat(File file) {
        bacaKonfigurasi(file);
    }

    public void bacaKonfigurasi(File file) {
        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                String hasilBaca = "";
                int posisiX = 0;
                int posisiY = 0;
                Tembok wall;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        hasilBaca = hasilBaca + (char) data;
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                    } else if (item == '#') {
                        hasilBaca = hasilBaca + (char) data;
                        wall = new Tembok(posisiX, posisiY);
                        tembok.add(wall);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        hasilBaca = hasilBaca + (char) data;
                        target = new Target(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '@') {
                        hasilBaca = hasilBaca + (char) data;
                        pemain = new Pemain(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {
                        hasilBaca = hasilBaca + (char) data;
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
                setIsi(hasilBaca);
            }
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        tempat.addAll(tembok);
        tempat.add(target);
        tempat.add(pemain);
        for (int i = 0; i < tempat.size(); i++) {
            if (tempat.get(i) != null) {
                Sel item = (Sel) tempat.get(i);
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
            }
        }
    }

    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("[udrl]")) {
                Allperintah.add(input);
                undo.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekTabrakTembok(pemain, "u")) {
                            return;
                        } else {
                            pemain.Gerak(0, -jarak);
                            repaint();
                        }

                    }
                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekTabrakTembok(pemain, "d")) {
                            return;
                        } else {
                            pemain.Gerak(0, jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekTabrakTembok(pemain, "r")) {
                            return;
                        } else {
                            pemain.Gerak(jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekTabrakTembok(pemain, "l")) {
                            return;
                        } else {
                            pemain.Gerak(-jarak, 0);
                            repaint();
                        }
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

    private boolean cekObjekTabrakTembok(Sel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

    public void isCompleted() {
        if (pemain.getPosisiX() == target.getPosisiX() && pemain.getPosisiY() == target.getPosisiY()) {
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini dengan " + this.getAllperintah().size() + " langkah");
            tempat.clear();
        }
    }

    public void undo() {
        int i = undo.size() - 1;
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Sudah di tempat semula");
        } else {
            String input = undo.get(i);
            String[] un = input.split(" ");
            if (un[0].equalsIgnoreCase("d")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(un[1])); j++) {
                    if (!cekObjekTabrakTembok(pemain, "u")) {
                        pemain.Gerak(0, -jarak);
                        repaint();
                    }
                }
                undo.remove(i);
            } else if (un[0].equalsIgnoreCase("u")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(un[1])); j++) {
                    if (!cekObjekTabrakTembok(pemain, "d")) {
                        pemain.Gerak(0, jarak);
                        repaint();
                    }
                }
                undo.remove(i);
            } else if (un[0].equalsIgnoreCase("l")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(un[1])); j++) {
                    if (!cekObjekTabrakTembok(pemain, "r")) {
                        pemain.Gerak(jarak, 0);
                        repaint();
                    }
                }
                undo.remove(i);
            } else if (un[0].equalsIgnoreCase("r")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(un[1])); j++) {
                    if (!cekObjekTabrakTembok(pemain, "l")) {
                        pemain.Gerak(-jarak, 0);
                        repaint();
                    }
                }
                undo.remove(i);
            }
        }
    }

    public String[] auto1() {
        String[] pintas = {"r 3", "d 3", "r 2", "d 1"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
        return pintas;
    }

    public void auto2() {
        String[] pintas = {"r 2", "u 4", "r 3"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
    }

    public void auto3() {
        String[] pintas = {"d 1", "l 2", "d 3", "l 3"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
    }

    public void restartLevel() {
        Allperintah.clear();
        tembok.clear();
        tempat.clear();
        bacaKonfigurasi(Alamatpeta);
        repaint();
    }

    public void save() {
        for (int i = 0; i < Allperintah.size(); i++) {
            simpanPerintah.add(Allperintah.get(i).toString());
        }
    }

    public void load() {
        for (int i = 0; i < simpanPerintah.size(); i++) {
            PerintahGerak(simpanPerintah.get(i).toString());
        }
        simpanPerintah.clear();
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public Pemain getPemain() {
        return pemain;
    }

    public void setPemain(Pemain pemain) {
        this.pemain = pemain;
    }

    public Target getGawang() {
        return target;
    }

    public void setGawang(Target gawang) {
        this.target = gawang;
    }

    public ArrayList getTempat() {
        return tempat;
    }

    public void setTempat(ArrayList tempat) {
        this.tempat = tempat;
    }

    public ArrayList getAllperintah() {
        return Allperintah;
    }

    public void setAllperintah(ArrayList Allperintah) {
        this.Allperintah = Allperintah;
    }

    public ArrayList getSimpanPerintah() {
        return simpanPerintah;
    }

    public void setSimpanPerintah(ArrayList simpanPerintah) {
        this.simpanPerintah = simpanPerintah;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

}
