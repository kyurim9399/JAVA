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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class AddNewBook extends JPanel{
	private String[] b_col = {"Book ID", "Book Name", "Author", "Publisher", "Quantity", "Date Acquired", "Subjects"};
	private	String[] sub = {"-----select-----", "General Fiction", "Mystery", "Romance", "Biography", "Science Fiction", "History"};
	private	String bookName, author, publisher, subjects, date, sameBookId;
	private	int quantity;
	private	SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
	
	private	JLabel title;
	private	JLabel[] b_lb = new JLabel[b_col.length];
	private	JTextField[] b_tf = new JTextField[b_col.length-1];
	private	JComboBox<String> sub_combo;
	private	JButton b_add, b_cancle; 
	


	public AddNewBook() {
		setSize(780 ,590);
		setLayout(null);
		
		setTitle();

		// set Labels
		for(int i = 0; i < b_lb.length; i++) {
			b_lb[i] = new JLabel(b_col[i]);
			b_lb[i].setFont(new Font("Consolas", 0, 20));
			add(b_lb[i]);
		}
		b_lb[0].setBounds(140, 70, 150, 25);
		for(int i = 1; i< b_lb.length; i++) {
			b_lb[i].setBounds(b_lb[0].getX(), b_lb[i-1].getY() + 50, b_lb[0].getWidth(), b_lb[0].getHeight());
		}
		
		

		// set TextFields
		
		for(int i = 0; i < b_tf.length; i++) {
			b_tf[i] = new JTextField();
			b_tf[i].setFont(new Font("Consolas", 0, 15));
			add(b_tf[i]);
		}
		b_tf[0].setForeground(Color.LIGHT_GRAY);
		b_tf[0].setEditable(false);
		
		date = dateformat.format(System.currentTimeMillis());
		b_tf[5].setText(date);
		b_tf[5].setForeground(Color.LIGHT_GRAY);
		b_tf[5].setEditable(false);
		
		b_tf[0].setBounds(340, 70, 250, 25);
		for(int i = 1; i< b_tf.length; i++) {
			b_tf[i].setBounds(b_tf[0].getX(), b_tf[i-1].getY() + 50, b_tf[0].getWidth(), b_tf[0].getHeight());
		}


		// set comboBox
		sub_combo = new JComboBox<String> (sub);
		sub_combo.setBounds(b_tf[0].getX(), b_tf[b_tf.length - 1].getY() + 50, b_tf[0].getWidth(), b_tf[0].getHeight());
		sub_combo.setFont(new Font("Consolas", 0, 20));
		add(sub_combo);
		
		
		
		// set button
		b_add = new JButton("ADD");
		b_cancle = new JButton("CANCLE");
		
		b_add.setFont(new Font("Consolas", 0, 20));
		b_cancle.setFont(new Font("Consolas", 0, 20));
		
		b_add.setBounds(240, sub_combo.getY() + 70, 100, 40);
		b_cancle.setBounds(440, sub_combo.getY() + 70, 100, 40);
		
		b_add.setBackground(Color.orange);
		b_cancle.setBackground(Color.orange);
		
		b_add.setForeground(Color.white);
		b_cancle.setForeground(Color.white);
		
		add(b_add); add(b_cancle);
		

		
		
		// button Event
		b_add.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] err = {"","","","",""};
				boolean valid = true;
				// get data from TextField
				bookName = b_tf[1].getText();
				author = b_tf[2].getText();
				publisher = b_tf[3].getText();
				subjects = sub_combo.getSelectedItem().toString();
				
				
				
				
				// check the null and valid values
				if(b_tf[4].getText().equals("")) {
					err[4] = "Quantity";
					valid = false;
				}
				else {
					try {
						quantity =  Integer.parseInt(b_tf[4].getText());
						if(quantity > 999 || quantity < 1) {
							JOptionPane.showMessageDialog(null, "1~999사이의 숫자를 입력해주세요.", "Message", JOptionPane.INFORMATION_MESSAGE);
							b_tf[4].setText("");
							b_tf[4].requestFocus();
							return;
						}
					}catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Quantity에 숫자를 입력해 주세요.", "Message", JOptionPane.INFORMATION_MESSAGE);
						 b_tf[4].setText("");
						 b_tf[4].requestFocus();
						 return;
					}
			
				}


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
				
				
				
				
				// if there don't have any empty field
				if(valid) {
					// check there are existing book
					if(isSame()) {
						int result = JOptionPane.showConfirmDialog(null, "같은 책이 존재합니다. 더 추가하시겠습니까?", "확인메세지창", JOptionPane.YES_NO_OPTION);
						if(result == 0) {
							addBook();
							JOptionPane.showMessageDialog(null, bookName + "책이 " + quantity + "권 더 추가 되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
						}else if(result == 1) {
							JOptionPane.showMessageDialog(null, "책이 등록이 취소되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
						}
					}// issue new book
					else {
						int result = JOptionPane.showConfirmDialog(null, "책을 등록하시겠습니까?", "확인메세지창", JOptionPane.YES_NO_OPTION);

						if(result == 0) {
							addBook();
							JOptionPane.showMessageDialog(null,bookName +  "책이 등록되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
						}else if(result == 1) {
							JOptionPane.showMessageDialog(null, "책 등록이 취소되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					setEmpty();
				}
				// if there have empty fields, an error message appeared 
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
				int result = JOptionPane.showConfirmDialog(null, "책 입력을 취소하시겠습니까?", "Confirm Message", JOptionPane.YES_NO_OPTION);

				if(result == 0) {
					JOptionPane.showMessageDialog(null, "책 등록이 취소되었습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
					setEmpty();
				}
			}
		});
		
		setVisible(true);
	}
	
	
	private void setTitle() {
		title = new JLabel("Add New Book");
		title.setBounds(30, 10, 150, 20);
		title.setFont(new Font("Consolas", Font.BOLD, 20));
		add(title);
	}


	public void addBook() {
		for(int i = 0; i < quantity; i++) {
			Connection conn = ConnectDB.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into book ");
			sql.append("values (?, ?, ?, ?, ?, ?) ");
			
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, getBookID());
				pstmt.setString(2, bookName);
				pstmt.setString(3, author);
				pstmt.setString(4, publisher);
				pstmt.setString(5,subjects);
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
	} // addBook() end
	
	
	public String getBookID() {
		// 1. subject 구분
		String[] subCode = {"----------", "GFI", "MYS", "ROM", "BIO", "SFI", "HIS"};
		int index = sub_combo.getSelectedIndex();
		String bookId = subCode[index];
				
		Connection conn = ConnectDB.getConnection();		
		
		if(!isSame()) {
			StringBuffer sql = new StringBuffer();
			sql.append("Select count(DISTINCT substr(bookid,1,8)) from book where SUBJECTS = ? ");

			
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, sub[index]);

				ResultSet rs = pstmt.executeQuery();
				rs.next();
				bookId += String.format("%05d", rs.getInt(1) + 1 ) + "001";

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {	
			bookId = sameBookId.substring(0, 8);
			
			String sql2 = "Select count(bookid) from book where substr(bookid,1,8) = ? ";
			
			PreparedStatement pstmt2 = null;
			try {
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, bookId);
				ResultSet rs = pstmt2.executeQuery();
				rs.next();
				bookId += String.format("%03d", rs.getInt(1) + 1 );
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(pstmt2 != null) pstmt2.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return bookId;
	}//getBookID() end
	
	
	public boolean isSame() {
		boolean result = false;
		Connection conn = ConnectDB.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("Select bookid from book ");
		sql.append("where bookname = ? and author = ? and subjects = ? and publisher = ? ");

		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(sql.toString());
			pstmt.setString(1, bookName);
			pstmt.setString(2, author);
			pstmt.setString(3, subjects);
			pstmt.setString(4, publisher);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = rs.next()? true : false;
			
			if(result) sameBookId = rs.getString(1);	
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
		return result;
	}//isSame() end
	
	
	public void setEmpty() {
		for(int i = 0; i<b_tf.length-1; i++) {
			b_tf[i].setText("");
		}
		sub_combo.setSelectedIndex(0);
	} // setEmpty() end
}
