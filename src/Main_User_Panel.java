import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;

public class Main_User_Panel {

	private JFrame frmFood;
	private JTextField textField_friedRice_quan;
	private JTextField textField_plainRice_quan;
	private JTextField textField_friedRice_amt;
	private JTextField textField_plainRice_amt;
	private JTextField textField_burger_quan;
	private JTextField textField_salad_quan;
	private JTextField textField_burger_amt;
	private JTextField textField_salad_amt;
	private JTextField textField_sandwich_quan;
	private JTextField textField_potato_quan;
	private JTextField textField_sandwich_amt;
	private JTextField textField_potato_amt;
	private JTextField textField_pizza_quan;
	private JTextField textField_momos_quan;
	private JTextField textField_pizza_amt;
	private JTextField textField_momos_amt;
	private JTextField textField_pavBhaji_quan;
	private JTextField textField_pavVada_quan;
	private JTextField textField_pavBhaji_amt;
	private JTextField textField_pavVada_amt;
	private JTextField textField_dosa_quan;
	private JTextField textField_dosa_amt;
	private JTextField textField_mountainDew_quan;
	private JTextField textField_pepsi_quan;
	private JTextField textField_mountainDew_amt;
	private JTextField textField_pepsi_amt;
	private JTextField textField_cocaCola_quan;
	private JTextField textField_tea_quan;
	private JTextField textField_cocaCola_amt;
	private JTextField textField_tea_amt;
	private JTextField textField_coffee_quan;
	private JTextField textField_mineralWater_quan;
	private JTextField textField_coffee_amt;
	private JTextField textField_mineralWater_amt;
	private JTextField textField_customerCash;
	private JTextField textField_change;
	private JTextField textField_total;
	
	
	JLabel lblRice;
	JLabel lblFriedRice;
	JCheckBox checkBox_fried_rice;
	JLabel lblPlainRice;
	JCheckBox checkBox_plain_rice;
	JLabel lblGrilled;
	
	JLabel lblBurger;
	JLabel lblSalad;
	JCheckBox checkBox_burger;
	JCheckBox checkBox_salad;
	JLabel lblSandwich;
	JLabel lblPotato;
	JCheckBox checkBox_sandwich;
	JCheckBox checkBox_potato;
	JLabel lblFastFood;
	JLabel lblMomos;
	JLabel lblPizza;
	JCheckBox checkBox_pizza;
	JCheckBox checkBox_momos;
	JLabel lblPavBhaji;
	JLabel lblPavVada;
	JCheckBox checkBox_pav_bhaji;
	JCheckBox checkBox_pav_vada;
	JLabel lblDosa;
	JCheckBox checkBox_dosa;
	
	JLabel lblDrinks;
	JLabel lblMountain;
	JLabel lblPepsi;
	JCheckBox checkBox_mountain_dew;
	JCheckBox checkBox_pepsi;
	JLabel lblCoca;
	JLabel lblTea;
	JCheckBox checkBox_coca_cola;
	JCheckBox checkBox_tea;
	JLabel lblCoffee;
	JLabel lblMineralWater;
	JCheckBox checkBox_coffee;
	JCheckBox checkBox_mineral_water;

	
	
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	static int id; 
	static String last_id;


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
					Main_User_Panel window = new Main_User_Panel();
					window.frmFood.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_User_Panel() {
		initialize();
     conn = Food_conn.food_connection();
     get_last_id();
 

	}
	  public void get_last_id(){
	        try{
	            String sql = "select id from foods order by id";
	            pst=conn.prepareStatement(sql);
	            rs=pst.executeQuery();
	            if(rs.next()){
	                 last_id = rs.getString("id");
	                 
	                int getid = Integer.parseInt(last_id);
	                id = getid+1;
	               
	            }else{
	                id = 1;
	            }
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
	  	  public void clear()
	  	{
		       checkBox_fried_rice.setSelected(false);   
		       checkBox_plain_rice.setSelected(false);  
		       checkBox_burger.setSelected(false); 
		       checkBox_salad.setSelected(false);   
		       checkBox_sandwich.setSelected(false);   
		       checkBox_potato.setSelected(false);   
		       checkBox_pizza.setSelected(false);   
		       checkBox_momos.setSelected(false);  
		       checkBox_pav_bhaji.setSelected(false);
		       checkBox_pav_vada.setSelected(false);  
		       checkBox_dosa.setSelected(false); 
		       checkBox_mountain_dew.setSelected(false); 
		       checkBox_pepsi.setSelected(false);
		       checkBox_coca_cola.setSelected(false);
		       checkBox_tea.setSelected(false);   
		       checkBox_coffee.setSelected(false);  
		       checkBox_mineral_water.setSelected(false);   
		       textField_total.setText(null);
		       textField_customerCash.setText(null);
		       textField_change.setText(null);
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()   {
		frmFood = new JFrame();
		frmFood.setTitle("Canteen");
		frmFood.setBounds(100, 100, 1044, 661);
		frmFood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFood.getContentPane().setLayout(null);
		frmFood.setLocationRelativeTo(null);
		
		JPanel panel_rice = new JPanel();
		panel_rice.setBounds(10, 70, 454, 95);
		frmFood.getContentPane().add(panel_rice);
		panel_rice.setLayout(null);
		
	    lblRice = new JLabel("Rice");
		lblRice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRice.setForeground(Color.RED);
		lblRice.setBounds(0, 0, 46, 14);
		panel_rice.add(lblRice);
		
	    lblFriedRice = new JLabel("Fried Rice");
		lblFriedRice.setBounds(0, 30, 60, 14);
		panel_rice.add(lblFriedRice);
		
		lblPlainRice = new JLabel("Plain Rice");
		lblPlainRice.setBounds(0, 65, 60, 14);
		panel_rice.add(lblPlainRice);
		
	    checkBox_fried_rice = new JCheckBox("25.00");
		checkBox_fried_rice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_friedRice_quan.setText("");
					textField_friedRice_amt.setText("");
					textField_friedRice_quan.setEnabled(false);
					textField_friedRice_quan.setEditable(true);	

				}
				else
				{
					textField_friedRice_quan.setEditable(true);	
					textField_friedRice_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_fried_rice.setBounds(66, 26, 60, 23);
		panel_rice.add(checkBox_fried_rice);
		
		checkBox_plain_rice = new JCheckBox("15.00");
		
		checkBox_plain_rice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_plainRice_quan.setText("");
					textField_plainRice_amt.setText("");
					textField_plainRice_quan.setEnabled(false);
					textField_plainRice_quan.setEditable(true);	

				}
				else
				{
					textField_plainRice_quan.setEditable(true);	
					textField_plainRice_quan.setEnabled(true);

				}
			}
		});

		checkBox_plain_rice.setBounds(66, 61, 60, 23);
		panel_rice.add(checkBox_plain_rice);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setBounds(144, 30, 50, 14);
		panel_rice.add(lblNewLabel);
		
		JLabel label = new JLabel("Quantity");
		label.setBounds(144, 70, 50, 14);
		panel_rice.add(label);
		
