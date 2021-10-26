package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
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
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;

import controller.Lexico;
import controller.Semantico;
import controller.Sintatico;
import model.LexicalError;
import model.SemanticError;
import model.SyntaticError;

public class Interface {

	private JFrame frame;
	private JFileChooser selecionador;
	private JTextArea textAreaCaixaDeTexto;
	private String caminhoArquivoAberto = "Arquivo não salvo";
	private JLabel lblArquivo;
	private JTextArea textAreaMensagens;
	private String[] accpetExtensions = { "txt" };

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
		Dimension frameMin = new Dimension(900, 600);
		frame.setMinimumSize(frameMin);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 156, 547);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(toolBar, BorderLayout.WEST);
		toolBar.setMinimumSize(new Dimension(150, 500));

		int width100 = toolBar.getWidth() - 4;
		int y = 5;

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 1));
		panel.setMaximumSize(new Dimension(150, 500));

		y = createJButton(panel, width100, y, "Novo [CTRL-N]", "/imgs/new_small.png");
		y = createJButton(panel, width100, y, "Abrir [CTRL-O]", "/imgs/open_small.png");
		y = createJButton(panel, width100, y, "Salvar [CTRL-S]", "/imgs/save_small.png");
		y = createJButton(panel, width100, y, "Copiar [CTRL-C]", "/imgs/copy_small.png");
		y = createJButton(panel, width100, y, "Colar [CTRL-V]", "/imgs/copy_small.png");
		y = createJButton(panel, width100, y, "Recortar [CTRL-X]", "/imgs/cut_small.png");
		y = createJButton(panel, width100, y, "Compilar [F7]", "/imgs/compile_small.png");
		y = createJButton(panel, width100, y, "Equipe [F1]", "/imgs/team_small.png");
		toolBar.add(panel);

		criarActionMap(panel);

		lblArquivo = new JLabel(caminhoArquivoAberto);
		lblArquivo.setBounds(0, 547, 900, 25);
		frame.getContentPane().add(lblArquivo, BorderLayout.SOUTH);
		Dimension labelMin = new Dimension(900, 25);
		lblArquivo.setMinimumSize(labelMin);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(143, 0, 741, 547);
		splitPane.setResizeWeight(0.8);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		textAreaCaixaDeTexto = new JTextArea();
		splitPane.setLeftComponent(textAreaCaixaDeTexto);
		textAreaCaixaDeTexto.setBorder(new NumberedBorder());
		JScrollPane scrollCaixaDeTexto = new JScrollPane(textAreaCaixaDeTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane.add(scrollCaixaDeTexto);

		textAreaMensagens = new JTextArea();
		textAreaMensagens.setEditable(false);
		splitPane.setRightComponent(textAreaMensagens);
		JScrollPane scrollConsole = new JScrollPane(textAreaMensagens, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
						if ((path.endsWith(extension)
								&& (path.charAt(path.length() - extension.length() - 1)) == '.')) {
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
		if (legenda.contains("Abrir")) {
			btn.addActionListener(new EventoAbrirArquivo());
		} else if (legenda.contains("Salvar")) {
			btn.addActionListener(new EventoSalvarArquivo());
		} else if (legenda.contains("Novo")) {
			btn.addActionListener(new EventoCriarArquivo());
		} else if (legenda.contains("Compilar")) {
			btn.addActionListener(new EventoCompilar());
		} else if (legenda.contains("Equipe")) {
			btn.addActionListener(new EventoMostrarEquipe());
		} else if (legenda.contains("Copiar")) {
			btn.addActionListener(new EventoCopiar());
		} else if (legenda.contains("Recortar")) {
			btn.addActionListener(new EventoRecortar());
		} else if (legenda.contains("Colar")) {
			btn.addActionListener(new EventoColar());
		}

		panel.add(btn);
		return y + 40;
	}

	private class EventoCompilar extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Integer> lineAnalyzer = new ArrayList<Integer>(); 
			
			try {
				int rows = textAreaCaixaDeTexto.getLineCount();
				
				for (int i = 0; i < rows; i++) {
					int lastPosition = textAreaCaixaDeTexto.getLineEndOffset(i) - 1;
					lineAnalyzer.add(lastPosition);
				}
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			Lexico lexico = new Lexico();
			Sintatico sintatico = new Sintatico();
			Semantico semantico = new Semantico();
			
			lexico.setInput(textAreaCaixaDeTexto.getText(), lineAnalyzer);
			
			try {
				sintatico.parse(lexico, semantico);
				textAreaMensagens.setText("Programa compilado com sucesso!");
			}
			catch ( LexicalError lexicalError ) {
				textAreaMensagens.setText("Erro na linha " + lexicalError.getLine() + " - " + lexicalError.getMessage());
			} 
			catch ( SyntaticError syntaticError ) {
				textAreaMensagens.setText("Erro na linha " + syntaticError.getLine() + " - " + "encontrado: "+ syntaticError.getToken() +" "+ syntaticError.getMessage());		
			}
			catch ( SemanticError semanticError ) {
				//Trata erros semânticos
			}
			
		}
	}

	private class EventoAbrirArquivo extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (validaManipulacaoArquivo(selecionador.showDialog(frame, "Abrir"))) {
				StringBuilder textoCompleto = new StringBuilder();
				try {
					File file = selecionador.getSelectedFile();
					if (!file.exists()) {
						JOptionPane.showMessageDialog(frame, "Selecione um arquivo existente por favor.");
					} else {
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

	private class EventoMostrarEquipe extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaMensagens.setText(textAreaMensagens.getText()
					+ "\nMembros da equipe:\nEduardo Philippe Costa\nLucas Reichert\nVítor Gabriel Eduardo\n");
		}
	}

	private class EventoSalvarArquivo extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (caminhoArquivoAberto.equals("Arquivo não salvo")) {
					if (validaManipulacaoArquivo(selecionador.showDialog(frame, "Salvar"))) {
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

	private class EventoCriarArquivo extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaCaixaDeTexto.setText("");
			textAreaMensagens.setText("");
			caminhoArquivoAberto = "Arquivo não salvo";
			lblArquivo.setText("Arquivo não salvo");
		}
	}

	private class EventoCopiar extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			copiar();
		}
	}

	private class EventoRecortar extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			recortar();
		}
	}

	private class EventoColar extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			colar();
		}
	}

	private boolean validaManipulacaoArquivo(int resultado) {
		if (JFileChooser.APPROVE_OPTION == resultado) {
			String extensaoArquivo = selecionador.getFileFilter().getDescription();
			String path = selecionador.getSelectedFile().getAbsolutePath();
			if (!path.endsWith(extensaoArquivo)) {
				path += extensaoArquivo;
			}
			caminhoArquivoAberto = path;
			return true;
		}
		return false;
	}

	private void copiar() {
		textAreaCaixaDeTexto.copy();
	}

	private void recortar() {
		textAreaCaixaDeTexto.cut();
	}

	private void colar() {
		textAreaCaixaDeTexto.paste();
	}

	private void criarActionMap(JPanel panel) {
		ActionMap acoes = panel.getActionMap();
		acoes.put("btSalvar", new EventoSalvarArquivo());
		acoes.put("btNovo", new EventoCriarArquivo());
		acoes.put("btAbrir", new EventoAbrirArquivo());
		acoes.put("btCopiar", new EventoCopiar());
		acoes.put("btColar", new EventoColar());
		acoes.put("btRecortar", new EventoRecortar());
		acoes.put("btCompilar", new EventoCompilar());
		acoes.put("btEquipe", new EventoMostrarEquipe());

		panel.setActionMap(acoes);
		InputMap atalhos = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);

		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), "btNovo");
		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), "btAbrir");
		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "btSalvar");
		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "btCopiar");
		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK), "btColar");
		atalhos.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "btRecortar");

		atalhos.put(KeyStroke.getKeyStroke("F7"), "btCompilar");
		atalhos.put(KeyStroke.getKeyStroke("F1"), "btEquipe");
	}
}
