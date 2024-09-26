package DemoFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller implements ActionListener {

	private DemoFileChooser chooser;

	public Controller(DemoFileChooser chooser) {
		super();
		this.chooser = chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(chooser.getBtnBrowse())) {
			JFileChooser file = new JFileChooser();
			file.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents", "txt"));
			file.addChoosableFileFilter(new FileNameExtensionFilter("Java Source", "java"));

			// Hiển thị file đã chọn và kiểm tra
			if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File f = file.getSelectedFile();
				// Kiểm tra đuôi file
				if (f.getName().toLowerCase().endsWith("txt") || f.getName().toLowerCase().endsWith("java")) {
					chooser.getArea().setText("");// Xóa file để hiển thị file mới
					Scanner sc = null;
					try {
						// Đọc file
						sc = new Scanner(new FileReader(f));
						String line = null;
						while (sc.hasNextLine()) {
							line = sc.nextLine();
							chooser.getArea().append(line + "\n");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "File error!");
						return;
					}finally {
						if(sc!=null)
							sc.close();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Select file (*.txt, *.java)");
				}
			}else {
				chooser.getArea().setText("Open command cancelled by user");
			}
		}
	}

}
