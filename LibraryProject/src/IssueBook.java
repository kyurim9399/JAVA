import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class IssueBook extends JPanel implements ActionListener{
	private Container c;
	private JPanel jp1, jp_mem, jp_bk;
	private JButton btn_issue, btn_cancel, btn_mem1, btn_mem2, btn_bk1, btn_bk2; 
	
	private	String[] str_mem = {"회원번호", "회원명", "전화번호", "대출/가능 권수", "연체권수"};
	private JLabel[] jlb_mem = new JLabel[str_mem.length];
	private JTextField[] jtf_mem = new JTextField[str_mem.length];
	
	private	String[] str_bk = {"도서번호", "대출 가능 여부", "도서명", "저자", "출판사", "대출일", "반납예정일"};
	private JLabel[] jlb_bk = new JLabel[str_bk.length];
	private JTextField[] jtf_bk = new JTextField[str_bk.length];
	
	private String[] headerNames = {"회원번호", "회원명", "전화번호", "이메일"};
	private DefaultTableModel model = new DefaultTableModel(headerNames, 0);	
	private JTable table;
	private JScrollPane scrollPane;
	
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;	
	
	private	SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
	
	
	public IssueBook() {
		setBounds(600, 200, 780 ,590);
		setLayout(null);
		

		setTitle();
		setMemberInfo();
		setBookInfo();
		setTable();
		
		setButton();
		
		btn_issue.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_mem1.addActionListener(this);
		btn_mem2.addActionListener(this);
		btn_bk1.addActionListener(this); 
		btn_bk2.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IssueBook();
	}
	
	
	private void setTitle() {
		jp1 = new JPanel();
		jp1.setBorder(new TitledBorder(null, "Issue Book", TitledBorder.LEADING, TitledBorder.TOP, new Font("Consolas", 0, 20), null));
		//jp1.setToolTipText();
		jp1.setBounds(20, 10, 725, 520);
		jp1.setLayout(null);
		add(jp1);
	}
	
	private void setMemberInfo() {
		jp_mem = new JPanel();
		jp_mem.setLayout(null);
		jp_mem.setBorder(new TitledBorder(null, "회원 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jp_mem.setToolTipText("");
		jp_mem.setBounds(20, 70, 335, 200);
		jp1.add(jp_mem);
		
		

		
		for(int i = 0; i < str_mem.length; i++) {
			jlb_mem[i] = new JLabel(str_mem[i]);
			jp_mem.add(jlb_mem[i]);
			jtf_mem[i] = new JTextField();
			jp_mem.add(jtf_mem[i]);
		}
		
		jlb_mem[0].setBounds(15, 40, 55, 20);
		jtf_mem[0].setBounds(75, 40, 100, 20);
		
		jlb_mem[1].setBounds(195, 40, 55, 20);
		jtf_mem[1].setBounds(245, 40, 75, 20);
		
		jlb_mem[2].setBounds(15, 75, 55, 20);
		jtf_mem[2].setBounds(75, 75, 100, 20);
		
		jlb_mem[3].setBounds(15, 110, 90, 20);
		jtf_mem[3].setBounds(110, 110, 65, 20);
		jtf_mem[3].setEditable(false);
		
		jlb_mem[4].setBounds(195, 110, 90, 20);
		jtf_mem[4].setBounds(255, 110, 65, 20);
		jtf_mem[4].setEditable(false);
		
		
		
		btn_mem1 = new JButton("회원 검색");
		btn_mem1.setBounds(130, 160, 90, 20);
		btn_mem1.setBackground(Color.gray);
		btn_mem1.setFocusable(false);
		
		
		btn_mem2 = new JButton("검색 취소");
		btn_mem2.setBounds(230, 160, 90, 20);
		btn_mem2.setBackground(Color.gray);
		btn_mem2.setFocusable(false);
		
		jp_mem.add(btn_mem1); jp_mem.add(btn_mem2);
	}
	
	private void setBookInfo() {
		jp_bk = new JPanel();
		jp_bk.setBorder(new TitledBorder(null, "대출 도서 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jp_bk.setToolTipText("");
		jp_bk.setBounds(370, 70, 335, 200);
		jp_bk.setLayout(null);
		jp1.add(jp_bk);
		
		for(int i = 0; i < str_bk.length; i++) {
			jlb_bk[i] = new JLabel(str_bk[i]);
			jp_bk.add(jlb_bk[i]);
			jtf_bk[i] = new JTextField();
			jtf_bk[i].setEditable(false);
			jp_bk.add(jtf_bk[i]);
		}
		
		jlb_bk[0].setBounds(15, 25, 55, 20);
		jtf_bk[0].setBounds(75, 25, 90, 20);
		jtf_bk[0].setEditable(true);
		
		jlb_bk[1].setBounds(185, 25, 100, 20);
		jtf_bk[1].setBounds(275, 25, 45, 20);
		jtf_bk[1].setHorizontalAlignment(JTextField.CENTER);
		
		jlb_bk[2].setBounds(15, 60, 55, 20);
		jtf_bk[2].setBounds(75, 60, 245, 20);
		
		jlb_bk[3].setBounds(15, 95, 90, 20);
		jtf_bk[3].setBounds(75, 95, 90, 20);
		
		jlb_bk[4].setBounds(185, 95, 50, 20);
		jtf_bk[4].setBounds(235, 95, 85, 20);
		
		jlb_bk[5].setBounds(15, 130, 90, 20);
		jtf_bk[5].setBounds(75, 130, 80, 20);
		
		jlb_bk[6].setBounds(175, 130, 90, 20);
		jtf_bk[6].setBounds(245, 130, 75, 20);
		
		btn_bk1 = new JButton("도서 검색");
		btn_bk1.setBounds(130, 160, 90, 20);
		btn_bk1.setBackground(Color.gray);
		btn_bk1.setFocusable(false);
		
		
		btn_bk2 = new JButton("검색 취소");
		btn_bk2.setBounds(230, 160, 90, 20);
		btn_bk2.setBackground(Color.gray);
		btn_bk2.setFocusable(false);
		
		jp_bk.add(btn_bk1); jp_bk.add(btn_bk2);
	}
	
	private void setButton() {
		btn_issue = new JButton("대출");		
		btn_issue.setBounds(520, 25, 80, 40);
		btn_issue.setBackground(Color.gray);
		//btn_issue.setForeground(Color.white);
		btn_issue.setFocusable(false);
		
		btn_cancel = new JButton("취소");
		btn_cancel.setBounds(620, 25, 80, 40);
		btn_cancel.setBackground(Color.gray);
		btn_cancel.setFocusable(false);
		
		jp1.add(btn_issue); jp1.add(btn_cancel);
		
	}
	
	private void setTable() {
		table = new JTable(model);
		
//		// 셀 크기 지정
//		table.getColumnModel().getColumn(0).setPreferredWidth(75);
//		table.getColumnModel().getColumn(1).setPreferredWidth(220);

//		// 셀 안의 텍스트 정렬 지정
//		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//		center.setHorizontalAlignment(SwingConstants.CENTER);
//		table.getColumnModel().getColumn(4).setCellRenderer(center);
//		table.getColumnModel().getColumn(5).setCellRenderer(center);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 300, 685, 200);

		jp1.add(scrollPane);
	}
	
	
	private void setEmpty(JTextField[] jtf) {
		for(int i = 0; i < jtf.length; i++) {
			jtf[i].setText("");
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object click = e.getSource();
		if(click == btn_cancel) {
			setEmpty(jtf_mem);
			setEmpty(jtf_bk);			
		}else if (click == btn_mem2) {
			setEmpty(jtf_mem);
		}else if (click == btn_bk2) {
			setEmpty(jtf_bk);	
		}else if (click == btn_mem1) {
			model.setRowCount(0);
			searchMember();
		}else if (click == btn_bk1) {
			searchBook();
		}
		
	}
	
	private void searchMember() {
		String searchCol, searchItem;
		String[] colnames = {"m_id", "m_name", "m_phone"};
		boolean[] valid = new boolean[3];
		
		// 회원번호, 회원이름, 전화번호 중 하나만 채워져 있을 때 textfield 값과 검색할 열이름 받아와서 검색하기
		for(int i = 0; i < 3; i++) {
			valid[i] = !jtf_mem[i%3].getText().equals("") && jtf_mem[(i+1)%3].getText().equals("") && jtf_mem[(i+2)%3].getText().equals("");
			if(valid[i]) {
				searchCol = colnames[i];
				searchItem = jtf_mem[i].getText();
				selectMember (searchCol, searchItem);
				break;
			}
		}
		
		// 만약 2개 이상 채워져 있다면 경고창 띄우기
		if(!valid[0]&&!valid[1]&&!valid[2]){
			JOptionPane.showMessageDialog(null, "1가지의 검색조건만 입력해 주세요.", "Message", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	
	private void selectMember (String searchCol, String searchItem) {
		Connection conn = ConnectDB.getConnection();
		
		// = ?
		StringBuffer sql = new StringBuffer();
		sql.append("select M_ID, M_NAME, M_PHONE, M_EMAIL ");
		sql.append("from member ");
		sql.append("where " + searchCol + "= ? ");
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, searchItem);
			
			ResultSet rs = pstmt.executeQuery();
             while(rs.next()){           
                 model.addRow(new Object[]{rs.getString("M_ID"),rs.getString("M_NAME"),
                                             rs.getString("M_PHONE"),rs.getString("M_EMAIL")});
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


		// like ?
		StringBuffer sql2 = new StringBuffer();
		sql2.append("select M_ID, M_NAME, M_PHONE, M_EMAIL ");
		sql2.append("from member ");
		sql2.append("where " + searchCol + " like ? and not " + searchCol + " = ? ");
		
		try {
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setString(1, "%" + searchItem + "%");
			pstmt.setString(2, searchItem);

			ResultSet rs = pstmt.executeQuery();
             while(rs.next()){            
                 model.addRow(new Object[]{rs.getString("M_ID"),rs.getString("M_NAME"),
                         rs.getString("M_PHONE"),rs.getString("M_EMAIL")});
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
	} // end of selectMember()
	

	private void searchBook() {
		conn = ConnectDB.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select b.BookName, b.Author, b.publisher, i.issuedate, i.duedate ");
		sql.append("from issue i left join book b on i.bookid = b.bookid ");
		sql.append("where i.bookid = ? ");
		
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, jtf_bk[0].getText());
			
			ResultSet rs = pstmt.executeQuery();
			
             if(rs.next()){
            	jtf_bk[1].setText("불가능");
            	jtf_bk[1].setForeground(Color.red);
                jtf_bk[2].setText(rs.getString(1));
                jtf_bk[3].setText(rs.getString(2));
                jtf_bk[4].setText(rs.getString(3));
                jtf_bk[5].setText(rs.getString(4).substring(0,10));
                jtf_bk[6].setText(rs.getString(5).substring(0,10));
             }
             else {
          		StringBuffer sql2 = new StringBuffer();
         		sql2.append("select BookName, Author, publisher ");
         		sql2.append("from book ");
         		sql2.append("where bookid = ? ");
        		pstmt = null;
        		pstmt = conn.prepareStatement(sql2.toString());
    			pstmt.setString(1, jtf_bk[0].getText());
    			
    			ResultSet rs2 = pstmt.executeQuery();
    			rs2.next();
            	jtf_bk[1].setText("가능");
            	jtf_bk[1].setForeground(Color.blue);
                jtf_bk[2].setText(rs2.getString(1));
                jtf_bk[3].setText(rs2.getString(2));
                jtf_bk[4].setText(rs2.getString(3));
                jtf_bk[5].setText(dateformat.format(System.currentTimeMillis()));
                jtf_bk[6].setText(dateformat.format(System.currentTimeMillis()+(7 * 24 * 60 * 60 * 1000)));
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
	}
	
	
}
