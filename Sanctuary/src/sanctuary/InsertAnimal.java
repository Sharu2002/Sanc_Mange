/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
        
public class InsertAnimal implements ActionListener{ 
     JFrame f ;
    JPanel p ;
    JButton inser;
    JLabel l , species , a_class,gender;
     String[] country;  
     
      PreparedStatement insert;
    Connection con;
    JComboBox cb;
     
    JTextField txt_class ,txt_species , txt_id;
    
    String i_gender,i_class,i_species;
    int i_id;
  
    private JDesktopPane panel;
    int hab_id;
    
    public InsertAnimal(int habi_id) throws IOException, ClassNotFoundException, SQLException{
        hab_id  = habi_id;
    f = new JFrame();
    
    country = new String[] {"Choose option","Male","Female"};        
     cb=new JComboBox(country);  
    cb.setBounds(300, 400, 300, 40);
    cb.setFont(new Font("Arial" , Font.PLAIN , 24));
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,220)); //transparent
    
    
    inser = new JButton("Insert");
    inser.setBounds(250, 500, 200, 50);
    inser.setBackground(new Color(153 , 153,0));
    inser.addActionListener(this);
    
    
    
    
    //title
    l = new JLabel("Animal Id");
    l.setBounds(50, 100, 200, 50);
    l.setBackground(new Color(0, 0, 0,0));
    l.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    l.setFont(new Font("Arial ", Font.PLAIN, 24));
    l.setForeground(Color.white);
    
     txt_id = new JTextField();
    txt_id.setBounds(300, 100, 300, 40);
   // txt_id.setBackground(new Color(0, 0);
    txt_id.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    txt_id.setFont(new Font("Arial ", Font.PLAIN, 24));
    txt_id.setForeground(Color.black);
    
      txt_id.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = txt_id.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               txt_id.setEditable(true);
              
            }
            else if(ke.getKeyCode() == 8)
                {
                     txt_id.setEditable(true);

                }
            else {
               txt_id.setEditable(false);
               JOptionPane.showMessageDialog(null, "Enter numbers");
            }
         }
      });
    
    
    species = new JLabel("Species");
    species.setBounds(50, 200, 200, 50);
    species.setBackground(new Color(0, 0, 0,0));
    species.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    species.setFont(new Font("Arial ", Font.PLAIN, 24));
    species.setForeground(Color.white);
    
    
     txt_species = new JTextField();
    txt_species.setBounds(300, 200, 300, 40);
    //txt_species.setBackground(new Color(0, 0, 0,0));
    txt_species.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    txt_species.setFont(new Font("Arial ", Font.PLAIN, 24));
    txt_species.setForeground(Color.black);
    
    a_class = new JLabel("Species");
    a_class.setBounds(50, 300, 200, 50);
    a_class.setBackground(new Color(0, 0, 0,0));
    a_class.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    a_class.setFont(new Font("Arial ", Font.PLAIN, 24));
    a_class.setForeground(Color.white);
    
    
    txt_class = new JTextField();
    txt_class.setBounds(300, 300, 300, 40);
    //txt_class.setBackground(new Color(0, 0, 0,0));
    txt_class.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    txt_class.setFont(new Font("Arial ", Font.PLAIN, 24));
    txt_class.setForeground(Color.black);
    
    gender = new JLabel("Species");
    gender.setBounds(50, 400, 200, 50);
    gender.setBackground(new Color(0, 0, 0,0));
    gender.setBorder(new LineBorder(new Color(0, 0, 0,0), 1));
    gender.setFont(new Font("Arial ", Font.PLAIN, 24));
    gender.setForeground(Color.white);

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
        p.add(species);
        p.add(a_class);
        p.add(gender);
        p.add(cb);
        p.add(txt_species);
        p.add(txt_class);
        p.add(txt_id);
        p.add(inser);
//        p.add(user);
//        p.add(admin);
        panel.add(p);
        f.add(panel);//f.add(p);
        f.setVisible(true);
        f.setSize(700, 650);
        
               

    }



    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
        {
            new InsertAnimal(1);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == inser)
            {
                i_id = Integer.parseInt(txt_id.getText());
                i_species = txt_species.getText();
                i_class = txt_class.getText();
                i_gender = cb.getSelectedItem().toString();
                
                  try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sancdata?useSSL=false" , "root" ,"Sharu#2022");
                
            insert =  con.prepareStatement("insert into animal values(?,?,?,?,?)");
            insert.setInt(1, i_id);
            insert.setInt(2, hab_id);
            insert.setString(3, i_species);
            insert.setString(4, i_class);
            insert.setString(5, i_gender);

            insert.executeUpdate();
         
new AnimalInsert(hab_id);
f.dispose();
           

        } catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        } catch (SQLException sQLException) {
            Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, sQLException);
        } catch (HeadlessException headlessException) {
        }       catch (IOException ex) {
                    Logger.getLogger(InsertAnimal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }
    }

