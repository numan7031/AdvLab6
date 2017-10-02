package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Exchange {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	String query, sql, driver;
	Statement stmt;
	ResultSet rs;
	Connection conn;
	int i = 0;
	String temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exchange window = new Exchange();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exchange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		

		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			conn = DriverManager
					.getConnection("jdbc:ucanaccess://C:/B5774500/Database1.accdb");

			query = "SELECT * FROM lab6";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception eb) {
			System.err.println(eb);

		}

		frame = new JFrame("Exchange");
		frame.setBounds(100, 100, 570, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel(
				"\u0E2A\u0E01\u0E38\u0E25\u0E40\u0E07\u0E34\u0E19");

		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setEditable(false);

		JLabel label_1 = new JLabel(
				"\u0E2A\u0E01\u0E38\u0E25\u0E40\u0E07\u0E34\u0E19\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28");

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setEditable(false);

		JLabel label_2 = new JLabel(
				"\u0E2D\u0E31\u0E15\u0E23\u0E32\u0E41\u0E25\u0E01\u0E1B\u0E25\u0E35\u0E48\u0E22\u0E19");

		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setEditable(false);

		try {
			if (rs.isLast()) {
				return;
			} else {

				rs.next();
				textField1.setText(rs.getString(2));
				textField2.setText(rs.getString(3));
				textField3.setText(rs.getString(4));
			}
		} catch (Exception eb) {
			System.err.println(eb);

		}

		JButton firsbtn = new JButton("<<");
		firsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Class.forName("net.ucanaccess.jdbc.UcanaccessResultSet");
					stmt = conn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					rs = stmt.executeQuery(query);
					rs.first();
					textField1.setText(rs.getString(2));
					textField2.setText(rs.getString(3));
					textField3.setText(rs.getString(4));
				} catch (Exception eb) {
					System.err.println(eb);

				}
			}
		});

		JButton prebtn = new JButton("<");
		prebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.isFirst()) {
						return;
					} else {

						rs.previous();
						textField1.setText(rs.getString(2));
						textField2.setText(rs.getString(3));
						textField3.setText(rs.getString(4));
					}
				} catch (Exception eb) {
					System.err.println(eb);

				}

			}
		});

		JButton exitbtn = new JButton(
				"\u0E1B\u0E34\u0E14\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					conn.close();
					frame.dispose();

				} catch (Exception ec) {
					System.err.println(ec);

				}
			}
		});

		JButton nextbtn = new JButton(">");
		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (rs.isLast()) {
						return;
					} else {

						rs.next();
						textField1.setText(rs.getString(2));
						textField2.setText(rs.getString(3));
						textField3.setText(rs.getString(4));
					}
				} catch (Exception eb) {
					System.err.println(eb);

				}
			}
		});

		JButton lastbtn = new JButton(">>");
		lastbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					rs.last();
					textField1.setText(rs.getString(2));
					textField2.setText(rs.getString(3));
					textField3.setText(rs.getString(4));
				} catch (Exception eb) {
					System.err.println(eb);

				}
			}
		});

		JButton savebtn = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		JButton canclebtn = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		JButton delbtn = new JButton("\u0E25\u0E1A");
		JButton editbtn = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");

		JButton addbtn = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField1.setEditable(true);
				textField2.setEditable(true);
				canclebtn.setEnabled(true);
				savebtn.setEnabled(true);
				textField3.setEditable(true);
				textField1.setText(null);
				textField2.setText(null);
				textField3.setText(null);
				addbtn.setEnabled(false);
				editbtn.setEnabled(false);
				delbtn.setEnabled(false);

				i = 1;

			}
		});

		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				sql = "delete from  lab6 where sakul  = '"
						+ textField1.getText() + "'";
				try {


					int confirm = JOptionPane.showConfirmDialog(null,
							"คุณต้องการลบ:" + textField1.getText() + "หรือไม่",
							"คำยืนยัน", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {

						stmt.executeUpdate(sql);

						JOptionPane
								.showMessageDialog(null, "ลบข้อมูลเรียบร้อย");


						rs.previous();
						textField1.setText(rs.getString(2));
						textField2.setText(rs.getString(3));
						textField3.setText(rs.getString(4));

					} else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});

		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField1.setEditable(true);
				textField2.setEditable(true);
				textField3.setEditable(true);
				canclebtn.setEnabled(true);
				savebtn.setEnabled(true);
				addbtn.setEnabled(false);
				editbtn.setEnabled(false);
				delbtn.setEnabled(false);
				
				 temp = textField1.getText();

				i = -1;

			}
		});

		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField1.setEditable(false);
				textField2.setEditable(false);
				textField3.setEditable(false);

				textField1.setText(null);
				textField2.setText(null);
				textField3.setText(null);

				addbtn.setEnabled(true);
				editbtn.setEnabled(true);
				delbtn.setEnabled(true);
				canclebtn.setEnabled(false);
				savebtn.setEnabled(false);

				try {

					rs.first();
					textField1.setText(rs.getString(2));
					textField2.setText(rs.getString(3));
					textField3.setText(rs.getString(4));

				} catch (Exception eb) {
					System.err.println(eb);

				}

			}
		});

		canclebtn.setEnabled(false);
		savebtn.setEnabled(false);

		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 1) {


					sql = "insert into lab6 (sakul,country,cast) values('"
							+ textField1.getText() + "','"
							+ textField2.getText() + "','"
							+ textField3.getText() + "')";
					try {


						if (stmt.executeUpdate(sql) != 0) {
							JOptionPane.showMessageDialog(null,
									"บันทึกข้อมูลเรียบร้อยแล้ว");}else{
										JOptionPane.showMessageDialog(null,
												"ERROR");}


							rs.first();
							textField1.setText(rs.getString(2));
							textField2.setText(rs.getString(3));
							textField3.setText(rs.getString(4));
						

					} catch (Exception err) {
						err.printStackTrace();
					}

				} else if (i == -1) {
					
					//String t1 = textField1.getText();
					//String t2 = textField2.getText();
					//Double value = Double.parseDouble(textField3.getText());

					 sql = "UPDATE lab6 SET sakul = '"+textField1.getText()+"',country = '"+textField2.getText()+"',cast = "+textField3.getText()+" where sakul = '"+temp+ "'";
					 
					 //sql = "UPDATE lab6 SET sakul = '"+textField1.getText()+"',country = '"+textField2.getText()+"',cast = "+textField3.getText()+" where sakul = '"+textField1.getText()+"'";
				
					
				     
					 
					 
					 
					try {
						
						
						
						
						int confirm = JOptionPane.showConfirmDialog(null,
								"คุณต้องการแก้ไข:" + textField1.getText()
										+ "หรือไม่", "คำยืนยัน",
								JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							
							Statement s = conn.createStatement();
							

							if (s.executeUpdate(sql) != 0) {
								JOptionPane.showMessageDialog(null,
										"แก้ไขข้อมูลเรียบร้อยแล้ว");
								}else{
									JOptionPane.showMessageDialog(null,
											"ERROR");}


						} else if (confirm == JOptionPane.NO_OPTION) {
							return;
						}

					} catch (Exception err) {
						err.printStackTrace();
					}
				}

				textField1.setEditable(false);
				textField2.setEditable(false);
				textField3.setEditable(false);
				i = 0;
				canclebtn.setEnabled(false);
				savebtn.setEnabled(false);
				addbtn.setEnabled(true);
				editbtn.setEnabled(true);
				delbtn.setEnabled(true);

			}
		});
		frame.getRootPane().setDefaultButton(savebtn);
		savebtn.requestFocus();
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(7)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(label_1)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				label_2))
														.addComponent(label))
										.addPreferredGap(
												ComponentPlacement.RELATED, 47,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addComponent(
																textField1,
																Alignment.LEADING)
														.addGroup(
																Alignment.LEADING,
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				firsbtn)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				prebtn)
																		.addGap(4)
																		.addComponent(
																				exitbtn)
																		.addGap(4)
																		.addComponent(
																				nextbtn)
																		.addGap(4)
																		.addComponent(
																				lastbtn))
														.addComponent(
																textField2,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																287,
																Short.MAX_VALUE)
														.addComponent(
																textField3,
																Alignment.LEADING))
										.addGap(56)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																delbtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																addbtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																savebtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																canclebtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																editbtn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(523)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(39)
																		.addComponent(
																				label)
																		.addGap(18)
																		.addComponent(
																				label_1))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(36)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												addbtn)
																										.addGap(4)
																										.addComponent(
																												delbtn)
																										.addGap(4)
																										.addComponent(
																												editbtn)
																										.addGap(4)
																										.addComponent(
																												savebtn))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField1,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																label_2)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				textField2,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				textField3,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)))))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								canclebtn)
																						.addGroup(
																								groupLayout
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												prebtn)
																										.addComponent(
																												firsbtn))
																						.addComponent(
																								exitbtn)
																						.addComponent(
																								nextbtn)
																						.addComponent(
																								lastbtn))))
										.addGap(296)));
		frame.getContentPane().setLayout(groupLayout);

	}
}
