/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanctuary;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.sql.Connection;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sharu
 */
public class SancInsert implements ActionListener {
     JFrame f ;
    JPanel p ;
        JList l;
    PreparedStatement insert;
    Connection con;
        JScrollPane pane;
    JLabel title;
    
    JButton btn_add ,  btn_remove , btn_edit;
     JLabel lbl_addsongs ,lbl_removesongs;
     
     int sanc_id;
    
    private JDesktopPane panel;
public SancInsert() throws IOException{
    
    btn_add = new JButton();
    btn_remove = new JButton();
    lbl_removesongs = new JLabel();
    lbl_addsongs = new JLabel();
    
      //list
            l = new JList();
    //database connection
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sancdata?useSSL=false" , "root" ,"Sharu#2022");
                
            insert = con.prepareStatement("select * from sanctuary");

            java.sql.ResultSet rs = insert.executeQuery();
         

            DefaultListModel Df = new DefaultListModel();

            while (rs.next()) {
               
                String song = rs.getString("sanctuary_name");
                Df.addElement(song);

            }
            l.setModel(Df);

        } catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        } catch (SQLException sQLException) {
            Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, sQLException);
        } catch (HeadlessException headlessException) {
        }
            
        l.setDragEnabled(true);
        l.setFixedCellHeight(60);

        l.setFont(new Font("Arial", Font.PLAIN, 21));
        l.setVisibleRowCount(4);
        l.setForeground(Color.white);
        l.setSelectionBackground(Color.darkGray);
        l.setSelectionForeground(Color.cyan);

        l.setBackground(Color.black);
        pane = new JScrollPane(l);
        pane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane.setBackground(Color.black);
        pane.setBounds(150, 130, 920, 340);
        pane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
        
        @Override
            
        protected void configureScrollBarColors() 
        {
                this.thumbColor = Color.gray;
        }

        });
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
        pane.setBorder(new LineBorder(Color.DARK_GRAY, 1));
    
    f = new JFrame();
    
    
    //buttons and labels
    
    lbl_addsongs = new JLabel("Add Sanctuaries");
        lbl_addsongs.setBounds(830, 400, 220, 50);
        lbl_addsongs.setBackground(Color.white);
        lbl_addsongs.setBorder(new LineBorder(Color.black, 1));
        lbl_addsongs.setFont(new Font("Arial ", Font.PLAIN, 22));
        lbl_addsongs.setForeground(Color.white);

        btn_add = new JButton();
        btn_add.setBounds(760, 500, 60, 60);
        btn_add.addActionListener(this);
        btn_add.setBorder(new LineBorder(Color.black, 1));
        btn_add.setBackground(Color.BLACK);
        btn_add.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\Done-64-128px\\icons8-done-64.png"));
        btn_add.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn_remove = new JButton();
        btn_remove.setBounds(420, 500, 60, 60);
        btn_remove.addActionListener(this);
        btn_remove.setBorder(new LineBorder(Color.black, 1));
        btn_remove.setBackground(Color.BLACK);
        btn_remove.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\circle-minus-solid.svg"));
        btn_remove.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn_edit = new JButton();
         btn_edit.setBounds(800, 500, 60, 60);
        btn_edit.addActionListener(this);
        btn_edit.setBorder(new LineBorder(Color.black, 1));
        btn_edit.setBackground(Color.BLACK);
        btn_edit.setIcon(new javax.swing.ImageIcon("D:\\Downloads\\Remove-32-64px\\icons8-remove-32.png"));
        btn_edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        lbl_removesongs = new JLabel("Remove Sanctuaries");
        lbl_removesongs.setBounds(500, 500, 220, 50);
        lbl_removesongs.setBackground(Color.black);
        lbl_removesongs.setBorder(new LineBorder(Color.black, 1));
        lbl_removesongs.setFont(new Font("Arial ", Font.PLAIN, 22));
        lbl_removesongs.setForeground(Color.white);

    
    //panel
    p = new JPanel();
    p.setBounds(1, 1, 1549, 859);
    p.setVisible(true);
    p.setLayout(null);
    p.setBackground(new Color(0, 0, 0,150)); //transparent
    
  //title
  
  title = new JLabel("SANCTUARIES");
  title.setForeground(Color.white);
  title.setFont(new Font("Arial" , Font.BOLD , 60));
  title.setBounds(290,20,900,100);
  title.setBackground(new Color(0,0,0));

    
    
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
        p.add(title);
        p.add(pane);
//        p.add(btn_add);
//        p.add(btn_remove);
//        p.add(lbl_removesongs);
//        p.add(lbl_addsongs);
       
        panel.add(p);
        
        f.add(panel);
        //f.add(p);
       // f.add(pane);
         f.setVisible(true);
        f.setSize(1250, 650);
 l.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                try {
                    //                String sanc = (String)l.getSelectedValue();
//                System.out.println(sanc);
//                
//                try {
//                    insert = con.prepareStatement("select sanctuary_id from sanctuary where sanctuary_name = ?");
//                insert.setString(1, sanc);
//                 java.sql.ResultSet rs = insert.executeQuery();
//                } catch (SQLException ex) {
//                    Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, ex);
//                }
lValueChanged(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SancInsert.class.getName()).log(Level.SEVERE, null, ex);
                }
  

            }

        });

    }


  private void lValueChanged(javax.swing.event.ListSelectionEvent evt) throws SQLException, IOException, ClassNotFoundException 
  {
         Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sancdata?useSSL=false" , "root" ,"Sharu#2022");
      
        String selectedElement = (String) l.getSelectedValue();
        
        insert = con.prepareStatement("select * from sanctuary where sanctuary_name =?");
        
        insert.setString(1, selectedElement);
        
        java.sql.ResultSet rs = insert.executeQuery();
     
        while(rs.next())
        {sanc_id  = rs.getInt("sanctuary_id");
        System.out.println(sanc_id);
        }
        
        new HabitatInsert(sanc_id);
            f.dispose();

  }

public static void main(String[] args) throws IOException
    {
        new SancInsert();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
