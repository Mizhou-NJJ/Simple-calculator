package com.OK.zhou;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main{
   public static void main(String[] args) {
	new MyFframe("计算器");
}
}
class MyFframe extends JFrame{
	/*
	 * 由symbol,symbol_2保存输入的符号，numString保存用户输入的数字, endresult保存计算结果;
	 * 第一次输入符号时不自动计算结果，用isFirstSymbol判断是否是第一次输入符号
	 * 由Calculatel类的静态方法cal(String str1,String str2)计算结果
	 * 
	 */
	private static JTextField field;
	private static String numString="";
    private static String symbol="";
    private static String endresult="";
    private static boolean isFirstSymbol=true;
    private  static String symbol_2="";
	public MyFframe(String message) {
		super(message);
		Container container=getContentPane();
		JPanel panel=new JPanel(new BorderLayout());
         JMenuBar menuBar=new JMenuBar();
         setJMenuBar(menuBar);
         JMenu m1=new JMenu("编辑(E)");
         JMenuItem copyItem=new JMenuItem("复制(C) Ctrl+C");
         JMenuItem pasteItem=new JMenuItem("粘贴(P) Ctrl+V");
         m1.add(copyItem);
         m1.add(pasteItem);
         JMenu m2=new JMenu("查看(V)");
         JRadioButton scientistButton=new JRadioButton("标准型");
         JRadioButton standdartButton=new JRadioButton("科学型");
         JCheckBox numGroupBox=new JCheckBox("数字分组");
         ButtonGroup group=new ButtonGroup();
         group.add(scientistButton);
         group.add(standdartButton);
         m2.add(standdartButton);
         m2.add(scientistButton);
         m2.addSeparator();
         m2.add(numGroupBox);
         JMenu m3=new JMenu("帮助(H)");
         JMenuItem helpItem=new JMenuItem("帮助主题(H)");
         JMenuItem checkItem=new JMenuItem("关于计算器(A)");
         m3.add(helpItem);
         m3.addSeparator();
         m3.add(checkItem);
         
         menuBar.add(m1);
         menuBar.add(m2);
         menuBar.add(m3);
         //以上是菜单项
		JPanel centerJPanel=new JPanel(new BorderLayout());
		field=new JTextField("0");
		field.setHorizontalAlignment(JTextField.RIGHT);
		centerJPanel.add(field,BorderLayout.CENTER);
		JPanel southJPanel=new JPanel(new BorderLayout());
		JPanel sunNorthJPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Button button=new Button("          ");
		
		JButton backspase=new JButton("     Backspace     ");
		backspase.setForeground(Color.red);
		backspase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				try {
				numString=numString.substring(0, numString.length()-1);
				field.setText(numString);
				} catch (Exception e) {
					//什么也不做
				}
			}
		});
		
		JButton CE=new JButton("         CE        ");
		CE.setForeground(Color.red);
		CE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		JButton C=new JButton("        C       ");
		C.setForeground(Color.red);
		C.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				field.setText("0");
				endresult="";
				numString="";
				symbol="";
				symbol_2="";
				isFirstSymbol=true;
			}
		});
		sunNorthJPanel.add(button);
		sunNorthJPanel.add(backspase);
		sunNorthJPanel.add(CE);
		sunNorthJPanel.add(C);
		JPanel sunWestJPanel=new JPanel(new GridLayout(4, 1));
		String Mx[]= {"MC","MR","MS","M+"};
		JButton []mxButtons=new JButton[4];
		for(int i=0;i<4;i++) {
			mxButtons[i]=new JButton(Mx[i]);
			mxButtons[i].setFont(new Font("仿宋", Font.BOLD, 15));
			mxButtons[i].setForeground(Color.red);
			sunWestJPanel.add(mxButtons[i]);
		}
		
		JPanel sunCenterJPanel=new JPanel();
		sunCenterJPanel.setLayout(new GridLayout(4, 5, 10, 10));
		JButton [] jButtons=new JButton[10];
		for(int i=0;i<10;i++) {
			jButtons[i]=new JButton(""+i);
			jButtons[i].addActionListener(new Num());
			jButtons[i].setForeground(Color.BLUE);
			jButtons[i].setFont(new Font("宋体", Font.BOLD,15));
		}
		JButton chuButton=new JButton("/");
		chuButton.setForeground(Color.RED);
		chuButton.addActionListener(new Symbol());
		
		JButton sqrtButton=new JButton("sqrt");
		sqrtButton.setForeground(Color.BLUE);
		sqrtButton.addActionListener(new Symbol());
		
		JButton chengButton=new JButton("*");
		chengButton.setForeground(Color.red);
		chengButton.addActionListener(new Symbol());
		
		JButton onechuxButton=new  JButton("1/x");
		onechuxButton.setForeground(Color.blue);
		onechuxButton.addActionListener(new Symbol());
		
		JButton equlButton=new JButton("=");
		equlButton.setForeground(Color.red);
		equlButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				field.setText("");
				field.setText(Calculate.cal(endresult, numString, symbol));
				
			}
		});
		
		JButton jianButton=new JButton("-");
		jianButton.setForeground(Color.red);
		jianButton.addActionListener(new Symbol());
		
		JButton addButton=new JButton("+");
		addButton.setForeground(Color.red);
		addButton.addActionListener(new Symbol());
		
		JButton addJianButton=new JButton("+/-");
		addJianButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				numString="-";
			}
		});
		
		JButton poingButton=new JButton(".");
		poingButton.addActionListener(new Num());
		
		JButton persentButton=new JButton("%");
		persentButton.setForeground(Color.blue);
		persentButton.addActionListener(new Symbol());
		
		sunCenterJPanel.add(jButtons[7]);
		sunCenterJPanel.add(jButtons[8]);
		sunCenterJPanel.add(jButtons[9]);
		sunCenterJPanel.add(chuButton);
		sunCenterJPanel.add(sqrtButton);
		sunCenterJPanel.add(jButtons[4]);
		sunCenterJPanel.add(jButtons[5]);
		sunCenterJPanel.add(jButtons[6]);
		sunCenterJPanel.add(chengButton);
		sunCenterJPanel.add(persentButton);
		sunCenterJPanel.add(jButtons[1]);
		sunCenterJPanel.add(jButtons[2]);
		sunCenterJPanel.add(jButtons[3]);
		sunCenterJPanel.add(jianButton);
		sunCenterJPanel.add(onechuxButton);
		sunCenterJPanel.add(jButtons[0]);
		sunCenterJPanel.add(addJianButton);
		sunCenterJPanel.add(poingButton);
		sunCenterJPanel.add(addButton);
		sunCenterJPanel.add(equlButton);
		southJPanel.add(sunNorthJPanel,BorderLayout.NORTH);
		southJPanel.add(sunCenterJPanel,BorderLayout.CENTER);
		southJPanel.add(sunWestJPanel,BorderLayout.WEST);
		panel.add(centerJPanel,BorderLayout.CENTER);
		panel.add(southJPanel,BorderLayout.SOUTH);
		container.add(panel);
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	static class Num implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			numString+=e.getActionCommand();
			field.setText("");
			field.setText(numString);
		}
	}
	
	
	static class Symbol implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			field.setText("");
			symbol=e.getActionCommand().substring(0, 1);
			// TODO 自动生成的方法存根
			if(isFirstSymbol) {
				endresult=numString;
				isFirstSymbol=false;
			}
			else{
					if(selectSymbol(symbol)) {
						
						endresult=Calculate.cal(endresult, null, symbol);
						field.setText(endresult);
					}
					else {
					endresult=Calculate.cal(endresult, numString, symbol_2);
					field.setText(endresult);
					}
				}
				
				symbol_2=symbol;
				numString="";
		}
		
	}
	/*
	 * 用来判断sqrt和1/x;
	 */
	public static boolean selectSymbol(String symbol) {
		char ch=symbol.charAt(0);
		switch (ch) {
		case 's': 
	    case '1':
			return true;	
		}
		return false;
	}
}


































 