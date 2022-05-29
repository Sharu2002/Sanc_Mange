/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanctuary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author sharu
 */
public class User implements ActionListener{ 
    JFrame f ;
    JPanel p ;
    JButton user , admin;
    JLabel l;
    JButton back;
    private JDesktopPane panel;
public User() throws IOException{
    f = new JFrame();
    
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,150)); //transparent
    
    //user
    user = new JButton("View");
    user.setBounds(500, 400, 200, 100); 
    user.setForeground(Color.black);
    user.setFont(new Font("Arial" , Font.PLAIN, 22));
    user.setFocusable(false);
    user.addActionListener(this);
    user.setBackground(new Color(102,102,0)); //transparent
    user.setBorder(new LineBorder(new Color(102,51,0 ,0)));

    
    //admin
    
    admin = new JButton("Edit");
    admin.setBounds(800, 400, 200, 100); 
admin.setBackground(new Color(102,102,0)); //transparent
    admin.setBorder(new LineBorder(new Color(102,51,0 ,0)));
    admin.setForeground(Color.black);
    admin.setFont(new Font("Arial" , Font.PLAIN, 22));
    admin.setFocusable(false);
    admin.addActionListener(this);
    


    //back
    back = new JButton();
   
        back.setBounds(1450, 750, 60, 60);
        back.addActionListener(this);
        back.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
        back.setBackground(new Color(0, 0, 0,0));
        back.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\Done-64-128px\\icons8-done-64.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    //title
    l = new JLabel("Welcome  . . . ");
  l.setBounds(500, 200, 500, 100);
  l.setBackground(new Color(0, 0, 0,0));
    l.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    l.setFont(new Font("Arial ", Font.PLAIN, 90));
    l.setForeground(Color.white);

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
        p.add(l);
        p.add(user);
        p.add(admin);
        p.add(back);
        panel.add(p);
        f.add(panel);
        //f.add(p);
         f.setVisible(true);
        f.setSize(1550, 860);


    }



public static void main(String[] args) throws IOException{
        new User();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back)
        {
            try {
                new HomePage();
                f.dispose();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
    }
}

