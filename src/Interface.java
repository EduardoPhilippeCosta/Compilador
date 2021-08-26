import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

public class Interface {

	private JFrame frame;
	private JFileChooser selecionador;
	private JTextArea textAreaCaixaDeTexto;
	private String caminhoArquivoAberto = "Arquivo não salvo";
	private JLabel lblArquivo;
	private JTextArea textAreaMensagens;
	private String[] accpetExtensions = {"txt"};

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
	    frame.getContentPane().setLayout(new BorderLayout(0, 0));
	    
	    JToolBar toolBar = new JToolBar();
	    toolBar.setBounds(0, 0, 156, 547);
	    toolBar.setOrientation(SwingConstants.VERTICAL);
	    frame.getContentPane().add(toolBar, BorderLayout.WEST);
	    Dimension toolBarMin = new Dimension(150,500);
	    toolBar.setMinimumSize(toolBarMin);
	    
	    int width100 = toolBar.getWidth() - 4;
	    int y = 5; 

	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(8, 1));
	    y = createJButton(panel, width100, y, "Novo [CTRL-N]", "/imgs/new_small.png");
	    y = createJButton(panel, width100, y, "Abrir [CTRL-O]", "/imgs/open_small.png");
	    y = createJButton(panel, width100, y, "Salvar [CTRL-S]", "/imgs/save_small.png");
	    y = createJButton(panel, width100, y, "Copiar [CTRL-C]", "/imgs/copy_small.png");
	    y = createJButton(panel, width100, y, "Colar [CTRL-V]", "/imgs/copy_small.png");
	    y = createJButton(panel, width100, y, "Recortar [CTRL-X]", "/imgs/cut_small.png");
	    y = createJButton(panel, width100, y, "Compilar [F7]", "/imgs/compile_small.png");
	    y = createJButton(panel, width100, y, "Equipe [F1]", "/imgs/team_small.png");
	    toolBar.add(panel);
	    
	    lblArquivo = new JLabel(caminhoArquivoAberto);
	    lblArquivo.setBounds(0, 547, 884, 14);
	    frame.getContentPane().add(lblArquivo, BorderLayout.SOUTH);
	    Dimension labelMin = new Dimension(900,25);
	    lblArquivo.setMinimumSize(labelMin);
	    
	    JSplitPane splitPane = new JSplitPane();
	    splitPane.setBounds(143, 0, 741, 547);
	    splitPane.setResizeWeight(0.8);
	    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	    
	    textAreaCaixaDeTexto = new JTextArea();
	    splitPane.setLeftComponent(textAreaCaixaDeTexto);  
	    textAreaCaixaDeTexto.setBorder(new NumberedBorder());
	    JScrollPane scrollCaixaDeTexto = new JScrollPane (textAreaCaixaDeTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollCaixaDeTexto);
	    
	    textAreaMensagens = new JTextArea();
	    textAreaMensagens.setEditable(false);
	    splitPane.setRightComponent(textAreaMensagens);
	    JScrollPane scrollConsole = new JScrollPane (textAreaMensagens, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    splitPane.add(scrollConsole);
	    
	    
		selecionador = new JFileChooser();
		selecionador.setAcceptAllFileFilterUsed(false);
        FileFilter filter = new FileFilter() {
        	@Override
        	public boolean accept(File file) {
        		if (file.isDirectory()) {
        			return true;
        		} else {
        			String path = file.getAbsolutePath().toLowerCase();
        			for (int i = 0, n = accpetExtensions.length; i < n; i++) {
        				String extension = accpetExtensions[i];
        				if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
        					return true;
        				}
        			}
        		}
        		return false;
        	}

			@Override
			public String getDescription() {
				return ".txt";
			}
        };
		selecionador.setFileFilter(filter);
		selecionador.setVisible(true);
	}

	private int createJButton(JPanel panel, int width100, int y, String legenda, String urlArquivo) {
		JButton btn = new JButton(legenda, new ImageIcon(this.getClass().getResource(urlArquivo)));
		btn.setHorizontalAlignment(SwingConstants.LEADING);
	    btn.setBounds(0, y, width100, 30);
	    btn.setFont(new Font("Arial", Font.PLAIN, 9));
	    btn.setBackground(Color.white);
	    if(legenda.contains("Abrir")) {
	    	btn.addActionListener(new EventoAbrirArquivo());
	    } else if(legenda.contains("Salvar")) {
	    	btn.addActionListener(new EventoSalvarArquivo());
	    } else if(legenda.contains("Novo")) {
	    	btn.addActionListener(new EventoCriarArquivo()); 
	    }else if(legenda.contains("Compilar")) {
		    	btn.addActionListener(new EventoCompilar());
	    } else if(legenda.contains("Equipe")) {
	    	btn.addActionListener(new EventoMostrarEquipe());
	    }
	    
	    panel.add(btn);
	    return y + 40;
	}
	
	private class EventoCompilar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaMensagens.setText(textAreaMensagens.getText()+"\ncompilação de programas ainda não foi implementada");
		}
	}
	
	private class EventoAbrirArquivo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
    		if(validaManipulacaoArquivo(selecionador.showDialog(frame, "Abrir"))) {
    			StringBuilder textoCompleto = new StringBuilder();
    			try {
    				File file = selecionador.getSelectedFile();
    				if(!file.exists()) {
    					JOptionPane.showMessageDialog(frame, "Selecione um arquivo existente por favor."); 
    				}else {
        		        Scanner myReader = new Scanner(file);
        		        while (myReader.hasNextLine()) {
        		        	textoCompleto.append(myReader.nextLine()).append("\n");
        		        }
        		        myReader.close();
            			textAreaCaixaDeTexto.setText(textoCompleto.toString());
            			lblArquivo.setText(caminhoArquivoAberto);
        			}
    			} catch (FileNotFoundException ex) {
    				ex.printStackTrace();
    			}
    		}
		}
	}
	
	private class EventoMostrarEquipe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaMensagens.setText(textAreaMensagens.getText()+"\nMembros da equipe:\nEduardo Philippe Costa\nLucas Reichert\nVítor Gabriel Eduardo\n");
		}
	}
	
	private class EventoSalvarArquivo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(caminhoArquivoAberto.equals("Arquivo não salvo")) {
		    		if(validaManipulacaoArquivo(selecionador.showDialog(frame, "Salvar"))) {
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
    			lblArquivo.setText(caminhoArquivoAberto);
			} catch (IOException ex) {
				ex.printStackTrace();
			}		
		}
	}
	
	private class EventoCriarArquivo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaCaixaDeTexto.setText("");
			textAreaMensagens.setText("");
			lblArquivo.setText(caminhoArquivoAberto);
		}
	}
	
	private boolean validaManipulacaoArquivo(int resultado) {
		if(JFileChooser.APPROVE_OPTION == resultado) {
			String extensaoArquivo = selecionador.getFileFilter().getDescription();
			String path = selecionador.getSelectedFile().getAbsolutePath();
			if(!path.endsWith(extensaoArquivo)) {
				path+=extensaoArquivo;
			}
			caminhoArquivoAberto = path;
			return true;
		}
		return false;
	}
}
