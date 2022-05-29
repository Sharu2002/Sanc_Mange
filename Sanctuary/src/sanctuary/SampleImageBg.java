/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanctuary;

/**
 *
 * @author sharu
 */
import java.awt.Color;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
        
public class SampleImageBg { 
    JFrame f ;
    JPanel p;
    private JDesktopPane panel;
public SampleImageBg() throws IOException{
    f = new JFrame();
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
     p.setBackground(new Color(0, 0, 0,150)); //transparent
  //   p.setBackground(Color.BLACK);

        panel = new javax.swing.JDesktopPane() {
            private Image image;
            {
                try{
                    image = ImageIO.read(getClass().getResource("x7W3dbQ.jpg"));// source of your background image
                } 
                    catch(IOException e) {
                    e.printStackTrace();
                }
            }
@Override
protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
               
                
}
        };
        panel.add(p);
f.add(panel);
//f.add(p);
 f.setVisible(true);
        f.setSize(1550, 860);


    }
public static void main(String[] args) throws IOException{
        new SampleImageBg();
    }
}

