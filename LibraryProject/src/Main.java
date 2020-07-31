import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.generic.ISUB;

public class Main extends JFrame{
	
	JPanel jp;
	CardLayout card;
	AddNewBook ad;
	Search s;
	IssueBook i;
	
	public Main() {
		super("Main");
		setBounds(600, 200, 1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//setLayout(new CardLayout());
		setLayout(null);
		
		Container c = getContentPane();
		//c.setBackground(Color.white);
		
		titlePanel tp = new titlePanel();
		tp.setBounds(5, 5, 990, 100);
		c.add(tp);
		
		menuPanel mp = new menuPanel();
		mp.setBounds(5, 105, 200, 590);
		c.add(mp);
		
		
		
		jp = new JPanel();
		jp.setBounds(210, 105, 785, 590);
		card = new CardLayout(5, 5);
		jp.setLayout(card);
		
		displayPanel dp = new displayPanel();
		jp.add(dp, "dp");

		ad = new AddNewBook();
		jp.add(ad, "ad");
		
		s = new Search();
		jp.add(s,"s");
		
		
		i = new IssueBook();
		jp.add(i, "i");
		
		c.add(jp);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	
	
	class titlePanel extends JPanel{
		JLabel title;
		public titlePanel() {
			setBackground(Color.white);
			
			title = new JLabel("Library Program");
			title.setForeground(Color.gray);
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Consolas", Font.BOLD, 50));
			
			add(title);
		}
	}
	
	
	
	class menuPanel extends JPanel {
		JButton jbtn, jbtn2, jbtn3;
		public menuPanel() {
			setLayout(null);
			setBackground(Color.white);
			jbtn = new JButton("Add New Book");
			jbtn.setBounds(25, 100, 150, 30);
			jbtn.setFont(new Font("Consolas", Font.BOLD, 15));
			jbtn.setBackground(Color.orange);
			jbtn.setForeground(Color.white);
			add(jbtn);
			
			jbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(jp, "ad");
				}
			});
			
			jbtn2 = new JButton("Search");
			jbtn2.setBounds(25, 150, 150, 30);
			jbtn2.setFont(new Font("Consolas", Font.BOLD, 15));
			jbtn2.setBackground(Color.orange);
			jbtn2.setForeground(Color.white);
			add(jbtn2);
			
			jbtn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(jp, "s");
				}
			});
			
			jbtn3 = new JButton("Issue Book");
			jbtn3.setBounds(25, 200, 150, 30);
			jbtn3.setFont(new Font("Consolas", Font.BOLD, 15));
			jbtn3.setBackground(Color.orange);
			jbtn3.setForeground(Color.white);
			add(jbtn3);
			
			jbtn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					card.show(jp, "i");
				}
			});
			
			
		}
		
	}
	
	class displayPanel extends JPanel{
		JLabel jlb;
		public displayPanel() {

			jlb = new JLabel("main");
		}
	}
	
	
}




/*
1. 입고(Add New Book)
2. 대여(Issue Book)
3. 검색기능(Book Details)
4. 반납(Return Book)
5. 대여관리(Issued Book Details) + 5. 연체관리
6. 연장시스템
7. 회원가입 (Registration)




*/