package model;
import java.awt.Image;

public class Pixel {
    private int posisiX;
    private int posisiY;
    private Image image; //untuk membuat gambar dalam pixel posisi xy
    private int Jarak = 40; //jika sudah menentukaan  jarak/pixel 20 semua gambar harus di set 20x20 pixel
    
    public Pixel(int x, int y) {
        this.posisiX = x;
        this.posisiY = y;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int x) {
        this.posisiX = x;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int y) {
        this.posisiY = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
public boolean PosisiKiriObjek(Pixel Objek) {
        if (((this.getPosisiX() - Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Pixel Objek) {
        if (((this.getPosisiX() + Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Pixel Objek) {
        if (((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Pixel Objek) {
        if (((this.getPosisiY() + Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
}
