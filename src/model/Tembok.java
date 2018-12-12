package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
public class Tembok extends Pixel{
    public Tembok(int x, int y){
        super(x,y);
        
        URL loc = this.getClass().getResource("wall.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
