/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanctuary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author sharu
 */
public class EditAnimal implements ActionListener{
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
    int hab_id,f_id;
    
    public EditAnimal(int fid ,int habi_id , String s , String g ,String c) throws IOException, ClassNotFoundException, SQLException{
        hab_id  = habi_id;
        f_id = fid;
    f = new JFrame();
    
    country = new String[] {"Choose option","Male","Female"};        
     cb=new JComboBox(country);  
    cb.setBounds(300, 400, 300, 40);
    cb.setFont(new Font("Arial" , Font.PLAIN , 24));
    if(g.equals("Male"))
    {
        cb.setSelectedIndex(1);
    }
    else
    {
        cb.setSelectedIndex(2);
    }
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,220)); //transparent
    
    
    inser = new JButton("Update");
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
    txt_id.setText(Integer.toString(hab_id));
    txt_id.setEditable(false);
    
 
    
    
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
    txt_species.setText(s);
    
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
    txt_class.setText(c);
    
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
               
                
                  try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sancdata?useSSL=false" , "root" ,"Sharu#2022");
                
            insert =  con.prepareStatement("update animal set species =? , class = ? , gender =? where animal_id=?");
            insert.setString(1, txt_species.getText());
            insert.setString(2, txt_class.getText());
            insert.setString(3, cb.getSelectedItem().toString());
            insert.setInt(4, Integer.parseInt(txt_id.getText()));
     

            insert.executeUpdate();
         
new AnimalInsert(f_id);
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
