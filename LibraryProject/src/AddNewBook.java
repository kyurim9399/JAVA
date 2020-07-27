/*
bookId
BookName
Author
Subjects
Publisher
입고날짜(Date acquired)

	// 다른 테이블 Available(Status) - On loan(Due : 31/8/2020), In Library
*/

/*
 * 해야할 것 : 만약 중복된 값이 들어오면 어떻게 할 것인가?
 * */


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class AddNewBook extends JFrame{
	String[] b_col = {"Book ID", "Book Name", "Author", "Publisher", "Date Acquired", "Subjects"};
	String[] sub = {"-----select-----", "General Fiction", "Mystery", "Romance", "Graphic Books", "Science Fiction", "French Fiction"};
	String bookName, author, publisher, subjects, date;
	int bookID;
	SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
	
	JLabel b_title;
	JLabel[] b_lb = new JLabel[6];
	JTextField[] b_tf = new JTextField[5];
	JComboBox<String> sub_combo;
	JButton b_add, b_cancle; 
	
	
	
	
	public AddNewBook() {
		super("Add New Book");
		setBounds(600, 200, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		//set Title
		b_title = new JLabel("Add New Book", SwingConstants.CENTER);
		b_title.setFont(new Font("Consolas", Font.BOLD, 50));
		//b_title.setForeground(Color.blue);
		b_title.setBounds(0, 50, 1000, 50);
		add(b_title);
		

		// set Labels
		for(int i = 0; i < b_col.length; i++) {
			b_lb[i] = new JLabel(b_col[i]);
			b_lb[i].setFont(new Font("Consolas", 0, 20));
			add(b_lb[i]);
		}
		b_lb[0].setBounds(200, 150, 200, 30);
		for(int i = 1; i< b_col.length; i++) {
			b_lb[i].setBounds(b_lb[0].getX(), b_lb[i-1].getY() + 50, b_lb[0].getWidth(), b_lb[0].getHeight());
		}
		
		

		// set TextFields
		
		for(int i = 0; i < b_tf.length; i++) {
			b_tf[i] = new JTextField();
			b_tf[i].setFont(new Font("Consolas", 0, 20));
			add(b_tf[i]);
		}
		b_tf[0].setText(String.format("%05d", getBookID()));
		b_tf[0].setForeground(Color.LIGHT_GRAY);
		b_tf[0].setEditable(false);
		
		date = dateformat.format(System.currentTimeMillis());
		b_tf[4].setText(date);
		b_tf[4].setForeground(Color.LIGHT_GRAY);
		b_tf[4].setEditable(false);
		
		b_tf[0].setBounds(400, 150, 400, 30);
		for(int i = 1; i< b_tf.length; i++) {
			b_tf[i].setBounds(b_tf[0].getX(), b_tf[i-1].getY() + 50, b_tf[0].getWidth(), b_tf[0].getHeight());
		}


		// set comboBox
		sub_combo = new JComboBox<String> (sub);
		sub_combo.setBounds(b_tf[0].getX(), b_tf[4].getY() + 50, b_tf[0].getWidth(), b_tf[0].getHeight());
		sub_combo.setFont(new Font("Consolas", 0, 20));
		add(sub_combo);
		
		
		// set button
		b_add = new JButton("ADD");
		b_cancle = new JButton("CANCLE");
		
		b_add.setFont(new Font("Consolas", 0, 20));
		b_cancle.setFont(new Font("Consolas", 0, 20));
		
		b_add.setBounds(350, sub_combo.getY() + 150, 100, 50);
		b_cancle.setBounds(550, sub_combo.getY() + 150, 100, 50);
		add(b_add); add(b_cancle);
		

		
		// button Event
		b_add.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				bookName = b_tf[1].getText();
				author = b_tf[2].getText();
				publisher = b_tf[3].getText();
				subjects = sub_combo.getSelectedItem().toString();
				
				String[] err = {"","","",""};
				boolean valid = true;
				if(bookName.equals("")){
					err[0] = "Book Name";
					valid = false;
				}
				if(author.equals("")) {
					err[1] = "Author";
					valid = false;
				}
				if(publisher.equals("")) {
					err[2] = "Publisher";
					valid = false;
				}
				if(sub_combo.getSelectedIndex() == 0) {
					err[3] = "Subjects";
					valid = false;
				}
				
				if(valid) {
					insert();
					b_tf[0].setText(String.format("%05d", getBookID()));
					JOptionPane.showMessageDialog(null, "책이 등록되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
					b_tf[1].setText("");
					b_tf[2].setText("");
					b_tf[3].setText("");
					sub_combo.setSelectedIndex(0);
					
				}
				else {
					String errmsg = "";
					for(int i = 0; i < err.length; i++) {
						if(errmsg.equals("") && !err[i].equals("")) {
							errmsg = err[i];
						} else if(!errmsg.equals("") && !err[i].equals("")) {
							errmsg += ", " + err[i];
						}
					}
					JOptionPane.showMessageDialog(null, "Please Enter " + errmsg, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		
		
		
		b_cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b_tf[0].setText(String.format("%05d", getBookID()));
				for(int i = 1; i<b_tf.length-1; i++) {
					b_tf[i].setText("");
				}
				sub_combo.setSelectedIndex(0);
				
			}
		});
		
		
		
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new AddNewBook();
	}


	public void insert() {
		Connection conn = ConnectDB.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into books ");
		sql.append("values (?, ?, ?, ?, ?, ?) ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, bookID);
			pstmt.setString(2, bookName);
			pstmt.setString(3, author);
			pstmt.setString(4, subjects);
			pstmt.setString(5, publisher);
			pstmt.setString(6, date);
			
			
			int result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public int getBookID() {
		Connection conn = ConnectDB.getConnection();

		String sql = "Select count(bookid) from books";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bookID = rs.getInt(1) + 1; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bookID;
	}
	
	
	public boolean isSame() {
		
		Connection conn = ConnectDB.getConnection();

		
		StringBuffer sql = new StringBuffer();
		sql.append("Select bookid from books ");
		sql.append("where bookname = ? and author = ? and subjects = ? and publisher = ? ");

		
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, bookName);
			pstmt.setString(2, author);
			pstmt.setString(3, subjects);
			pstmt.setString(4, publisher);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
