package bwd.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import bwd.action.Action;
import bwd.interfaces.IfSheet1;
import bwd.util.ExeclException;

public class MainUI implements ActionListener {

	private JFrame frame = new JFrame("Execl转换工具 v1.2");
	private Container c = frame.getContentPane();
	private JLabel label = new JLabel("HELLO");
	private JTextField pathname = new JTextField(30);
	private JTextField sheetName = new JTextField("Report", 30);
	private JTextField destpathname = new JTextField(30);
	private JButton btnSubmit = new JButton("提交");
	private JButton btnClose = new JButton("关闭");
	
	public MainUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		c.setLayout(new BorderLayout());
		initFrame();
		frame.setVisible(true);
	}
	
	public void initFrame() {
		// 顶部
		JPanel headPanel = new JPanel();
		headPanel.add(label);
		c.add(headPanel, BorderLayout.NORTH);
		
		// 中部
		JPanel centerPanel = new JPanel(new BorderLayout());

		JPanel pathInfo = new JPanel();
		pathInfo.add(new JLabel("待转换文件路径:"));
		pathInfo.add(this.pathname);
		this.pathname.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				String s = pathname.getText();
				if (-1 == s.lastIndexOf("\\")) {
					destpathname.setText("C:\\abc.xls");
				}
				else {
					destpathname.setText(s.substring(0, s.lastIndexOf("\\")) + "\\abc.xls");
				}
			}
		});
		centerPanel.add(pathInfo, BorderLayout.NORTH);
		
		JPanel sheetInfo = new JPanel(); 
		sheetInfo.add(new JLabel("sheet名:"));
		sheetInfo.add(this.sheetName);
		centerPanel.add(sheetInfo, BorderLayout.CENTER);

		JPanel destpathInfo = new JPanel(); 
		destpathInfo.add(new JLabel("生成路径:"));
		destpathInfo.add(this.destpathname);
		centerPanel.add(destpathInfo, BorderLayout.SOUTH);
		
		c.add(centerPanel, BorderLayout.CENTER);
		
		// 底部
		JPanel footPanel = new JPanel();
		this.btnSubmit.addActionListener(this);
		footPanel.add(btnSubmit);
		this.btnClose.addActionListener(this);
		footPanel.add(btnClose);
		c.add(footPanel, BorderLayout.SOUTH);
	}
	public void closeFrame() {
		frame.dispose();
	}
	
	// C:\Users\Administrator\Desktop\3.171.xls
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnSubmit)) {
		
			Action action = new Action();
			//读取页面数据到全局变量中
			IfSheet1.setSrcPathname(this.pathname.getText());
			IfSheet1.setSheetname(this.sheetName.getText());
			IfSheet1.setDestPathname(this.destpathname.getText());

			try {
				if (action.action()) {
					this.label.setText("生成成功!\n" + "生成路径：" + IfSheet1.getDestPathname());
				}
				else {
					this.label.setText("生成失败！\n");
				}
			} catch (ExeclException e1) {
				this.label.setText(e1.getMessage());
			}
		}
		else if (e.getSource().equals(this.btnClose)) {
			closeFrame();
		}
	}
	
	public static void main(String[] args) {
		new MainUI();
	}

}
