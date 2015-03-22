package dbw.ui.front;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbw.action.Action;

public class ParseExeclUI implements ActionListener {

	private JFrame frame = new JFrame("Execl转换工具");
	private Container c = frame.getContentPane();
	private JLabel label = new JLabel("HELLO");
	private JTextField pathname = new JTextField(30);
	private JTextField sheetName = new JTextField("Report", 30);
	private JButton btnSubmit = new JButton("提交");
	private JButton btnClose = new JButton("关闭");
	
	public ParseExeclUI() {
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
		
		// 中部说明
		JPanel centerPanel = new JPanel(new BorderLayout());

		JPanel pathInfo = new JPanel();
		pathInfo.add(new JLabel("路径�?: "));
		pathInfo.add(this.pathname);
		centerPanel.add(pathInfo, BorderLayout.NORTH);
		
		JPanel sheetInfo = new JPanel(); 
		sheetInfo.add(new JLabel("sheet�?:"));
		sheetInfo.add(this.sheetName);
		centerPanel.add(sheetInfo, BorderLayout.CENTER);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.btnSubmit)) {
			//this.label.setText(this.label.getText() + this.pathname.getText());
			Action action = new Action();
			// C:\Users\Administrator\Desktop\3.171.xls
			action.setSourcePathname(this.pathname.getText());
			action.setSheetName(this.sheetName.getText());
			if (action.action()) {
				this.label.setText("generate OK!");
			}
		}
		else if (e.getSource().equals(this.btnClose)) {
			closeFrame();
		}
	}
	
	public static void main(String[] args) {
		new ParseExeclUI();
	}

}
