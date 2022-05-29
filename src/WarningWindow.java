package cm_machine;
import javax.swing.*;

public class WarningWindow extends JFrame {
	private JLabel warningSign = new JLabel("비밀번호가 틀렸습니다!");
	public WarningWindow() {
		super("경고!");
		warningSign.setSize(250,100);
		this.add(warningSign);
		this.setBounds(100, 100, 250, 100);
		this.setVisible(true);
	}

}
