package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Target extends Sel{
    public Target(int x, int y){
        super(x,y);
        
        URL loc = this.getClass().getResource("target.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
