/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanctuary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author sharu
 */
public class ViewAnimal implements ActionListener {
        
//create view species_n_feed as
//select species , gender,class , feed_name from animal left join feed on feed.animal_id = animal.animal_id;


      JFrame f ;
    JPanel p ;
        JList l;
    PreparedStatement insert;
    Connection con;
        JScrollPane pane;
    JLabel title;
    
    JButton hab;
    
    JButton btn_add ,  btn_remove , btn_edit;
     JLabel lbl_addsongs ,lbl_removesongs;
     
     JLabel lbl_cap ,lbl_name,lbl_loc , lbl_type;
    JLabel d_id , d_time , d_loc;
     
     int sanc_id;
     
     
     JPanel p1;
     
     
     String id , time, loc;
    
    private JDesktopPane panel;
public ViewAnimal(int id) throws IOException{
   
  sanc_id = id;
    
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
                
            insert = con.prepareStatement("select species from animal where habitat_id =? group by species");
            insert.setInt(1, sanc_id);
            java.sql.ResultSet rs = insert.executeQuery();
         

            DefaultListModel Df = new DefaultListModel();

            while (rs.next()) {
               
                String song = rs.getString("species");
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
        
        
        
          lbl_cap = new JLabel("Gender");
    lbl_cap.setBounds(10, 10, 400, 20);
//        lbl_id.setBackground(Color.white);
        lbl_cap.setBorder(new LineBorder(Color.black, 1));
        lbl_cap.setFont(new Font("Arial ", Font.PLAIN, 18));
        lbl_cap.setForeground(Color.WHITE);
        
        d_id = new JLabel();
       // d_id.setText(id);
    d_id.setBounds(70, 50, 400, 30);
//        lbl_id.setBackground(Color.white);
        d_id.setBorder(new LineBorder(Color.black, 1));
        d_id.setFont(new Font("Arial ", Font.BOLD, 20));
        d_id.setForeground(Color.RED.brighter().brighter().brighter().brighter().brighter());
        
        
                  lbl_name = new JLabel("Class");
    lbl_name.setBounds(10, 110, 200, 20);
//        lbl_id.setBackground(Color.white);
        lbl_name.setBorder(new LineBorder(Color.black, 1));
        lbl_name.setFont(new Font("Arial ", Font.PLAIN, 18));
        lbl_name.setForeground(Color.WHITE);
        
                d_time = new JLabel();
        d_time.setText(time);
    d_time.setBounds(70, 150, 400, 30);
//        lbl_id.setBackground(Color.white);
        d_time.setBorder(new LineBorder(Color.black, 1));
        d_time.setFont(new Font("Arial ", Font.BOLD, 20));
        d_time.setForeground(Color.RED.brighter().brighter().brighter().brighter().brighter());
        
        
                          lbl_loc = new JLabel("Feed");
    lbl_loc.setBounds(10, 210, 200, 20);
//        lbl_id.setBackground(Color.white);
        lbl_loc.setBorder(new LineBorder(Color.black, 1));
        lbl_loc.setFont(new Font("Arial ", Font.PLAIN, 18));
        lbl_loc.setForeground(Color.WHITE);
        
      d_loc = new JLabel();
        d_loc.setText(time);
    d_loc.setBounds(70, 250, 400, 30);
//        lbl_id.setBackground(Color.white);
        d_loc.setBorder(new LineBorder(Color.black, 1));
        d_loc.setFont(new Font("Arial ", Font.BOLD, 20));
        d_loc.setForeground(Color.RED.brighter().brighter().brighter().brighter().brighter());
          
       
    
    p1 = new JPanel();
    p1.setBounds(670 , 130 , 500 , 370);
    p1.setLayout(null);
    p1.setBackground(new Color(0, 0, 0)); //transparent);
    
    p1.add(lbl_name);
//    p1.add(lbl_type);
        p1.add(lbl_loc);
        p1.add(lbl_cap);
        p1.add(d_id);
        p1.add(d_time);
        p1.add(d_loc);
//        
        
        
        pane = new JScrollPane(l);
        pane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane.setBackground(Color.black);
        pane.setBounds(100, 130, 500, 370);
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
  
  title = new JLabel("ANIMALS");
  title.setForeground(Color.white);
  title.setFont(new Font("Arial" , Font.BOLD , 60));
  title.setBounds(290,20,900,100);
  title.setBackground(new Color(0,0,0));

         hab = new JButton("Animals");
        hab.setBounds(250, 510, 200, 70);
      hab.setBackground(Color.ORANGE.brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter());
      hab.setFont(new Font("Arial" , Font.BOLD , 20));
      hab.setForeground(Color.black);
    
    
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
        panel.add(p1);
        //  panel.add(hab);
        
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
        
        insert = con.prepareStatement("select * from species_n_feed where species =?");
        
        insert.setString(1, selectedElement);
        
        java.sql.ResultSet rs = insert.executeQuery();
     
        while(rs.next())
        {
            //sanc_id = rs.getInt("habitat_id");
            
            id  = rs.getString("gender");
        time = rs.getString("class");
        loc = rs.getString("feed_name");
        
          d_id.setText(id);
          d_time.setText(time);
          d_loc.setText(loc);
        System.out.println(id);
        }
        
        hab.addActionListener(this);
        
        

  }

public static void main(String[] args) throws IOException
    {
        new ViewSanc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == hab)
        {
            
//            new ViewAnimal(sanc_id);
//            f.dispose();
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
