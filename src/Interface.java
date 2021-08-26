import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Interface {

	private JFrame frame;
	private JFrame frameFileChooser;
	private JFileChooser selecionador;
	private JTextArea textAreaCaixaDeTexto;
	private String caminhoArquivoAberto = "Arquivo não salvo";
	private JLabel lblArquivo;

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
	    toolBar.setBounds(0, 0, 156, 547);
	    toolBar.setOrientation(SwingConstants.VERTICAL);
	    frame.getContentPane().add(toolBar);
	    Dimension toolBarMin = new Dimension(150,500);
	    toolBar.setMinimumSize(toolBarMin);

	    JPanel panel = new JPanel();
	    panel.setBorder(new EmptyBorder(0, 10, 0, 10));
	    panel.setBounds(0, 0, 10, 10);
	    toolBar.add(panel);
	    panel.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panelToolBar = new JPanel();
	    panel.add(panelToolBar, BorderLayout.CENTER);
	    
	    int width100 = toolBar.getWidth() - (panel.getWidth() + panel.getWidth())-4;
	    int y = 5; 

	    y = createJButton(panelToolBar, width100, y, "Novo [CTRL-N]", "/imgs/new_small.png");
	    y = createJButton(panelToolBar, width100, y, "Abrir [CTRL-O]", "/imgs/open_small.png");
	    y = createJButton(panelToolBar, width100, y, "Salvar [CTRL-S]", "/imgs/save_small.png");
	    y = createJButton(panelToolBar, width100, y, "Copiar [CTRL-C]", "/imgs/copy_small.png");
	    y = createJButton(panelToolBar, width100, y, "Colar [CTRL-V]", "/imgs/copy_small.png");
	    y = createJButton(panelToolBar, width100, y, "Recortar [CTRL-X]", "/imgs/cut_small.png");
	    y = createJButton(panelToolBar, width100, y, "Compilar [F7]", "/imgs/compile_small.png");
	    y = createJButton(panelToolBar, width100, y, "Equipe [F1]", "/imgs/team_small.png");
	    
	    
	    panelToolBar.setLayout(null);
	    panel.add(panelToolBar);
	    
	    lblArquivo = new JLabel(caminhoArquivoAberto);
	    lblArquivo.setBounds(0, 547, 884, 14);
	    frame.getContentPane().add(lblArquivo);
	    Dimension labelMin = new Dimension(900,25);
	    lblArquivo.setMinimumSize(labelMin);
	    
	    JSplitPane splitPane = new JSplitPane();
	    splitPane.setBounds(143, 0, 741, 547);
	    splitPane.setResizeWeight(0.8);
	    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    frame.getContentPane().add(splitPane);
	    
	    textAreaCaixaDeTexto = new JTextArea();
	    splitPane.setLeftComponent(textAreaCaixaDeTexto);  
	    textAreaCaixaDeTexto.setBorder(new NumberedBorder());
	    JScrollPane scrollCaixaDeTexto = new JScrollPane (textAreaCaixaDeTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollCaixaDeTexto);
	    
	    JTextArea textAreaConsole = new JTextArea();
	    textAreaConsole.setEditable(false);
	    splitPane.setRightComponent(textAreaConsole);
	    JScrollPane scrollConsole = new JScrollPane (textAreaConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollConsole);
	    
		frameFileChooser = new JFrame();
		frameFileChooser.setVisible(false);
		selecionador = new JFileChooser();
		selecionador.setVisible(true);
		frameFileChooser.add(selecionador);
	}

	private int createJButton(JPanel panelToolBar, int width100, int y, String legenda, String urlArquivo) {
		JButton btn = new JButton(legenda, new ImageIcon(this.getClass().getResource(urlArquivo)));
		btn.setHorizontalAlignment(SwingConstants.LEADING);
	    btn.setBounds(0, y, width100, 30);
	    btn.setFont(new Font("Arial", Font.PLAIN, 9));
	    if(legenda.contains("Abrir")) {
	    	abrirArquivo(btn);
	    }else if(legenda.contains("Salvar")) {
	    	salvarArquivo(btn);
	    }
	    	
	    panelToolBar.add(btn);
	    return y + 40;
	}
	
	private void abrirArquivo(JButton btn) {
	    btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		int i = selecionador.showDialog(frame, "Abrir");
	    		if(JFileChooser.APPROVE_OPTION == i) {
	    			StringBuilder textoCompleto = new StringBuilder();
	    			try {
	    				File file = selecionador.getSelectedFile();
		    			caminhoArquivoAberto = file.getAbsolutePath();
	    		        Scanner myReader = new Scanner(file);
	    		        while (myReader.hasNextLine()) {
	    		        	textoCompleto.append(myReader.nextLine()).append("\n");
	    		        }
	    		        myReader.close();
	    			} catch (FileNotFoundException ex) {
	    				System.out.println("An error occurred.");
	    				ex.printStackTrace();
	    			}
	    			textAreaCaixaDeTexto.setText(textoCompleto.toString());
	    			lblArquivo.setText(caminhoArquivoAberto);
	    		}
	        }
	    });
	}
	
	private void salvarArquivo(JButton btn) {
	    btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
    			try {
    				if(caminhoArquivoAberto.equals("Arquivo não salvo")) {
    					int i = selecionador.showDialog(frame, "Salvar");
    		    		if(JFileChooser.APPROVE_OPTION == i) {
    		    			caminhoArquivoAberto = selecionador.getSelectedFile().getAbsolutePath();
            				FileWriter file = new FileWriter(caminhoArquivoAberto);
            				file.write(textAreaCaixaDeTexto.getText());
            				file.close();
        	    			lblArquivo.setText(caminhoArquivoAberto);
    		    		}
    				} else {
        				FileWriter file = new FileWriter(caminhoArquivoAberto);
        				file.write(textAreaCaixaDeTexto.getText());
        				file.close();
    				}
    			} catch (IOException ex) {
    				System.out.println("An error occurred.");
    				ex.printStackTrace();
    			}
	        }
	    });
	}
}
