package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Pemain extends Sel {

    public Pemain(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("pemain.png");
        ImageIcon pemain = new ImageIcon(loc);
        Image image = pemain.getImage();
        this.setImage(image);
    }

    public void Gerak(int x, int y) {
        int posX = this.getPosisiX() + x;
        int posY = this.getPosisiY() + y;
        this.setPosisiX(posX);
        this.setPosisiY(posY);
    }
}
