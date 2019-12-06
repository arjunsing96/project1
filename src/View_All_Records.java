
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View_All_Records {

	private JFrame frame;
	private JTable table;
	JLabel lblNo;
	JComboBox comboBox;
	JButton btnSearch;
	
	
	JLabel lblNewLabel_1;
	JLabel lblNewLabel;
	JScrollPane scrollPane;

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	String searchby="";
	private JTextField textField;
	 public View_All_Records() {
		 initialize();
	        conn = Food_conn.food_connection();
	        total_found();
	    }
	   
	    public void total_found(){
	        try{
	            String sql = "select count(type) from foods";
	            pst=conn.prepareStatement(sql);
	            rs=pst.executeQuery();
                while(rs.next()){
	                String total = rs.getString("count(type)");
	                lblNo.setText(String.valueOf(total));
	            }
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null, e);
	        }
	        }
	   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	               UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
	            }
	        } catch (ClassNotFoundException ex) {
	        	System.out.print(ex);
	        	
	        } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_All_Records window = new View_All_Records();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(" ");
		frame.setBounds(100, 100, 586, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Total Found");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 84, 21);
		frame.getContentPane().add(lblNewLabel);
		
	    lblNo = new JLabel("");
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNo.setBounds(104, 14, 23, 14);
		frame.getContentPane().add(lblNo);
		
		lblNewLabel_1 = new JLabel("Search By");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(149, 14, 76, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
	    comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rice", "Grilled", "Fast Food", "Others", "Drinks"}));
		comboBox.setBounds(228, 13, 117, 20);
		frame.getContentPane().add(comboBox);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(471, 12, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 43, 540, 269);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
         table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		

	        btnSearch.setText("Search");
	        btnSearch.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnSearchActionPerformed(evt);
	            }
	        });

	       
	}

private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(comboBox.getSelectedIndex()==0){
       try{
           String sql = "select type,price,quantity,amount from rice";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }else if(comboBox.getSelectedIndex()==1){
          try{
           String sql = "select type,price,quantity,amount from grilled";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }else if(comboBox.getSelectedIndex()==2){
          try{
           String sql = "select type,price,quantity,amount from fast_food";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }else if(comboBox.getSelectedIndex()==3){
          try{
           String sql = "select type,price,quantity,amount from others";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }else if(comboBox.getSelectedIndex()==4){
          try{
           String sql = "select type,price,quantity,amount from drinks";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }
    try{
     String sql = "select type,price,quantity,amount from foods where ";
 }catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
 }finally{
         try{
             pst.close();
             rs.close();
         }catch(Exception e){
             
         }
     }
}
}