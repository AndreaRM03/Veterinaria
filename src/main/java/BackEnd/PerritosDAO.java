package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerritosDAO {

    private Connection getConnection() throws SQLException {
        // Configurar la conexión a tu base de datos
        String url = "jdbc:mysql://localhost:3306/veterinaria";
        String usuario = "root";
        String contraseña = "toor";
        return DriverManager.getConnection(url, usuario, contraseña);
    }

    public int insertarPerrito(Perritos perrito) {
        String sql = "INSERT INTO perritos (nombre, raza, color, peso, altura, dueno) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, perrito.getNombre());
            pstmt.setString(2, perrito.getRaza());
            pstmt.setString(3, perrito.getColor());
            pstmt.setDouble(4, perrito.getPeso());
            pstmt.setDouble(5, perrito.getAltura());
            pstmt.setString(6, perrito.getDueno());

            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Perritos obtenerPerritoPorId(int idPerrito) {
        Perritos perrito = null;
        String sql = "SELECT * FROM perritos WHERE id_perrito = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPerrito);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                perrito = new Perritos();
                perrito.setIdPerrito(rs.getInt("id_perrito"));
                perrito.setNombre(rs.getString("nombre"));
                perrito.setRaza(rs.getString("raza"));
                perrito.setColor(rs.getString("color"));
                perrito.setPeso(rs.getDouble("peso"));
                perrito.setAltura(rs.getDouble("altura"));
                perrito.setDueno(rs.getString("dueno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perrito;
    }

    public List<Perritos> obtenerTodosLosPerritos() {
        List<Perritos> perritos = new ArrayList<>();
        String sql = "SELECT * FROM perritos";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Perritos perrito = new Perritos();
                perrito.setIdPerrito(rs.getInt("id_perrito"));
                perrito.setNombre(rs.getString("nombre"));
                perrito.setRaza(rs.getString("raza"));
                perrito.setColor(rs.getString("color"));
                perrito.setPeso(rs.getDouble("peso"));
                perrito.setAltura(rs.getDouble("altura"));
                perrito.setDueno(rs.getString("dueno"));
                perritos.add(perrito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perritos;
    }

    public int actualizarPerrito(Perritos perrito, int idPerrito) {
        String sql = "UPDATE perritos SET nombre=?, raza=?, color=?, peso=?, altura=?, dueno=? WHERE id_perrito=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, perrito.getNombre());
            pstmt.setString(2, perrito.getRaza());
            pstmt.setString(3, perrito.getColor());
            pstmt.setDouble(4, perrito.getPeso());
            pstmt.setDouble(5, perrito.getAltura());
            pstmt.setString(6, perrito.getDueno());
            pstmt.setInt(7, idPerrito);

            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int borrarPerrito(int idPerrito) {
        String sql = "DELETE FROM perritos WHERE id_perrito=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPerrito);

            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
