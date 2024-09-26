package DemoFile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DemoFileChooser extends JFrame {

	private JTextArea area;
	private JButton btnBrowse;

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JButton getBtnBrowse() {
		return btnBrowse;
	}

	public void setBtnBrowse(JButton btnBrowse) {
		this.btnBrowse = btnBrowse;
	}

	public DemoFileChooser() throws IOException {
		this.setTitle("Demo FileChooser");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel north = new JPanel();
		btnBrowse = new JButton("Open a file ...");
		north.add(btnBrowse);
		this.add(north, BorderLayout.NORTH);

		JPanel center = new JPanel(new GridLayout(1, 1));
		area = new JTextArea();
//		area.disable();
		JScrollPane pane = new JScrollPane(area);
		center.add(pane);
		area.setMargin(new Insets(5, 5, 5, 5));
		this.add(center, BorderLayout.CENTER);

		ActionListener listener = new Controller(this);
		btnBrowse.addActionListener(listener);
	}

	public static void main(String[] args) throws IOException {
		new DemoFileChooser().setVisible(true);
	}
}
