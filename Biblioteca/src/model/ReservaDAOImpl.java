package model;

import model.Conexao;
import model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAOImpl implements ReservaDAO {

    @Override
    public boolean inserirReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (data_reserva, usuario_idusuario) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDate(1, reserva.getDataReserva());
            stmt.setInt(2, reserva.getIdUsuario());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
