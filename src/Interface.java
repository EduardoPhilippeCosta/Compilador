import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class Interface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension frameMin = new Dimension(900,600);
	    frame.setMinimumSize(frameMin);
	    
	    JToolBar toolBar = new JToolBar();
	    toolBar.setOrientation(SwingConstants.VERTICAL);
	    frame.getContentPane().add(toolBar, BorderLayout.WEST);
	    Dimension toolBarMin = new Dimension(150,500);
	    toolBar.setMinimumSize(toolBarMin);
	    
	    JButton btnNewButton = new JButton("Novo [CTRL-N]");
	    toolBar.add(btnNewButton);
	    JButton btnNewButton2 = new JButton("Abrir [CTRL-O]");
	    toolBar.add(btnNewButton2);
	    JButton btnNewButton3 = new JButton("Salvar [CTRL-S]");
	    toolBar.add(btnNewButton3);
	    JButton btnNewButton4 = new JButton("Copiar [CTRL-C]");
	    toolBar.add(btnNewButton4);
	    JButton btnNewButton5 = new JButton("Colar [CTRL-V]");
	    toolBar.add(btnNewButton5);
	    JButton btnNewButton6 = new JButton("Recortar [CTRL-X]");
	    toolBar.add(btnNewButton6);
	    JButton btnNewButton7 = new JButton("Compilar [F7]");
	    toolBar.add(btnNewButton7);
	    JButton btnNewButton8 = new JButton("Equipe [F1]");
	    toolBar.add(btnNewButton8);
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
	    Dimension labelMin = new Dimension(900,25);
	    lblNewLabel.setMinimumSize(labelMin);
	    
	    JSplitPane splitPane = new JSplitPane();
	    splitPane.setResizeWeight(0.8);
	    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	    
	    JTextArea textArea_1 = new JTextArea();
	    splitPane.setLeftComponent(textArea_1);  
	    textArea_1.setBorder(new NumberedBorder());
	    JScrollPane scroll1 = new JScrollPane (textArea_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scroll1);
	    
	    JTextArea textArea_2 = new JTextArea();
	    textArea_2.setEditable(false);
	    splitPane.setRightComponent(textArea_2);
	    JScrollPane scroll2 = new JScrollPane (textArea_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scroll2);
	    
	}

}
