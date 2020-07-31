import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Search extends JPanel {
	private JLabel title;
	private JTextField searchBox;
	private JButton searchBtn;
	private JComboBox<String> listBox;
	private String[] colNames = {"Book ID", "Book Name", "Author", "Publisher",  "Subjects"};
	private String[] headerNames = {"ID", "Title", "Author", "Publisher",  "Subjects", "Status"};
	
	private DefaultTableModel model = new DefaultTableModel(headerNames, 0);	
	private JTable table;
	private JScrollPane scrollPane;
	
	
	PreparedStatement pstmt;
	private ResultSet rs;	
	
	public Search() {
		setSize(780 ,590);
		setLayout(null);
		
		setTitle();
		
		// set list
		listBox =  new JComboBox<String>(colNames);
		listBox.setBounds(100, 50, 90, 20);
		listBox.setFont(new Font("Consolas", 0, 12));
		listBox.setSelectedIndex(1);	// combobox 시작을 id가 아닌 name로 초기화
		add(listBox);
		
		
		// set search box
		searchBox = new JTextField();
		searchBox.setBounds(200, 50, 390, 20);
		searchBox.setFont(new Font("Consolas", 0, 12));
		add(searchBox);
		

		// set button
		searchBtn = new JButton("Search");
		searchBtn.setBounds(600, 50, 80, 20);
		searchBtn.setFont(new Font("Consolas", 0, 12));
		add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0); // 검색 할 때, 이전의 데이터를 비워주는 역활
				String selectedList = "b." + listBox.getSelectedItem().toString().replace(" ", "");
				select(selectedList);
				setTable();
				
			}
		});


		setTable();
		
		
		setVisible(true);
	}
	
	private void setTitle() {
		title = new JLabel("Search Books");
		title.setBounds(30, 10, 150, 20);
		title.setFont(new Font("Consolas", Font.BOLD, 20));
		add(title);
	}
	
	private void setTable() {
		table = new JTable(model);
		
		// 셀 크기 지정
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);

		// 셀 안의 텍스트 정렬 지정
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(4).setCellRenderer(center);
		table.getColumnModel().getColumn(5).setCellRenderer(center);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 100, 680, 400);

		add(scrollPane);
	} // end of setTable()
	
	private void select(String selectedList) {
		Connection conn = ConnectDB.getConnection();
		
		// = ?
		StringBuffer sql = new StringBuffer();
		sql.append("select b.BookID, b.BookName, b.Author, b.Publisher, b.Subjects, ");
		sql.append("CASE when b.bookid = i.bookid then 'On loan' ELSE 'In Library' end ");
		sql.append("from book b left join issue i on b.bookid = i.bookid ");
		sql.append("where " + selectedList + "= ? ");
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, searchBox.getText());
			
			ResultSet rs = pstmt.executeQuery();
             while(rs.next()){           
                 model.addRow(new Object[]{rs.getString("BookID"),rs.getString("BookName"),
                                             rs.getString("Author"),rs.getString("Publisher"),
                                             rs.getString("Subjects"), rs.getString(6)});
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		

		
		// like ?
		StringBuffer sql2 = new StringBuffer();
		sql2.append("select b.BookID, b.BookName, b.Author, b.Publisher, b.Subjects, ");
		sql2.append("CASE when b.bookid = i.bookid then 'On loan' ELSE 'In Library' end ");
		sql2.append("from book b left join issue i on b.bookid = i.bookid ");
		sql2.append("where " + selectedList + " like ? and not " + selectedList + " = ? ");

		try {
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setString(1, "%" + searchBox.getText() + "%");
			pstmt.setString(2, searchBox.getText());

			ResultSet rs = pstmt.executeQuery();
             while(rs.next()){            
                 model.addRow(new Object[]{rs.getString("BookID"),rs.getString("BookName"),
                                             rs.getString("Author"),rs.getString("Publisher"),
                                             rs.getString("Subjects"), rs.getString(6)});
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
	} // end of select()
	
}
