package br.com.eberoliveira;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import br.com.eberoliveira.model.Pessoa;

public class TelaDeCadastro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pessoa> pessoas = new ArrayList<>();

	public TelaDeCadastro() {
		
		this.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel nome = new JLabel("Nome");
		nome.setHorizontalAlignment(JLabel.RIGHT);
		this.add(nome);

		JTextField nomeField = new JTextField();
		this.add(nomeField);

		JLabel endereco = new JLabel("Endereço");
		endereco.setHorizontalAlignment(JLabel.RIGHT);
		this.add(endereco);

		JTextField enderecoField = new JTextField();
		this.add(enderecoField);

		JLabel numero = new JLabel("Número");
		numero.setHorizontalAlignment(JLabel.RIGHT);
		this.add(numero);

		JTextField numeroField = new JTextField();
		this.add(numeroField);

		JButton btnAdicionar = new JButton("Adicionar");
		this.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = StringUtils.capitalize(nomeField.getText());
				String endereco = StringUtils.capitalize(enderecoField.getText());
				int numero = Integer.parseInt(numeroField.getText());

				Pessoa pessoa = new Pessoa(nome, endereco, numero);
				pessoas.add(pessoa);

				System.out.println("Quantidade Cadastrada " + pessoas.size());

				nomeField.setText("");
				enderecoField.setText("");
				numeroField.setText("");
			}
		});

		JButton btnmostrarTodos = new JButton("Mostrar Todos");
		this.add(btnmostrarTodos);
		btnmostrarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < pessoas.size(); i++) {
					System.out.println(pessoas.get(i));
				}

				Object[] titulos = { "Nome", "Endereço", "Número" };
				Object[][] linhas = new Object[pessoas.size()][2];
				for (int i = 0; i < pessoas.size(); i++) {
					Object[] linha = new Object[] { pessoas.get(i).getNome(), pessoas.get(i).getEndereco(),
							pessoas.get(i).getNumero() };
					linhas[i] = linha;
				}
				JTable table = new JTable(linhas, titulos);
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
			}
		});
	}
}