		textField_friedRice_quan = 
				new JTextField();
		textField_friedRice_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_friedRice_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_friedRice_quan.setText(null);
					textField_friedRice_amt.setText(null);

				}
				else
				{
					if(textField_friedRice_quan.getText().equals(""))
					{
						   textField_friedRice_amt.setText("");
						   textField_friedRice_amt.setEditable(true);
						   textField_friedRice_amt.setEnabled(false);


					}
					else
					{
						try
						{
							   double quan = Integer.parseInt(textField_friedRice_quan.getText());
							   double amt = quan * 25.0;
							   textField_friedRice_amt.setEnabled(true);
							   textField_friedRice_quan.setEnabled(true);
							   textField_friedRice_amt.setEditable(false);
							   textField_friedRice_amt.setText(String.valueOf(amt));
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
							
							textField_friedRice_quan.setText(null);
							textField_friedRice_amt.setText(null);
						}
						  
					} 

				}

							
			}
		});
		
		
		textField_friedRice_quan.setEnabled(false);
		textField_friedRice_quan.setBounds(193, 27, 86, 20);
		panel_rice.add(textField_friedRice_quan);
		textField_friedRice_quan.setColumns(10);
		
		textField_plainRice_quan = new JTextField();
		textField_plainRice_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
			    if(textField_plainRice_quan.getText().length()>3)
			    {
			    	JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
			    	textField_plainRice_quan.setText(null);
			    	textField_plainRice_amt.setText(null);
			    }
			    else
			    {
					if(textField_plainRice_quan.getText().equals(""))
					{
						textField_plainRice_amt.setText("");
						textField_plainRice_amt.setEditable(true);
						textField_plainRice_amt.setEnabled(false);


					}
					else
					{
						try
						{
							double quan = Integer.parseInt(textField_plainRice_quan.getText());
							double amt = quan * 15.0;
							textField_plainRice_amt.setEnabled(true);
							textField_plainRice_quan.setEnabled(true);
							textField_plainRice_amt.setEditable(false);
							textField_plainRice_amt.setText(String.valueOf(amt));
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
							
							textField_plainRice_quan.setText(null);
							textField_plainRice_amt.setText(null);
						}
					}
			    }
			}
		});
		textField_plainRice_quan.setEnabled(false);
		textField_plainRice_quan.setColumns(10);
		textField_plainRice_quan.setBounds(193, 67, 86, 20);
		panel_rice.add(textField_plainRice_quan);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(307, 30, 46, 14);
		panel_rice.add(lblAmount);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setBounds(307, 70, 46, 14);
		panel_rice.add(lblAmount_1);
		
		textField_friedRice_amt = new JTextField();
		textField_friedRice_amt.setEnabled(false);
		textField_friedRice_amt.setForeground(new Color(0, 0, 0));
		textField_friedRice_amt.setColumns(10);
		textField_friedRice_amt.setBounds(358, 27, 86, 20);
		panel_rice.add(textField_friedRice_amt);
		
		textField_plainRice_amt = new JTextField();
		textField_plainRice_amt.setEnabled(false);
		textField_plainRice_amt.setBounds(358, 62, 86, 20);
		panel_rice.add(textField_plainRice_amt);
		textField_plainRice_amt.setColumns(10);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to  Modern Canteen\r\n");
		lblWelcomeTo.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
		lblWelcomeTo.setBounds(317, 11, 312, 31);
		frmFood.getContentPane().add(lblWelcomeTo);
		
		JLabel lblChooseYourOrder = new JLabel("Choose Your Order");
		lblChooseYourOrder.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 15));
		lblChooseYourOrder.setBounds(362, 41, 256, 22);
		frmFood.getContentPane().add(lblChooseYourOrder);

		JPanel panel_grilled = new JPanel();
		panel_grilled.setLayout(null);
		panel_grilled.setBounds(10, 201, 454, 194);
		frmFood.getContentPane().add(panel_grilled);
		
		lblGrilled = new JLabel("Grilled");
		lblGrilled.setForeground(Color.RED);
		lblGrilled.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGrilled.setBounds(0, 0, 46, 14);
		panel_grilled.add(lblGrilled);
		
		lblBurger = new JLabel("Burger");
		lblBurger.setBounds(10, 30, 60, 14);
		panel_grilled.add(lblBurger);
		
		lblSalad = new JLabel("Salad");
		lblSalad.setBounds(10, 70, 60, 14);
		panel_grilled.add(lblSalad);
		
		checkBox_burger = new JCheckBox("85.00");
		
		checkBox_burger.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_burger_quan.setText("");
					textField_burger_amt.setText("");
					textField_burger_quan.setEnabled(false);
					textField_burger_quan.setEditable(true);	

				}
				else
				{
					textField_burger_quan.setEditable(true);	
					textField_burger_quan.setEnabled(true);

				}
			}
		});

		checkBox_burger.setBounds(66, 26, 60, 23);
		panel_grilled.add(checkBox_burger);
		
		checkBox_salad = new JCheckBox("120.00");
		checkBox_salad.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_salad_quan.setText("");
					textField_salad_amt.setText("");
					textField_salad_quan.setEnabled(false);
					textField_salad_quan.setEditable(true);	

				}
				else
				{
					textField_salad_quan.setEditable(true);	
					textField_salad_quan.setEnabled(true);

				}
			}
		});

		checkBox_salad.setBounds(66, 61, 65, 23);
		panel_grilled.add(checkBox_salad);
		
		JLabel label_4 = new JLabel("Quantity");
		label_4.setBounds(144, 30, 50, 14);
		panel_grilled.add(label_4);
		
		JLabel label_5 = new JLabel("Quantity");
		label_5.setBounds(144, 70, 50, 14);
		panel_grilled.add(label_5);
		
		textField_burger_quan = new JTextField();
	    textField_burger_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_burger_quan.getText().equals(""))
				{
					textField_burger_amt.setText("");
					textField_burger_amt.setEditable(true);
					textField_burger_amt.setEnabled(false);


				}
				else
				{
				   double quan = Integer.parseInt(textField_burger_quan.getText());
				   double amt = quan * 85.0;
				   textField_burger_amt.setEnabled(true);
				   textField_burger_quan.setEnabled(true);
				   textField_burger_amt.setEditable(false);
				   textField_burger_amt.setText(String.valueOf(amt));
				}
			}
		});

		textField_burger_quan.setEnabled(false);
		textField_burger_quan.setColumns(10);
		textField_burger_quan.setBounds(193, 27, 86, 20);
		panel_grilled.add(textField_burger_quan);
		
		textField_salad_quan = new JTextField();
		textField_salad_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_salad_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_salad_quan.setText(null);
					textField_salad_amt.setText(null);

				}
				else
				{
					 if(textField_salad_quan.getText().equals(""))
					 {
						textField_salad_amt.setText("");
						textField_salad_amt.setEditable(true);
						textField_salad_amt.setEnabled(false);
	
	
    				 }
					 else
					 {
						   try
						   {
							   double quan = Integer.parseInt(textField_salad_quan.getText());
							   double amt = quan * 120.0;
							   textField_salad_amt.setEnabled(true);
							   textField_salad_quan.setEnabled(true);
							   textField_salad_amt.setEditable(false);
							   textField_salad_amt.setText(String.valueOf(amt));
						   }
						   catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								
								textField_salad_quan.setText(null);
								textField_salad_amt.setText(null);
							}
				  	 }
			     }
			}
		});

		textField_salad_quan.setEnabled(false);
		textField_salad_quan.setColumns(10);
		textField_salad_quan.setBounds(193, 67, 86, 20);
		panel_grilled.add(textField_salad_quan);
		
		JLabel label_6 = new JLabel("Amount");
		label_6.setBounds(307, 30, 46, 14);
		panel_grilled.add(label_6);
		
		JLabel label_7 = new JLabel("Amount");
		label_7.setBounds(307, 70, 46, 14);
		panel_grilled.add(label_7);
		
		textField_burger_amt = new JTextField();
		textField_burger_amt.setEnabled(false);
		textField_burger_amt.setColumns(10);
		textField_burger_amt.setBounds(358, 27, 86, 20);
		panel_grilled.add(textField_burger_amt);
		
		textField_salad_amt = new JTextField();
		textField_salad_amt.setEnabled(false);
		textField_salad_amt.setColumns(10);
		textField_salad_amt.setBounds(358, 62, 86, 20);
		panel_grilled.add(textField_salad_amt);
		
	    lblSandwich = new JLabel("Sandwich");
		lblSandwich.setBounds(10, 104, 60, 14);
		panel_grilled.add(lblSandwich);
		
		lblPotato = new JLabel("Potato");
		lblPotato.setBounds(10, 144, 60, 14);
		panel_grilled.add(lblPotato);
		
		checkBox_sandwich = new JCheckBox("100.00");
		checkBox_sandwich.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_sandwich_quan.setText("");
					textField_sandwich_amt.setText("");
					textField_sandwich_quan.setEnabled(false);
					textField_sandwich_quan.setEditable(true);	

				}
				else
				{
					textField_sandwich_quan.setEditable(true);	
					textField_sandwich_quan.setEnabled(true);

				}
			}
		});

		checkBox_sandwich.setBounds(66, 100, 65, 23);
		panel_grilled.add(checkBox_sandwich);
		
		checkBox_potato = new JCheckBox("125.00");
		checkBox_potato.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_potato_quan.setText("");
					textField_potato_amt.setText("");
					textField_potato_quan.setEnabled(false);
					textField_potato_quan.setEditable(true);	

				}
				else
				{
					textField_potato_quan.setEditable(true);	
					textField_potato_quan.setEnabled(true);

				}
			}
		});

		checkBox_potato.setBounds(66, 140, 65, 23);
		panel_grilled.add(checkBox_potato);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setBounds(144, 104, 50, 14);
		panel_grilled.add(label_2);
		
		JLabel label_3 = new JLabel("Quantity");
		label_3.setBounds(144, 144, 50, 14);
		panel_grilled.add(label_3);
		
		textField_sandwich_quan = new JTextField();
		
		textField_sandwich_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				 if(textField_sandwich_quan.getText().length()>3)
				 {
						JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
						textField_sandwich_quan.setText(null);
						textField_sandwich_amt.setText(null);
				 }
						if(		textField_sandwich_quan.getText().equals(""))
						{
							textField_sandwich_amt.setText("");
							textField_sandwich_amt.setEditable(true);
							textField_sandwich_amt.setEnabled(false);
		
		
						}
						else
						{
							   try
							   {
								    double quan = Integer.parseInt(textField_sandwich_quan.getText());
								    double amt = quan * 100.0;
								    textField_sandwich_amt.setEnabled(true);
									textField_sandwich_quan.setEnabled(true);
									textField_sandwich_amt.setEditable(false);
									textField_sandwich_amt.setText(String.valueOf(amt));
							   }
							   catch(Exception e)
								{
									JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
									
									textField_sandwich_quan.setText(null);
									textField_sandwich_amt.setText(null);
								}
						}
			}
		});

		
		textField_sandwich_quan.setEnabled(false);
		textField_sandwich_quan.setColumns(10);
		textField_sandwich_quan.setBounds(193, 101, 86, 20);
		panel_grilled.add(textField_sandwich_quan);
		
		textField_potato_quan = new JTextField();
		textField_potato_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_potato_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_potato_quan.setText(null);
					textField_potato_amt.setText(null);

				}
				else
				{	
					    if(textField_potato_quan.getText().equals(""))
						{
							textField_potato_amt.setText("");
							textField_potato_amt.setEditable(true);
							textField_potato_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
							    double quan = Integer.parseInt(textField_potato_quan.getText());
							    double amt = quan * 125.0;
							    textField_potato_amt.setEnabled(true);
							    textField_potato_quan.setEnabled(true);
							    textField_potato_amt.setEditable(false);
							    textField_potato_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_potato_quan.setText(null);
								textField_potato_amt.setText(null);
							}

						}
				}
			}
		});

		textField_potato_quan.setEnabled(false);
		textField_potato_quan.setColumns(10);
		textField_potato_quan.setBounds(193, 141, 86, 20);
		panel_grilled.add(textField_potato_quan);
		
		textField_sandwich_amt = new JTextField();
		textField_sandwich_amt.setEnabled(false);
		textField_sandwich_amt.setColumns(10);
		textField_sandwich_amt.setBounds(358, 103, 86, 20);
		panel_grilled.add(textField_sandwich_amt);
		
		textField_potato_amt = new JTextField();
		textField_potato_amt.setEnabled(false);
		textField_potato_amt.setColumns(10);
		textField_potato_amt.setBounds(358, 141, 86, 20);
		panel_grilled.add(textField_potato_amt);
		
		JLabel label_8 = new JLabel("Amount");
		label_8.setBounds(307, 104, 46, 14);
		panel_grilled.add(label_8);
		
		JLabel label_9 = new JLabel("Amount");
		label_9.setBounds(307, 144, 46, 14);
		panel_grilled.add(label_9);
		
		JPanel panel_fastfood = new JPanel();
		panel_fastfood.setLayout(null);
		panel_fastfood.setBounds(10, 433, 454, 95);
		frmFood.getContentPane().add(panel_fastfood);
		
		lblFastFood = new JLabel("Fast Food");
		lblFastFood.setForeground(Color.RED);
		lblFastFood.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFastFood.setBounds(0, 0, 70, 14);
		panel_fastfood.add(lblFastFood);
		
		lblPizza = new JLabel("Pizza");
		lblPizza.setBounds(10, 30, 60, 14);
		panel_fastfood.add(lblPizza);
		
		lblMomos = new JLabel("Momos");
		lblMomos.setBounds(10, 70, 60, 14);
		panel_fastfood.add(lblMomos);
		
		checkBox_pizza = new JCheckBox("200.00");
		
		checkBox_pizza.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_pizza_quan.setText("");
					textField_pizza_amt.setText("");
					textField_pizza_quan.setEnabled(false);
					textField_pizza_quan.setEditable(true);	

				}
				else
				{
					textField_pizza_quan.setEditable(true);	
					textField_pizza_quan.setEnabled(true);

				}
			}
		});

		checkBox_pizza.setBounds(66, 26, 65, 23);
		panel_fastfood.add(checkBox_pizza);
		
		checkBox_momos = new JCheckBox("150.00");
		checkBox_momos.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_momos_quan.setText("");
					textField_momos_amt.setText("");
					textField_momos_quan.setEnabled(false);
					textField_momos_quan.setEditable(true);	

				}
				else
				{
					textField_momos_quan.setEditable(true);	
					textField_momos_quan.setEnabled(true);

				}
			}
		});


		
		checkBox_momos.setBounds(66, 66, 65, 23);
		panel_fastfood.add(checkBox_momos);
		
		JLabel label_12 = new JLabel("Quantity");
		label_12.setBounds(144, 30, 50, 14);
		panel_fastfood.add(label_12);
		
		JLabel label_13 = new JLabel("Quantity");
		label_13.setBounds(144, 70, 50, 14);
		panel_fastfood.add(label_13);
		
		textField_pizza_quan = new JTextField();
		textField_pizza_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_pizza_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_pizza_quan.setText(null);
					textField_pizza_amt.setText(null);
				}
				else
				{
						if(textField_pizza_quan.getText().equals(""))
						{
							textField_pizza_amt.setText("");
							textField_pizza_amt.setEditable(true);
							textField_pizza_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
							    double quan = Integer.parseInt(textField_pizza_quan.getText());
							    double amt = quan * 200.0;
							    textField_pizza_amt.setEnabled(true);
							    textField_pizza_quan.setEnabled(true);
							    textField_pizza_amt.setEditable(false);
							    textField_pizza_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								
								textField_pizza_quan.setText(null);
								textField_pizza_amt.setText(null);
							}
						}
				}
			}
		});

		
		textField_pizza_quan.setEnabled(false);
		textField_pizza_quan.setColumns(10);
		textField_pizza_quan.setBounds(193, 27, 86, 20);
		panel_fastfood.add(textField_pizza_quan);
		
		textField_momos_quan = new JTextField();
		textField_momos_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_momos_quan.getText().length()>3)
				{	
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_momos_quan.setText(null);
					textField_momos_amt.setText(null);
				}
				else
				{	    
					    if(textField_momos_quan.getText().equals(""))
						{
							textField_momos_amt.setText("");
							textField_momos_amt.setEditable(true);
							textField_momos_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
							    double quan = Integer.parseInt(textField_momos_quan.getText());
							    double amt = quan * 150.0;
							    textField_momos_amt.setEnabled(true);
							    textField_momos_quan.setEnabled(true);
							    textField_momos_amt.setEditable(false);
							    textField_momos_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_momos_quan.setText(null);
								textField_momos_amt.setText(null);
							}
						}
				}	    
			}
		});

		textField_momos_quan.setEnabled(false);
		textField_momos_quan.setColumns(10);
		textField_momos_quan.setBounds(193, 67, 86, 20);
		panel_fastfood.add(textField_momos_quan);
		
		JLabel label_14 = new JLabel("Amount");
		label_14.setBounds(307, 30, 46, 14);
		panel_fastfood.add(label_14);
		
		JLabel label_15 = new JLabel("Amount");
		label_15.setBounds(307, 70, 46, 14);
		panel_fastfood.add(label_15);
		
		textField_pizza_amt = new JTextField();
		textField_pizza_amt.setEnabled(false);
		textField_pizza_amt.setColumns(10);
		textField_pizza_amt.setBounds(358, 27, 86, 20);
		panel_fastfood.add(textField_pizza_amt);
		
		textField_momos_amt = new JTextField();
		textField_momos_amt.setEnabled(false);
		textField_momos_amt.setColumns(10);
		textField_momos_amt.setBounds(358, 62, 86, 20);
		panel_fastfood.add(textField_momos_amt);
		
		JPanel panel_other = new JPanel();
		panel_other.setLayout(null);
		panel_other.setBounds(519, 70, 499, 139);
		frmFood.getContentPane().add(panel_other);
		
		JLabel lblOthers = new JLabel("Others");
		lblOthers.setForeground(Color.RED);
		lblOthers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOthers.setBounds(0, 0, 46, 14);
		panel_other.add(lblOthers);
		
		lblPavBhaji = new JLabel("Pav Bhaji");
		lblPavBhaji.setBounds(10, 30, 80, 14);
		panel_other.add(lblPavBhaji);
		
		lblPavVada = new JLabel("Pav Vada");
		lblPavVada.setBounds(10, 70, 85, 14);
		panel_other.add(lblPavVada);
		
		checkBox_pav_bhaji = new JCheckBox("100.00");
		
		checkBox_pav_bhaji.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_pavBhaji_quan.setText("");
					textField_pavBhaji_amt.setText("");
					textField_pavBhaji_quan.setEnabled(false);
					textField_pavBhaji_quan.setEditable(true);	

				}
				else
				{
					textField_pavBhaji_quan.setEditable(true);	
					textField_pavBhaji_quan.setEnabled(true);

				}
			}
		});

		checkBox_pav_bhaji.setBounds(96, 26, 65, 23);
		panel_other.add(checkBox_pav_bhaji);
		
		checkBox_pav_vada = new JCheckBox("50.00");
		checkBox_pav_vada.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_pavVada_quan.setText("");
					textField_pavVada_amt.setText("");
					textField_pavVada_quan.setEnabled(false);
					textField_pavVada_quan.setEditable(true);	

				}
				else
				{
					textField_pavVada_quan.setEditable(true);	
					textField_pavVada_quan.setEnabled(true);

				}
			}
		});
		
	
		checkBox_pav_vada.setBounds(96, 66, 65, 23);
		panel_other.add(checkBox_pav_vada);
		
		JLabel label_16 = new JLabel("Quantity");
		label_16.setBounds(169, 30, 50, 14);
		panel_other.add(label_16);
		
		JLabel label_17 = new JLabel("Quantity");
		label_17.setBounds(169, 70, 50, 14);
		panel_other.add(label_17);
		
		textField_pavBhaji_quan = new JTextField();
		textField_pavBhaji_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				 if(textField_pavBhaji_quan.getText().length()>3)
				 {
					    JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
						textField_pavBhaji_quan.setText(null);
						textField_pavBhaji_amt.setText(null);
					 
				 }
				 else
				 {
						if(textField_pavBhaji_quan.getText().equals(""))
						{
							textField_pavBhaji_amt.setText("");
							textField_pavBhaji_amt.setEditable(true);
							textField_pavBhaji_amt.setEnabled(false);
		
		
						}
						else
						{	
							try
							{
								    double quan = Integer.parseInt(textField_pavBhaji_quan.getText());
								    double amt = quan * 100.0;
								    textField_pavBhaji_amt.setEnabled(true);
								    textField_pavBhaji_quan.setEnabled(true);
								    textField_pavBhaji_amt.setEditable(false);
								    textField_pavBhaji_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_pavBhaji_quan.setText(null);
								textField_pavBhaji_amt.setText(null);
							}
						}
				 }
			}
		});

		textField_pavBhaji_quan.setEnabled(false);
		textField_pavBhaji_quan.setColumns(10);
		textField_pavBhaji_quan.setBounds(229, 27, 86, 20);
		panel_other.add(textField_pavBhaji_quan);
		
		textField_pavVada_quan = new JTextField();
		textField_pavVada_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_pavVada_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_pavVada_quan.setText(null);
					textField_pavVada_amt.setText(null);
				}
				else
				{
						if(textField_pavVada_quan.getText().equals(""))
						{
							textField_pavVada_amt.setText("");
							textField_pavVada_amt.setEditable(true);
							textField_pavVada_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_pavVada_quan.getText());
								    double amt = quan * 50.0;
								    textField_pavVada_amt.setEnabled(true);
								    textField_pavVada_quan.setEnabled(true);
								    textField_pavVada_amt.setEditable(false);
								    textField_pavVada_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_pavVada_quan.setText(null);
								textField_pavVada_amt.setText(null);
							}

						}
				}
			}
		});
		textField_pavVada_quan.setEnabled(false);
		textField_pavVada_quan.setColumns(10);
		textField_pavVada_quan.setBounds(229, 67, 86, 20);
		panel_other.add(textField_pavVada_quan);
		
		JLabel label_18 = new JLabel("Amount");
		label_18.setBounds(347, 30, 46, 14);
		panel_other.add(label_18);
		
		JLabel label_19 = new JLabel("Amount");
		label_19.setBounds(347, 70, 46, 14);
		panel_other.add(label_19);
		
		textField_pavBhaji_amt = new JTextField();
		textField_pavBhaji_amt.setEnabled(false);
		textField_pavBhaji_amt.setColumns(10);
		textField_pavBhaji_amt.setBounds(403, 27, 86, 20);
		panel_other.add(textField_pavBhaji_amt);
		
		textField_pavVada_amt = new JTextField();
		textField_pavVada_amt.setEnabled(false);
		textField_pavVada_amt.setColumns(10);
		textField_pavVada_amt.setBounds(403, 67, 86, 20);
		panel_other.add(textField_pavVada_amt);
		
		lblDosa = new JLabel("Dosa");
		lblDosa.setBounds(10, 114, 46, 14);
		panel_other.add(lblDosa);
		
		checkBox_dosa = new JCheckBox("80.00");
		checkBox_dosa.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_dosa_quan.setText("");
					textField_dosa_amt.setText("");
					textField_dosa_quan.setEnabled(false);
					textField_dosa_quan.setEditable(true);	

				}
				else
				{
					textField_dosa_quan.setEditable(true);	
					textField_dosa_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_dosa.setBounds(96, 110, 65, 23);
		panel_other.add(checkBox_dosa);
		
		JLabel label_20 = new JLabel("Quantity");
		label_20.setBounds(169, 114, 50, 14);
		panel_other.add(label_20);
		
		textField_dosa_quan = new JTextField();
		
		textField_dosa_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_dosa_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_dosa_quan.setText(null);
					textField_dosa_amt.setText(null);
					
				}	
				else
				{
						if(textField_dosa_quan.getText().equals(""))
						{
							textField_dosa_amt.setText("");
							textField_dosa_amt.setEditable(true);
							textField_dosa_amt.setEnabled(false);
		
		
						}
						else
						{    
							try
							{
								    double quan = Integer.parseInt(textField_dosa_quan.getText());
								    double amt = quan * 80.0;
								    textField_dosa_amt.setEnabled(true);
								    textField_dosa_quan.setEnabled(true);
								    textField_dosa_amt.setEditable(false);
								    textField_dosa_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_dosa_quan.setText(null);
								textField_dosa_amt.setText(null);
							}
								    
						}
				}
			}
		});
		textField_dosa_quan.setEnabled(false);
		textField_dosa_quan.setColumns(10);
		textField_dosa_quan.setBounds(229, 111, 86, 20);
		panel_other.add(textField_dosa_quan);
		
		textField_dosa_amt = new JTextField();
		textField_dosa_amt.setEnabled(false);
		textField_dosa_amt.setColumns(10);
		textField_dosa_amt.setBounds(403, 111, 86, 20);
		panel_other.add(textField_dosa_amt);
		
		JLabel label_21 = new JLabel("Amount");
		label_21.setBounds(347, 114, 46, 14);
		panel_other.add(label_21);
		
		JPanel panel_drink = new JPanel();
		panel_drink.setLayout(null);
		panel_drink.setBounds(485, 240, 559, 258);
		frmFood.getContentPane().add(panel_drink);
		
		lblDrinks = new JLabel("Drinks");
		lblDrinks.setForeground(Color.RED);
		lblDrinks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDrinks.setBounds(0, 0, 46, 14);
		panel_drink.add(lblDrinks);
		
		lblMountain = new JLabel("Mountain Dew");
		lblMountain.setBounds(10, 30, 92, 14);
		panel_drink.add(lblMountain);
		
		lblPepsi = new JLabel("Pepsi");
		lblPepsi.setBounds(10, 70, 60, 14);
		panel_drink.add(lblPepsi);
		
		checkBox_mountain_dew = new JCheckBox("20.00");
		checkBox_mountain_dew.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_mountainDew_quan.setText("");
					textField_mountainDew_amt.setText("");
					textField_mountainDew_quan.setEnabled(false);
					textField_mountainDew_quan.setEditable(true);	

				}
				else
				{
					textField_mountainDew_quan.setEditable(true);	
					textField_mountainDew_quan.setEnabled(true);

				}
			}
		});

		
		checkBox_mountain_dew.setBounds(120, 26, 60, 23);
		panel_drink.add(checkBox_mountain_dew);
		
		checkBox_pepsi = new JCheckBox("30.00");
		
		checkBox_pepsi.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_pepsi_quan.setText("");
					textField_pepsi_amt.setText("");
					textField_pepsi_quan.setEnabled(false);
					textField_pepsi_quan.setEditable(true);	

				}
				else
				{
					textField_pepsi_quan.setEditable(true);	
					textField_pepsi_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_pepsi.setBounds(120, 66, 65, 23);
		panel_drink.add(checkBox_pepsi);
		
		JLabel label_22 = new JLabel("Quantity");
		label_22.setBounds(208, 30, 50, 14);
		panel_drink.add(label_22);
		
		JLabel label_23 = new JLabel("Quantity");
		label_23.setBounds(208, 70, 50, 14);
		panel_drink.add(label_23);
		
		textField_mountainDew_quan = new JTextField();
		textField_mountainDew_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_mountainDew_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_mountainDew_quan.setText(null);
					textField_mountainDew_amt.setText(null);
				}
				else
				{
					
				
						if(textField_mountainDew_quan.getText().equals(""))
						{
							textField_mountainDew_amt.setText("");
							textField_mountainDew_amt.setEditable(true);
							textField_mountainDew_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_mountainDew_quan.getText());
								    double amt = quan * 20.0;
								    textField_mountainDew_amt.setEnabled(true);
								    textField_mountainDew_quan.setEnabled(true);
								    textField_mountainDew_amt.setEditable(false);
								    textField_mountainDew_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_mountainDew_quan.setText(null);
								textField_mountainDew_amt.setText(null);
							}
					}
				}
			}
		});

		textField_mountainDew_quan.setEnabled(false);
		textField_mountainDew_quan.setColumns(10);
		textField_mountainDew_quan.setBounds(268, 27, 86, 20);
		panel_drink.add(textField_mountainDew_quan);
		
		textField_pepsi_quan = new JTextField();

		textField_pepsi_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_pepsi_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_pepsi_quan.setText(null);
					textField_pepsi_amt.setText(null);	
				}
				else
				{
						if(textField_pepsi_quan.getText().equals(""))
						{
							textField_pepsi_amt.setText("");
							textField_pepsi_amt.setEditable(true);
							textField_pepsi_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_pepsi_quan.getText());
								    double amt = quan * 30.0;
								    textField_pepsi_amt.setEnabled(true);
								    textField_pepsi_quan.setEnabled(true);
								    textField_pepsi_amt.setEditable(false);
								    textField_pepsi_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_pepsi_quan.setText(null);
								textField_pepsi_amt.setText(null);
							}
						}
				}
			}
		});


		textField_pepsi_quan.setEnabled(false);
		textField_pepsi_quan.setColumns(10);
		textField_pepsi_quan.setBounds(268, 67, 86, 20);
		panel_drink.add(textField_pepsi_quan);
		
		JLabel label_24 = new JLabel("Amount");
		label_24.setBounds(386, 30, 46, 14);
		panel_drink.add(label_24);
		
		JLabel label_25 = new JLabel("Amount");
		label_25.setBounds(386, 70, 46, 14);
		panel_drink.add(label_25);
		
		textField_mountainDew_amt = new JTextField();
		textField_mountainDew_amt.setEnabled(false);
		textField_mountainDew_amt.setColumns(10);
		textField_mountainDew_amt.setBounds(442, 27, 86, 20);
		panel_drink.add(textField_mountainDew_amt);
		
		textField_pepsi_amt = new JTextField();
		textField_pepsi_amt.setEnabled(false);
		textField_pepsi_amt.setColumns(10);
		textField_pepsi_amt.setBounds(442, 67, 86, 20);
		panel_drink.add(textField_pepsi_amt);
		
		lblCoca = new JLabel("Coca Cola");
		lblCoca.setBounds(10, 104, 80, 14);
		panel_drink.add(lblCoca);
		
		lblTea = new JLabel("Tea");
		lblTea.setBounds(10, 144, 60, 14);
		panel_drink.add(lblTea);
		
		checkBox_coca_cola = new JCheckBox("25.00");
		checkBox_coca_cola.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_cocaCola_quan.setText("");
					textField_cocaCola_amt.setText("");
					textField_cocaCola_quan.setEnabled(false);
					textField_cocaCola_quan.setEditable(true);	

				}
				else
				{
					textField_cocaCola_quan.setEditable(true);	
					textField_cocaCola_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_coca_cola.setBounds(120, 100, 65, 23);
		panel_drink.add(checkBox_coca_cola);
		
		checkBox_tea = new JCheckBox("15.00");
		
		checkBox_tea.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_tea_quan.setText("");
					textField_tea_amt.setText("");
					textField_tea_quan.setEnabled(false);
					textField_tea_quan.setEditable(true);	

				}
				else
				{
					textField_tea_quan.setEditable(true);	
					textField_tea_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_tea.setBounds(120, 140, 65, 23);
		panel_drink.add(checkBox_tea);
		
		JLabel label_28 = new JLabel("Quantity");
		label_28.setBounds(208, 104, 50, 14);
		panel_drink.add(label_28);
		
		JLabel label_29 = new JLabel("Quantity");
		label_29.setBounds(208, 144, 50, 14);
		panel_drink.add(label_29);
		
		textField_cocaCola_quan = new JTextField();
		textField_cocaCola_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_cocaCola_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_cocaCola_quan.setText(null);
					textField_cocaCola_amt.setText(null);

					
				}
				else
				{
						if(textField_cocaCola_quan.getText().equals(""))
						{
							textField_cocaCola_amt.setText("");
							textField_cocaCola_amt.setEditable(true);
							textField_cocaCola_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_cocaCola_quan.getText());
								    double amt = quan * 25.0;
								    textField_cocaCola_amt.setEnabled(true);
								    textField_cocaCola_quan.setEnabled(true);
								    textField_cocaCola_amt.setEditable(false);
								    textField_cocaCola_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_cocaCola_quan.setText(null);
								textField_cocaCola_amt.setText(null);
							}
						}
				}
			}
		});

		textField_cocaCola_quan.setEnabled(false);
		textField_cocaCola_quan.setColumns(10);
		textField_cocaCola_quan.setBounds(268, 101, 86, 20);
		panel_drink.add(textField_cocaCola_quan);
		
		textField_tea_quan = new JTextField();
		textField_tea_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_tea_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_tea_quan.setText(null);
					textField_tea_amt.setText(null);	
				}
				else
				{
				
						if(textField_tea_quan.getText().equals(""))
						{
							textField_tea_amt.setText("");
							textField_tea_amt.setEditable(true);
							textField_tea_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_tea_quan.getText());
								    double amt = quan * 15.0;
								    textField_tea_amt.setEnabled(true);
								    textField_tea_quan.setEnabled(true);
								    textField_tea_amt.setEditable(false);
								    textField_tea_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_tea_quan.setText(null);
								textField_tea_amt.setText(null);
							}

						}
				}
			}
		});

		textField_tea_quan.setEnabled(false);
		textField_tea_quan.setColumns(10);
		textField_tea_quan.setBounds(268, 141, 86, 20);
		panel_drink.add(textField_tea_quan);
		
		textField_cocaCola_amt = new JTextField();
		textField_cocaCola_amt.setEnabled(false);
		textField_cocaCola_amt.setColumns(10);
		textField_cocaCola_amt.setBounds(442, 98, 86, 20);
		panel_drink.add(textField_cocaCola_amt);
		
		textField_tea_amt = new JTextField();
		textField_tea_amt.setEnabled(false);
		textField_tea_amt.setColumns(10);
		textField_tea_amt.setBounds(442, 141, 86, 20);
		panel_drink.add(textField_tea_amt);
		
		JLabel label_30 = new JLabel("Amount");
		label_30.setBounds(386, 104, 46, 14);
		panel_drink.add(label_30);
		
		JLabel label_31 = new JLabel("Amount");
		label_31.setBounds(386, 144, 46, 14);
		panel_drink.add(label_31);
		
		lblCoffee = new JLabel("Coffee");
		lblCoffee.setBounds(10, 184, 60, 14);
		panel_drink.add(lblCoffee);
		
		lblMineralWater = new JLabel("Mineral Water");
		lblMineralWater.setBounds(10, 220, 92, 14);
		panel_drink.add(lblMineralWater);
		
		checkBox_coffee = new JCheckBox("15.00");
		checkBox_coffee.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_coffee_quan.setText("");
					textField_coffee_amt.setText("");
					textField_coffee_quan.setEnabled(false);
					textField_coffee_quan.setEditable(true);	

				}
				else
				{
					textField_coffee_quan.setEditable(true);	
					textField_coffee_quan.setEnabled(true);

				}
			}
		});
		 
		checkBox_coffee.setBounds(120, 180, 65, 23);
		panel_drink.add(checkBox_coffee);
		
		checkBox_mineral_water = new JCheckBox("15.00");
		
		checkBox_mineral_water.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				int a = e.getStateChange();
				if (a==2)
				{
					textField_mineralWater_quan.setText("");
					textField_mineralWater_amt.setText("");
					textField_mineralWater_quan.setEnabled(false);
					textField_mineralWater_quan.setEditable(true);	

				}
				else
				{
					textField_mineralWater_quan.setEditable(true);	
					textField_mineralWater_quan.setEnabled(true);

				}
			}
		});
		
		checkBox_mineral_water.setBounds(120, 216, 65, 23);
		panel_drink.add(checkBox_mineral_water);
		
		JLabel label_34 = new JLabel("Quantity");
		label_34.setBounds(208, 184, 50, 14);
		panel_drink.add(label_34);
		
		JLabel label_35 = new JLabel("Quantity");
		label_35.setBounds(208, 220, 50, 14);
		panel_drink.add(label_35);
		
		textField_coffee_quan = new JTextField();
		textField_coffee_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_coffee_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_coffee_quan.setText(null);
					textField_coffee_amt.setText(null);					
				}
				else
				{
						if(textField_coffee_quan.getText().equals(""))
						{
							textField_coffee_amt.setText("");
							textField_coffee_amt.setEditable(true);
							textField_coffee_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_coffee_quan.getText());
								    double amt = quan * 15.0;
								    textField_coffee_amt.setEnabled(true);
								    textField_coffee_quan.setEnabled(true);
								    textField_coffee_amt.setEditable(false);
								    textField_coffee_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_coffee_quan.setText(null);
								textField_coffee_amt.setText(null);
							}
						}
				}
			}
		});
		textField_coffee_quan.setEnabled(false);
		textField_coffee_quan.setColumns(10);
		textField_coffee_quan.setBounds(268, 181, 86, 20);
		panel_drink.add(textField_coffee_quan);
		
		textField_mineralWater_quan = new JTextField();
		textField_mineralWater_quan.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if(textField_mineralWater_quan.getText().length()>3)
				{
					JOptionPane.showMessageDialog(null, "Maximum 3 digits allowed");
					textField_mineralWater_quan.setText(null);
					textField_mineralWater_amt.setText(null);

				}
				else
				{
					
						if(textField_mineralWater_quan.getText().equals(""))
						{
							textField_mineralWater_amt.setText("");
							textField_mineralWater_amt.setEditable(true);
							textField_mineralWater_amt.setEnabled(false);
		
		
						}
						else
						{
							try
							{
								    double quan = Integer.parseInt(textField_mineralWater_quan.getText());
								    double amt = quan * 15.0;
								    textField_mineralWater_amt.setEnabled(true);
								    textField_mineralWater_quan.setEnabled(true);
								    textField_mineralWater_amt.setEditable(false);
								    textField_mineralWater_amt.setText(String.valueOf(amt));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Please Enter Numbers Only");
								textField_mineralWater_quan.setText(null);
								textField_mineralWater_amt.setText(null);
							}

						}
				}
			}
		});
		textField_mineralWater_quan.setEnabled(false);
		textField_mineralWater_quan.setColumns(10);
		textField_mineralWater_quan.setBounds(268, 217, 86, 20);
		panel_drink.add(textField_mineralWater_quan);
		
		JLabel label_36 = new JLabel("Amount");
		label_36.setBounds(386, 184, 46, 14);
		panel_drink.add(label_36);
		
		JLabel label_37 = new JLabel("Amount");
		label_37.setBounds(386, 220, 46, 14);
		panel_drink.add(label_37);
		
		textField_coffee_amt = new JTextField();
		textField_coffee_amt.setEnabled(false);
		textField_coffee_amt.setColumns(10);
		textField_coffee_amt.setBounds(442, 172, 86, 20);
		panel_drink.add(textField_coffee_amt);
		
		textField_mineralWater_amt = new JTextField();
		textField_mineralWater_amt.setEnabled(false);
		textField_mineralWater_amt.setColumns(10);
		textField_mineralWater_amt.setBounds(442, 217, 86, 20);
		panel_drink.add(textField_mineralWater_amt);
		
		JButton btnCalculate = new JButton("Calculate");
		//btnCalculate.setEnabled(false);
		
		
		
		
		btnCalculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				    if(checkBox_fried_rice.isSelected() || checkBox_plain_rice.isSelected() || checkBox_burger.isSelected() || checkBox_salad.isSelected() || checkBox_sandwich.isSelected() ||checkBox_potato.isSelected()	|| checkBox_pizza.isSelected() || checkBox_momos.isSelected() || checkBox_pav_bhaji.isSelected() || checkBox_pav_vada.isSelected() || checkBox_dosa.isSelected() || checkBox_mountain_dew.isSelected() || checkBox_pepsi.isSelected() || checkBox_coca_cola.isSelected() || checkBox_tea.isSelected() || checkBox_coffee.isSelected() || checkBox_fried_rice.isSelected() || checkBox_mineral_water.isSelected())	
				    {

						 double  f_rice,p_rice,burger,salad,sandwich,potato,pizza,momos,p_bhaji,p_vada,dhosa,m_dew,pepsi,c_cola,tea,coffe,m_water,total=0;
	                            if(textField_friedRice_amt.getText().equals(""))
				                {
				                	textField_friedRice_amt.setText(null);
				                	f_rice=0;
				                }
				                else
				                {
				                	f_rice=Double.parseDouble(textField_friedRice_amt.getText());
				                }
				                
				                if(textField_plainRice_amt.getText().equals(""))
				                {
				                	textField_plainRice_amt.setText(null);
				                	p_rice=0;
				                }
				                else
				                {
				                	p_rice=Double.parseDouble(textField_plainRice_amt.getText());
				                }
				                if(textField_burger_amt.getText().equals(""))
				                {
				                	textField_burger_amt.setText(null);
				                	burger=0;
				                }
				                else
				                {
				                	burger=Double.parseDouble(textField_burger_amt.getText());
				                }
				                if(textField_salad_amt.getText().equals(""))
				                {
				                	textField_salad_amt.setText(null);
				                	salad=0;
				                }
				                else
				                {
				                	salad=Double.parseDouble(textField_salad_amt.getText());
				                }
				                if(textField_sandwich_amt.getText().equals(""))
				                {
				                	textField_sandwich_amt.setText(null);	
				                	sandwich=0;
				                }
				                else
				                {
				                	sandwich=Double.parseDouble(textField_sandwich_amt.getText());
				                }
				                if(textField_potato_amt.getText().equals(""))
				                {
				                	textField_potato_amt.setText(null);
				                	potato=0;
				                }
				                else
				                {
				                	potato=Double.parseDouble(textField_potato_amt.getText());
				                }
				                if(textField_pizza_amt.getText().equals(""))
				                {
				                	textField_pizza_amt.setText(null);
				                	pizza=0;
				                }
				                else
				                {
				                	pizza=Double.parseDouble(textField_pizza_amt.getText());
				                }
				                if(textField_momos_amt.getText().equals(""))
				                {
				                	textField_momos_amt.setText(null);
				                	momos=0;
				                }
				                else
				                {
				                	momos=Double.parseDouble(textField_momos_amt.getText());
				                } 
				                if(textField_pavBhaji_amt.getText().equals(""))
				                {
				                	textField_pavBhaji_amt.setText(null);
				                	p_bhaji=0;
				                }
				                else
				                {
				                	p_bhaji=Double.parseDouble(textField_pavBhaji_amt.getText());
				                }
				                if(textField_pavVada_amt.getText().equals(""))
				                {
				                	textField_pavVada_amt.setText(null);
				                	p_vada=0;
				                }
				                else
				                {
				                	p_vada=Double.parseDouble(textField_pavVada_amt.getText());
				                }
				                if(textField_dosa_amt.getText().equals(""))
				                {
				                	textField_dosa_amt.setText(null);
				                	dhosa=0;
				                }
				                else
				                {
				                	dhosa=Double.parseDouble(textField_dosa_amt.getText());
				                }
				                if(textField_mountainDew_amt.getText().equals(""))
				                {
				                	textField_mountainDew_amt.setText(null);
				                	m_dew=0;
				                }
				                else
				                {
				                	m_dew=Double.parseDouble(textField_mountainDew_amt.getText());
				                }
				                if(textField_pepsi_amt.getText().equals(""))
				                {
				                	textField_pepsi_amt.setText(null);
				                	pepsi=0;
				                }
				                else
				                {
				                	pepsi=Double.parseDouble(textField_pepsi_amt.getText());
				                }
				                if(textField_cocaCola_amt.getText().equals(""))
				                {
				                	textField_cocaCola_amt.setText(null);
				                	c_cola=0;
				                }
				                else
				                {
				                	c_cola=Double.parseDouble(textField_cocaCola_amt.getText());
				                }
				                if(textField_tea_amt.getText().equals(""))
				                {
				                	textField_tea_amt.setText(null);
				                	tea=0;
				                }
				                else
				                {
				                	tea=Double.parseDouble(textField_tea_amt.getText());
				                }
				                if(textField_coffee_amt.getText().equals(""))
				                {
				                	textField_coffee_amt.setText(null);
				                	coffe=0;
				                }
				                else
				                {
				                	coffe=Double.parseDouble(textField_coffee_amt.getText());
				                }
				                
				                if(textField_mineralWater_amt.getText().equals(""))
				                {
				                	textField_mineralWater_amt.setText(null);
				                	m_water=0;
				                }
				                else
				                {
				                	m_water=Double.parseDouble(textField_friedRice_amt.getText());
				                }
				                
				                total = f_rice+p_rice+burger+salad+sandwich+potato+pizza+momos+p_bhaji+p_vada+dhosa+m_dew+pepsi+c_cola+tea+coffe+m_water;
				                
				                if(total==0)
				                {
				                  	JOptionPane.showMessageDialog(null,"Total Amount is 0");
				                }
				                else
				                {
				                	textField_total.setText(String.valueOf(total));
				                	String s = JOptionPane.showInputDialog(null,"Enter Customer Cash");
				                	double cust_cash = Double.parseDouble(s);
				                	if(cust_cash>=total)
				                	{
				                		double change = cust_cash - total;
				                    	textField_customerCash.setText(s);
				                    	textField_change.setText(String.valueOf(change));	 
				                	}
				                	else
				                	{
				                		
				                		JOptionPane.showMessageDialog(null, "Customer Cash is not enough");
				                	}
				
				                 }
				       }
				       else
				       {
				    	      JOptionPane.showMessageDialog(null, "Select at least one Item");
				       }
                      get_last_id();

			          insert_rice();
			          insert_grilled();
			          insert_fast_food();
			          insert_others();
			          insert_drinks();
			          insert_items();
			          //clear();

				}

			
		});
		btnCalculate.setBounds(51, 573, 122, 31);
		frmFood.getContentPane().add(btnCalculate);
		
		textField_customerCash = new JTextField();
		textField_customerCash.setBounds(631, 577, 107, 22);
		frmFood.getContentPane().add(textField_customerCash);
		textField_customerCash.setColumns(10);
		
		textField_change = new JTextField();
		textField_change.setBounds(847, 576, 114, 22);
		frmFood.getContentPane().add(textField_change);
		textField_change.setColumns(10);
		
		textField_total = new JTextField();
		textField_total.setColumns(10);
		textField_total.setBounds(237, 573, 131, 31);
		frmFood.getContentPane().add(textField_total);
		
		JLabel lblCustomerCash = new JLabel("Customer  Cash");
		lblCustomerCash.setBounds(500, 581, 98, 14);
		frmFood.getContentPane().add(lblCustomerCash);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setBounds(775, 581, 46, 14);
		frmFood.getContentPane().add(lblChange);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(197, 581, 46, 14);
		frmFood.getContentPane().add(lblNewLabel_1);
		
		JButton btnClearButton = new JButton("Clear");
		btnClearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			       clear();
			}
		});
		btnClearButton.setBounds(392, 573, 98, 27);
		frmFood.getContentPane().add(btnClearButton);
		
		/*database*/
		
                
	   
		
		
	}

	protected void insert_items() {
		// TODO Auto-generated method stub
		//insert rice data
		try{
            if(textField_friedRice_amt.getText().equals("")){

            }else{

                          String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblFriedRice.getText());
                          pst.setString(3, checkBox_fried_rice.getText());
                          pst.setString(4, textField_friedRice_quan.getText());
                          pst.setString(5, textField_friedRice_amt.getText());
                          pst.execute();
                         
                       
                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
            try{
            if(textField_plainRice_amt.getText().equals("")){

            }else{

                          String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPlainRice.getText());
                          pst.setString(3, checkBox_plain_rice.getText());
                          pst.setString(4, textField_plainRice_quan.getText());
                          pst.setString(5, textField_plainRice_amt.getText());
                          pst.execute();
                        

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
              
              
          }

     
	//insert grilled data
            
            try{
                if(textField_burger_amt.getText().equals("")){

                }else{

                              String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                              pst=conn.prepareStatement(sql);
                              pst.setString(1, String.valueOf(id));
                              pst.setString(2, lblBurger.getText());
                              pst.setString(3, checkBox_burger.getText());
                              pst.setString(4, textField_burger_quan.getText());
                              pst.setString(5, textField_burger_amt.getText());
                              pst.execute();
                             

                      }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }finally{
                  try{
                       pst.close();
                              rs.close();
                  }catch(Exception e){
                      
                  }
              }
                              
                           try{
                if(textField_salad_amt.getText().equals("")){

                }else{

                              String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                              pst=conn.prepareStatement(sql);
                              pst.setString(1, String.valueOf(id));
                              pst.setString(2, lblSalad.getText());
                              pst.setString(3, checkBox_salad.getText());
                              pst.setString(4, textField_salad_quan.getText());
                              pst.setString(5, textField_salad_amt.getText());
                              pst.execute();
                           

                      }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }finally{
                  try{
                       pst.close();
                              rs.close();
                  }catch(Exception e){
                      
                  }
              }
                          
                           try{
                if(textField_sandwich_amt.getText().equals("")){

                }else{

                              String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                              pst=conn.prepareStatement(sql);
                              pst.setString(1, String.valueOf(id));
                              pst.setString(2, lblSandwich.getText());
                              pst.setString(3, checkBox_sandwich.getText());
                              pst.setString(4, textField_sandwich_quan.getText());
                              pst.setString(5, textField_sandwich_amt.getText());
                              pst.execute();
                             

                      }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }finally{
                  try{
                       pst.close();
                              rs.close();
                  }catch(Exception e){
                      
                  }
              }
                    
                          
                           try{
                if(textField_potato_amt.getText().equals("")){

                }else{

                              String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                              pst=conn.prepareStatement(sql);
                              pst.setString(1, String.valueOf(id));
                              pst.setString(2, lblPotato.getText());
                              pst.setString(3, checkBox_potato.getText());
                              pst.setString(4, textField_potato_quan.getText());
                              pst.setString(5, textField_potato_amt.getText());
                              pst.execute();
                       

                      }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }finally{
                  try{
                       pst.close();
                        rs.close();
                  }catch(Exception e){
                      
                  }
              }
                     

    		
    	//insert fast food data	
         
                           try{
                               if(textField_pizza_amt.getText().equals("")){

                               }else{
                                           
                                             String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                             pst=conn.prepareStatement(sql);
                                             pst.setString(1, String.valueOf(id));
                                             pst.setString(2, lblPizza.getText());
                                             pst.setString(3, checkBox_pizza.getText());
                                             pst.setString(4, textField_pizza_quan.getText());
                                             pst.setString(5, textField_pizza_amt.getText());
                                             pst.execute();
                                             
                                     }
                                   }catch(Exception e){
                                       JOptionPane.showMessageDialog(null, e);
                                   }finally{
                                 try{
                                      pst.close();
                                             rs.close();
                                 }catch(Exception e){
                                     
                                 }
                             }  

                                       
                       try{
                            if(textField_momos_amt.getText().equals("")){

                            }else{

                                          String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                          pst=conn.prepareStatement(sql);
                                          pst.setString(1, String.valueOf(id));
                                          pst.setString(2, lblMomos.getText());
                                          pst.setString(3, checkBox_momos.getText());
                                          pst.setString(4, textField_momos_quan.getText());
                                          pst.setString(5, textField_momos_amt.getText());
                                          pst.execute();
                                          
                                  }
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, e);
                                }finally{
                              try{
                                   pst.close();
                                          rs.close();
                              }catch(Exception e){
                                  
                              }
                          }

    	
       // insert others data
                
               		try{
                        if(textField_mountainDew_amt.getText().equals("")){

                        }else{

                                      String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                      pst=conn.prepareStatement(sql);
                                      pst.setString(1, String.valueOf(id));
                                      pst.setString(2, lblMountain.getText());
                                      pst.setString(3, checkBox_mountain_dew.getText());
                                      pst.setString(4, textField_mountainDew_quan.getText());
                                      pst.setString(5, textField_mountainDew_amt.getText());
                                      pst.execute();
                                     
                              }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }finally{
                          try{
                               pst.close();
                                      rs.close();
                          }catch(Exception e){
                              
                          }
                      }
                              try{
                        if(textField_pepsi_amt.getText().equals("")){

                        }else{

                                      String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                      pst=conn.prepareStatement(sql);
                                      pst.setString(1, String.valueOf(id));
                                      pst.setString(2, lblPepsi.getText());
                                      pst.setString(3, checkBox_pepsi.getText());
                                      pst.setString(4, textField_pepsi_quan.getText());
                                      pst.setString(5, textField_pepsi_amt.getText());
                                      pst.execute();
                                     

                              }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }finally{
                          try{
                               pst.close();
                                      rs.close();
                          }catch(Exception e){
                              
                          }
                      }
                                 try{
                        if(textField_cocaCola_amt.getText().equals("")){

                        }else{

                                      String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                      pst=conn.prepareStatement(sql);
                                      pst.setString(1, String.valueOf(id));
                                      pst.setString(2, lblCoca.getText());
                                      pst.setString(3, checkBox_coca_cola.getText());
                                      pst.setString(4, textField_cocaCola_quan.getText());
                                      pst.setString(5, textField_cocaCola_amt.getText());
                                      pst.execute();
                                     

                              }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }finally{
                          try{
                               pst.close();
                                      rs.close();
                          }catch(Exception e){
                              
                          }
                      }
                                 
                       try{
                        if(textField_tea_amt.getText().equals("")){

                        }else{

                                      String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                      pst=conn.prepareStatement(sql);
                                      pst.setString(1, String.valueOf(id));
                                      pst.setString(2, lblTea.getText());
                                      pst.setString(3, checkBox_tea.getText());
                                      pst.setString(4, textField_tea_quan.getText());
                                      pst.setString(5, textField_tea_amt.getText());
                                      pst.execute();
                                     

                              }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }finally{
                          try{
                               pst.close();
                                      rs.close();
                          }catch(Exception e){
                              
                          }
                      }
                       try{
                        if(textField_coffee_amt.getText().equals("")){

                        }else{

                                      String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                      pst=conn.prepareStatement(sql);
                                      pst.setString(1, String.valueOf(id));
                                      pst.setString(2, lblCoffee.getText());
                                      pst.setString(3, checkBox_coffee.getText());
                                      pst.setString(4, textField_coffee_quan.getText());
                                      pst.setString(5, textField_coffee_amt.getText());
                                      pst.execute();
                                      

                              }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }finally{
                          try{
                               pst.close();
                                      rs.close();
                          }catch(Exception e){
                              
                          }
                      }
                       try{
                           if(textField_mineralWater_amt.getText().equals("")){

                           }else{

                                         String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                         pst=conn.prepareStatement(sql);
                                         pst.setString(1, String.valueOf(id));
                                         pst.setString(2, lblMineralWater.getText());
                                         pst.setString(3, checkBox_mineral_water.getText());
                                         pst.setString(4, textField_mineralWater_quan.getText());
                                         pst.setString(5, textField_mineralWater_amt.getText());
                                         pst.execute();
                                         

                                 }
                               }catch(Exception e){
                                   JOptionPane.showMessageDialog(null, e);
                               }finally{
                             try{
                                  pst.close();
                                         rs.close();
                             }catch(Exception e){
                                 
                             }
                         }
                       try{
                           if(textField_pavBhaji_amt.getText().equals("")){

                           }else{

                                         String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                         pst=conn.prepareStatement(sql);
                                         pst.setString(1, String.valueOf(id));
                                         pst.setString(2, lblPavBhaji.getText());
                                         pst.setString(3, checkBox_pav_bhaji.getText());
                                         pst.setString(4, textField_pavBhaji_quan.getText());
                                         pst.setString(5, textField_pavBhaji_amt.getText());
                                         pst.execute();
                                         

                                 }
                               }catch(Exception e){
                                   JOptionPane.showMessageDialog(null, e);
                               }finally{
                             try{
                                  pst.close();
                                         rs.close();
                             }catch(Exception e){
                                 
                             }
                         }
                       try{
                           if(textField_pavVada_amt.getText().equals("")){

                           }else{

                                         String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                         pst=conn.prepareStatement(sql);
                                         pst.setString(1, String.valueOf(id));
                                         pst.setString(2, lblPavVada.getText());
                                         pst.setString(3, checkBox_pav_vada.getText());
                                         pst.setString(4, textField_pavVada_quan.getText());
                                         pst.setString(5, textField_pavVada_amt.getText());
                                         pst.execute();
                                         

                                 }
                               }catch(Exception e){
                                   JOptionPane.showMessageDialog(null, e);
                               }finally{
                             try{
                                  pst.close();
                                         rs.close();
                             }catch(Exception e){
                                 
                             }
                         }

                       try{
                           if(textField_dosa_amt.getText().equals("")){

                           }else{

                                         String sql = "insert into foods (id,type,price,quantity,amount) values(?,?,?,?,?)";
                                         pst=conn.prepareStatement(sql);
                                         pst.setString(1, String.valueOf(id));
                                         pst.setString(2, lblDosa.getText());
                                         pst.setString(3, checkBox_dosa.getText());
                                         pst.setString(4, textField_dosa_quan.getText());
                                         pst.setString(5, textField_dosa_amt.getText());
                                         pst.execute();
                                         

                                 }
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

	protected void insert_drinks() {
		// TODO Auto-generated method stub
		

		try{
            if(textField_mountainDew_amt.getText().equals("")){

            }else{

                          String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblMountain.getText());
                          pst.setString(3, checkBox_mountain_dew.getText());
                          pst.setString(4, textField_mountainDew_quan.getText());
                          pst.setString(5, textField_mountainDew_amt.getText());
                          pst.execute();
                         
                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                  try{
            if(textField_pepsi_amt.getText().equals("")){

            }else{

                          String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPepsi.getText());
                          pst.setString(3, checkBox_pepsi.getText());
                          pst.setString(4, textField_pepsi_quan.getText());
                          pst.setString(5, textField_pepsi_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                     try{
            if(textField_cocaCola_amt.getText().equals("")){

            }else{

                          String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblCoca.getText());
                          pst.setString(3, checkBox_coca_cola.getText());
                          pst.setString(4, textField_cocaCola_quan.getText());
                          pst.setString(5, textField_cocaCola_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                     
           try{
            if(textField_tea_amt.getText().equals("")){

            }else{

                          String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblTea.getText());
                          pst.setString(3, checkBox_tea.getText());
                          pst.setString(4, textField_tea_quan.getText());
                          pst.setString(5, textField_tea_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
           try{
            if(textField_coffee_amt.getText().equals("")){

            }else{

                          String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblCoffee.getText());
                          pst.setString(3, checkBox_coffee.getText());
                          pst.setString(4, textField_coffee_quan.getText());
                          pst.setString(5, textField_coffee_amt.getText());
                          pst.execute();
                          

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
           try{
               if(textField_mineralWater_amt.getText().equals("")){

               }else{

                             String sql = "insert into drinks (id,type,price,quantity,amount) values(?,?,?,?,?)";
                             pst=conn.prepareStatement(sql);
                             pst.setString(1, String.valueOf(id));
                             pst.setString(2, lblMineralWater.getText());
                             pst.setString(3, checkBox_mineral_water.getText());
                             pst.setString(4, textField_mineralWater_quan.getText());
                             pst.setString(5, textField_mineralWater_amt.getText());
                             pst.execute();
                             

                     }
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

	protected void insert_others() {
		// TODO Auto-generated method stub
        try{
            if(textField_pavBhaji_amt.getText().equals("")){

            }else{

                          String sql = "insert into others (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPavBhaji.getText());
                          pst.setString(3, checkBox_pav_bhaji.getText());
                          pst.setString(4, textField_pavBhaji_quan.getText());
                          pst.setString(5, textField_pavBhaji_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
       try{
            if(textField_pavVada_amt.getText().equals("")){

            }else{

                          String sql = "insert into others (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPavVada.getText());
                          pst.setString(3, checkBox_pav_vada.getText());
                          pst.setString(4, textField_pavVada_quan.getText());
                          pst.setString(5, textField_pavVada_amt.getText());
                          pst.execute();
                       

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
       
           try{
            if(textField_dosa_amt.getText().equals("")){

            }else{

                          String sql = "insert into others (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblDosa.getText());
                          pst.setString(3, checkBox_dosa.getText());
                          pst.setString(4, textField_dosa_quan.getText());
                          pst.setString(5, textField_dosa_amt.getText());
                          pst.execute();
                          

                  }
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

	protected void insert_fast_food() {
		
		try{
            if(textField_pizza_amt.getText().equals("")){

            }else{

                          String sql = "insert into fast_food (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPizza.getText());
                          pst.setString(3, checkBox_pizza.getText());
                          pst.setString(4, textField_pizza_quan.getText());
                          pst.setString(5, textField_pizza_amt.getText());
                          pst.execute();
                          

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                       
       try{
            if(textField_momos_amt.getText().equals("")){

            }else{

                          String sql = "insert into fast_food (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblMomos.getText());
                          pst.setString(3, checkBox_momos.getText());
                          pst.setString(4, textField_momos_quan.getText());
                          pst.setString(5, textField_momos_amt.getText());
                          pst.execute();
                          
                  }
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

	protected void insert_rice() {
		// TODO Auto-generated method stub
		
		try{
            if(textField_friedRice_amt.getText().equals("")){

            }else{

                          String sql = "insert into rice (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblFriedRice.getText());
                          pst.setString(3, checkBox_fried_rice.getText());
                          pst.setString(4, textField_friedRice_quan.getText());
                          pst.setString(5, textField_friedRice_amt.getText());
                          pst.execute();
                         
                       
                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e );
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
            try{
            if(textField_plainRice_amt.getText().equals("")){

            }else{

                          String sql = "insert into rice (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPlainRice.getText());
                          pst.setString(3, checkBox_plain_rice.getText());
                          pst.setString(4, textField_plainRice_quan.getText());
                          pst.setString(5, textField_plainRice_amt.getText());
                          pst.execute();
                        

                  }
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

	protected void insert_grilled() {
		// TODO Auto-generated method stub
		
        try{
            if(textField_burger_amt.getText().equals("")){

            }else{

                          String sql = "insert into grilled (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblBurger.getText());
                          pst.setString(3, checkBox_burger.getText());
                          pst.setString(4, textField_burger_quan.getText());
                          pst.setString(5, textField_burger_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                          
                       try{
            if(textField_salad_amt.getText().equals("")){

            }else{

                          String sql = "insert into grilled (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblSalad.getText());
                          pst.setString(3, checkBox_salad.getText());
                          pst.setString(4, textField_salad_quan.getText());
                          pst.setString(5, textField_salad_amt.getText());
                          pst.execute();
                       

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                      
                       try{
            if(textField_sandwich_amt.getText().equals("")){

            }else{

                          String sql = "insert into grilled (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblSandwich.getText());
                          pst.setString(3, checkBox_sandwich.getText());
                          pst.setString(4, textField_sandwich_quan.getText());
                          pst.setString(5, textField_sandwich_amt.getText());
                          pst.execute();
                         

                  }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }finally{
              try{
                   pst.close();
                          rs.close();
              }catch(Exception e){
                  
              }
          }
                
                      
                       try{
            if(textField_potato_amt.getText().equals("")){

            }else{

                          String sql = "insert into grilled (id,type,price,quantity,amount) values(?,?,?,?,?)";
                          pst=conn.prepareStatement(sql);
                          pst.setString(1, String.valueOf(id));
                          pst.setString(2, lblPotato.getText());
                          pst.setString(3, checkBox_potato.getText());
                          pst.setString(4, textField_potato_quan.getText());
                          pst.setString(5, textField_potato_amt.getText());
                          pst.execute();
                   

                  }
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
