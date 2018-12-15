package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Tembok extends Sel {

    public Tembok(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("wall.jpg");
        ImageIcon tembok = new ImageIcon(loc);
        Image image = tembok.getImage();
        this.setImage(image);
    }
}
