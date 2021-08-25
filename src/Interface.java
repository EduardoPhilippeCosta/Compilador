import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
	    frame.getContentPane().setLayout(null);
	    
	    JToolBar toolBar = new JToolBar();
	    toolBar.setBounds(0, 0, 143, 547);
	    toolBar.setOrientation(SwingConstants.VERTICAL);
	    frame.getContentPane().add(toolBar);
	    Dimension toolBarMin = new Dimension(150,500);
	    toolBar.setMinimumSize(toolBarMin);
	    
	    JPanel panelToolBar = new JPanel();
	    toolBar.add(panelToolBar);
	    
	    JButton btnNovo = new JButton("Novo [CTRL-N]");
	    btnNovo.setBounds(18, 5, 108, 23);
	    btnNovo.setIcon(new ImageIcon("D:\\WorkSpace\\Eclipse\\Compilador\\img\\btn_novo.ico"));
	    JButton btnAbrir = new JButton("Abrir [CTRL-O]");
	    btnAbrir.setBounds(19, 33, 103, 23);
	    JButton btnSalvar = new JButton("Salvar [CTRL-S]");
	    btnSalvar.setBounds(16, 61, 109, 23);
	    JButton btnCopiar = new JButton("Copiar [CTRL-C]");
	    btnCopiar.setBounds(15, 89, 111, 23);
	    JButton btnColar = new JButton("Colar [CTRL-V]");
	    btnColar.setBounds(19, 117, 103, 23);
	    JButton btnRecortar = new JButton("Recortar [CTRL-X]");
	    btnRecortar.setBounds(10, 145, 121, 23);
	    JButton btnCompilar = new JButton("Compilar [F7]");
	    btnCompilar.setBounds(22, 173, 97, 23);
	    JButton btnEquipe = new JButton("Equipe [F1]");
	    btnEquipe.setBounds(18, 202, 104, 23);
	    btnEquipe.setIcon(new ImageIcon("D:\\WorkSpace\\Eclipse\\Compilador\\img\\btn_novo.ico"));
	    panelToolBar.setLayout(null);
	    panelToolBar.add(btnNovo);
	    panelToolBar.add(btnAbrir);
	    panelToolBar.add(btnSalvar);
	    panelToolBar.add(btnCopiar);
	    panelToolBar.add(btnColar);
	    panelToolBar.add(btnRecortar);
	    panelToolBar.add(btnCompilar);
	    panelToolBar.add(btnEquipe);
	    
	    JLabel lblArquivo = new JLabel("Arquivo aberto");
	    lblArquivo.setBounds(0, 547, 884, 14);
	    frame.getContentPane().add(lblArquivo);
	    Dimension labelMin = new Dimension(900,25);
	    lblArquivo.setMinimumSize(labelMin);
	    
	    JSplitPane splitPane = new JSplitPane();
	    splitPane.setBounds(143, 0, 741, 547);
	    splitPane.setResizeWeight(0.8);
	    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    frame.getContentPane().add(splitPane);
	    
	    JTextArea textAreaCaixaDeTexto = new JTextArea();
	    splitPane.setLeftComponent(textAreaCaixaDeTexto);  
	    textAreaCaixaDeTexto.setBorder(new NumberedBorder());
	    JScrollPane scrollCaixaDeTexto = new JScrollPane (textAreaCaixaDeTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollCaixaDeTexto);
	    
	    JTextArea textAreaConsole = new JTextArea();
	    textAreaConsole.setEditable(false);
	    splitPane.setRightComponent(textAreaConsole);
	    JScrollPane scrollConsole = new JScrollPane (textAreaConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollConsole);
	    
	}
}
