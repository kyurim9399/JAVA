package Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Calculator extends JFrame{
	JLabel info, equation;
	public Calculator() {
		super("Calculator Text");
		setBounds(500, 300, 400, 600);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		
		Container c = getContentPane();
		c.setBackground(Color.white);
		
		EquationField EF = new EquationField();
		EF.setBounds(5, 5, 385, 150);
		c.add(EF);	
		
		ButtonField BF = new ButtonField();
		BF.setBounds(5, 160, 385, 405);
		c.add(BF);
		
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	
	// Set Equation Field
	class EquationField extends JPanel{

		public EquationField() {
			setLayout(new GridLayout(2,1));
			setBackground(Color.white);
			
			info = new JLabel("Please Enter The Number");
			info.setBackground(Color.WHITE);
			info.setForeground(Color.gray);
			info.setHorizontalAlignment(SwingConstants.RIGHT);
			info.setFont(new Font("Consolas", 0, 20));
			
			
			equation = new JLabel(""); 
			equation.setBackground(Color.WHITE);
			equation.setHorizontalAlignment(SwingConstants.RIGHT);//텍스트필드안에 들어오는 텍스트를 오른쪽으로 정렬
			equation.setFont(new Font("Consolas", Font.BOLD, 50));

			
			add(info);
			add(equation);	
		}
	}
	
	
	
	
	
	//Set Button
	class ButtonField extends JPanel{
		String[] buttonName = {"7", "8","9","÷","4","5","6","×","1","2","3", "-", "C", "0", "=", "+"} ;
		
		public ButtonField() {
			setLayout(new GridLayout(4, 4, 5, 5));
			setBackground(Color.white);
			
			JButton[] jbt = new JButton[buttonName.length];
				
			for(int i = 0; i < buttonName.length; i++) {
				jbt[i] = new JButton(buttonName[i]);
				if((i+1)%4==0) {
					jbt[i].setBackground(Color.ORANGE);					
				}
				else {
					jbt[i].setBackground(Color.darkGray);
					if(i == 12 || i ==14) {
						jbt[i].setBackground(Color.gray);
					}
				}
				jbt[i].setForeground(Color.white);
				jbt[i].setFont(new Font("Consolas", Font.BOLD, 20));
				
				add(jbt[i]);
				ClickButton click = new ClickButton();
				jbt[i].addActionListener(click);
			}
			
		}
		
	}
	
	
	
	
	
	
	// Click Event Class
	class ClickButton implements ActionListener{
		ArrayList<Double> num = new ArrayList<Double>();
		ArrayList<String> oper = new ArrayList<String>();
		double result = 0.0, temp = 0.0;
		
		
		
		public void remove(int i) {
			num.remove(i+1);
			num.remove(i);
			num.add(i, result);
			oper.remove(i);	
		}//cal() end
		
		
		
		
		public void cal() {
			StringTokenizer strings = new StringTokenizer(equation.getText(), "+-×÷", true);
			String[] str = new String[strings.countTokens()];
			
			for(int i = 0; strings.hasMoreTokens(); i++) {
				if(i%2 == 0) {
					num.add(Double.parseDouble(strings.nextToken()));
				}
				else {
					oper.add(strings.nextToken());
				}
			}
			
			while(oper.size()>0) {
				for(int i = 0; i < oper.size(); i++) {
					if(oper.get(i).equals("×")) {
						result = num.get(i) * num.get(i+1);
						remove(i);
					}
					else if (oper.get(i).equals("÷")){
						result = num.get(i) / num.get(i+1);
						remove(i);
					}
				}
				
				
				for(int i = 0; i <oper.size(); i++) {
					if(oper.get(i).equals("+")) {
						result = num.get(i) + num.get(i+1);
						remove(i);
					}
					else {
						result = num.get(i) - num.get(i+1);
						remove(i);
					}
				}				
			} // while() end
			
	
			num.remove(0);
			
			
			// 결과가 정수면 소수점 보이지 않게하기
			if(result % 1 == 0) {
				equation.setText(Integer.toString((int) result));
			}
			else {
				equation.setText(Double.toString(Math.round(result*100000)/100000.0));					
			}
		}//equal() end
		
		
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String eText =  e.getActionCommand();
			String textLine = equation.getText();
			
			if(eText.equals("=")) {
				// 맨 처음에 연산자가 들어온경우
				if(textLine.equals("")) {
					equation.setText("");
				}else {
					//식의 마지막에 연산자가 오지는 않았는지 확인
					char last = textLine.charAt(textLine.length()-1);
					boolean isLastOper = (last == '+'|| last == '-'|| last == '×' || last == '÷');
					if(isLastOper) {
						info.setText("Operator cannot come at the end of an expression.");
						info.setFont(new Font("Consolas", 0, 13));
					}
					else {
						cal();											
					}
				}
			}
			else if(eText.matches("C")) {
				equation.setText("");
			}
			else if(eText.equals("+")||eText.equals("-")||
						eText.equals("×")||eText.equals("÷")) {
				if(textLine.equals("")) {
					equation.setText("");
				}
				else {
					// 두개의 연산자가 연속으로 입력될 경우 마지막 연산자를 받기
					char last = textLine.charAt(textLine.length()-1);
					boolean isLastOper = (last == '+'|| last == '-'|| last == '×' || last == '÷');
					if(isLastOper) {
						String temp = textLine.substring(0,textLine.length()-1).concat(eText);
						equation.setText(temp);
					}
					else {
						equation.setText(equation.getText() + eText);				
					}					
				}
			}
			else if(eText.equals("0")) {
				if(textLine.equals("")) {
					equation.setText("");
				}
				else {
					equation.setText(textLine + eText);	
					info.setText("Please Enter The Number");
					info.setFont(new Font("Consolas", 0, 20));
				}
			}
			else {
				equation.setText(textLine + eText);	
				info.setText("Please Enter The Number");
				info.setFont(new Font("Consolas", 0, 20));
			}
		
			
		}//actionPerformed() end
		
	}//class ClickButton end
	
}