/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sanctuary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
        
public class HomePage implements ActionListener{ 
    JFrame f ;
    JPanel p ;
    JButton user , admin;
    JLabel l;
  
    private JDesktopPane panel;
    
    public HomePage() throws IOException{
    f = new JFrame();
    
    
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,150)); //transparent
    
    //user
    user = new JButton("User");
    user.setBounds(400, 400, 200, 100); 
    user.setBackground(new Color(102,102,0)); //transparent
    user.setForeground(Color.black);
    user.setFont(new Font("Arial" , Font.PLAIN, 22));
    user.setFocusable(false);
    user.addActionListener(this);
    user.setBorder(new LineBorder(new Color(102,51,0 ,0)));
   
    //admin 
    admin = new JButton("Admin");
    admin.setBounds(500, 400, 200, 100); 
    admin.setBackground(new Color(102,102,0)); //transparent
    admin.setForeground(Color.black);
    admin.setFont(new Font("Arial" , Font.PLAIN, 22));
    admin.setFocusable(false);
    admin.addActionListener(this);
    admin.setBorder(new LineBorder(new Color(102,51,0,0)));

    
    //title
    l = new JLabel("Wild life Sanctuary Management");
    l.setBounds(50, 200, 1450, 100);
    l.setBackground(new Color(0, 0, 0,0));
    l.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    l.setFont(new Font("Arial ", Font.PLAIN, 80));
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
      //  p.add(user);
        p.add(admin);
        panel.add(p);
        f.add(panel);//f.add(p);
        f.setVisible(true);
        f.setSize(1250, 650);
        
               

    }



    public static void main(String[] args) throws IOException
        {
            new HomePage();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == user)
            {
                try 
                {

                    new User();
                    f.dispose();
                } catch (IOException ex) 
                {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(e.getSource() == admin)
            {
                try 
                {
                    new admin();
                    f.dispose();
                } catch (IOException ex) 
                {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }
    }

