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
public class AdminSelect implements ActionListener{ 
    JFrame f ;
    JPanel p ;
    JButton user , admin , back , sanc;
    JLabel l;
    private JDesktopPane panel;
public AdminSelect() throws IOException{
    f = new JFrame();
    
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,150)); //transparent
    
    //user
    user = new JButton("Employees");
    user.setBounds(150, 400, 200, 100); 
   
    user.setForeground(Color.black);
    user.setFont(new Font("Arial" , Font.PLAIN, 22));
    user.setFocusable(false);
    user.addActionListener(this); 
    user.setBackground(new Color(102,102,0)); //transparent
    user.setBorder(new LineBorder(new Color(102,51,0 ,0)));

    
    //admin
    
    admin = new JButton("Visitors");
    admin.setBounds(450, 400, 200, 100); 
    admin.setBackground(new Color(102,102,0)); //transparent
    admin.setForeground(Color.black);
    admin.setFont(new Font("Arial" , Font.PLAIN, 22));
    admin.setFocusable(false);
    admin.addActionListener(this);
        admin.setBorder(new LineBorder(new Color(102,51,0 ,0)));
        
        sanc = new JButton("Sanctuary");
    sanc.setBounds(450, 400, 200, 100); 
    sanc.setBackground(new Color(102,102,0)); //transparent
    sanc.setForeground(Color.black);
    sanc.setFont(new Font("Arial" , Font.PLAIN, 22));
    sanc.setFocusable(false);
    sanc.addActionListener(this);
        sanc.setBorder(new LineBorder(new Color(102,51,0 ,0)));

//back
 back = new JButton();
   
        back.setBounds(1150, 550, 60, 60);
        back.addActionListener(this);
        back.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
        back.setBackground(new Color(0, 0, 0,0));
        back.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\Done-64-128px\\icons8-done-64.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    
    //title
    l = new JLabel("ADMIN");
    l.setBounds(400, 200, 300, 100);
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
//        p.add(user);
//        p.add(admin);
        p.add(sanc);
        p.add(back);
        panel.add(p);
        f.add(panel);
        //f.add(p);
         f.setVisible(true);
        f.setSize(1250, 650);


    }



public static void main(String[] args) throws IOException{
        new AdminSelect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back)
        {
            try {
                new HomePage();
                f.dispose();
            } catch (IOException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == admin){
            try {
                new AdminSelect();
                f.dispose();
            } catch (IOException ex) {
                Logger.getLogger(AdminSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
        if(e.getSource()==sanc)
        {
            try {
                new SancInsert();
            } catch (IOException ex) {
                Logger.getLogger(AdminSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.dispose();
        }
    }
}


