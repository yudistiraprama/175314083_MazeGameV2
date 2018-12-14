package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    private ArrayList<String> redo = new ArrayList<String>();

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

    public void simpanKonfigurasi(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(isi.getBytes());
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);	   // Hapus background
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());// set tinggi lebar sesuai konfigurasi
        tempat.addAll(tembok);
        tempat.add(target);
        tempat.add(pemain);
        for (int i = 0; i < tempat.size(); i++) {
            if (tempat.get(i) != null) {
                Sel item = (Sel) tempat.get(i);//map diterjemahkan dalam kelas pixel.
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
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[1].matches("[udrl]")) {
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

    private boolean cekObjekNabrakTembok(Sel pemain, String input) {
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
        if (pemain.getPosisiX() == target.getPosisiX() && pemain.getPosisiY() == target.getPosisiY()) {
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini dengan " + this.getAllperintah().size() + " langkah");
            tempat.clear();
        }
    }

    public void undo() {
        for (int i = Allperintah.size() - 1; i >= 0; i--) {
            String input = Allperintah.get(i).toString();
            String[] undo = input.split(" ");
            if (undo[1].equalsIgnoreCase("l")) {
                if (cekObjekNabrakTembok(pemain, "r")) {
                    return;
                } else {
                    pemain.Gerak((Integer.valueOf(undo[0]) * jarak), 0);
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("r")) {
                if (cekObjekNabrakTembok(pemain, "l")) {
                    return;
                } else {
                    pemain.Gerak((Integer.valueOf(undo[0]) * -jarak), 0);
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("u")) {
                if (cekObjekNabrakTembok(pemain, "d")) {
                    return;
                } else {
                    pemain.Gerak(0, (Integer.valueOf(undo[0]) * jarak));
                    repaint();
                }
                break;
            } else if (undo[1].equalsIgnoreCase("d")) {
                if (cekObjekNabrakTembok(pemain, "u")) {
                    return;
                } else {
                    pemain.Gerak(0, (Integer.valueOf(undo[0]) * -jarak));
                    repaint();
                }
                break;
            }
        }
    }

    public void redo() {
        for (int i = Allperintah.size() - 1; i >= 0; i--) {
            String input = Allperintah.get(i).toString();
            String[] redo = input.split(" ");
            if (redo[1].equalsIgnoreCase("u")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(redo[0])); j++) {
                    if (cekObjekNabrakTembok(pemain, "u")) {
                        return;
                    } else {
                        pemain.Gerak(0, -jarak);
                        repaint();
                    }

                }
                break;
            } else if (redo[1].equalsIgnoreCase("d")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(redo[0])); j++) {
                    if (cekObjekNabrakTembok(pemain, "d")) {
                        return;
                    } else {
                        pemain.Gerak(0, jarak);
                        repaint();
                    }
                }
                break;
            } else if (redo[1].equalsIgnoreCase("r")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(redo[0])); j++) {
                    if (cekObjekNabrakTembok(pemain, "r")) {
                        return;
                    } else {
                        pemain.Gerak(jarak, 0);
                        repaint();
                    }
                }
                break;
            } else if (redo[1].equalsIgnoreCase("l")) {
                for (int j = 0; j < Integer.parseInt(String.valueOf(redo[0])); j++) {
                    if (cekObjekNabrakTembok(pemain, "l")) {
                        return;
                    } else {
                        pemain.Gerak(-jarak, 0);
                        repaint();
                    }
                }
            }
        }

    }

    public String[] jalanPintas1() {
        String[] pintas = {"3 r","3 d","2 r","1 d"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
        return pintas;
    }
    
    public void jalanPintas2() {
        String[] pintas = {"2 r","4 u","3 r"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
    }
    
    public void jalanPintas3() {
        String[] pintas = {"1 d","2 l","3 d","3 l"};
        for (int i = 0; i < pintas.length; i++) {
            PerintahGerak(pintas[i]);
        }
    }

    public void restartLevel() {
        Allperintah.clear();//hapus semua perintah yang tersimpan
        tembok.clear();//hapus tembok
        tempat.clear();//hapus map
        bacaKonfigurasi(Alamatpeta);//set ulang gambar peta
        repaint();//gambar ulang
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

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
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

//    public String toString(){
//        String s = "";
//        for (int i = 0; i < simpanPerintah.size(); i++) {
//           
//        }
//    }
}
