import java.sql.Connection;

import javax.swing.SwingUtilities;

import model.Conexao;
import view.TelaLogin;
import view.TelaReserva;

public class BibliotecaMain {

	public static String version = "1.2";

	public static void main(String[] args) {
		System.out.println("Iniciar Sistema.");

		Conexao.testConnection();
		Conexao.getConexao();
		Conexao.testConnection();

		SwingUtilities.invokeLater(() -> {
			/*TelaLogin login = new TelaLogin();
			login.setVisible(true);*/
			TelaReserva tela = new TelaReserva();
	        tela.setVisible(true);
			
		});
	}

}
