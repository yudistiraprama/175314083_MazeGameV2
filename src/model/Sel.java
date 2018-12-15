package model;

import java.awt.Image;

public class Sel {

    private int posisiX;
    private int posisiY;
    private Image image;
    private int Jarak = 40;

    public Sel(int x, int y) {
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

    public boolean PosisiKiriObjek(Sel Objek) {
        if (((this.getPosisiX() - Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Sel Objek) {
        if (((this.getPosisiX() + Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Sel Objek) {
        if (((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Sel Objek) {
        if (((this.getPosisiY() + Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
}
