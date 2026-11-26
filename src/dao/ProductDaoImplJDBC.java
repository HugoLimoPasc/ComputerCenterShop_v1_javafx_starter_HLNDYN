package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.sql.Statement;

import model.Product;

public class ProductDaoImplJDBC implements ProductDao {
	private static final String DEFAULT_DB_URL = "jdbc:h2:./data/computercenter_v1_starter;AUTO_SERVER=FALSE";
	private static final String DEFAULT_USER = "sa";
	private static final String DEFAULT_PASSWORD = "";

	private Connection conn;

	@Override
	public void connect() throws SQLException {
		String url = System.getProperty("computercenter.db.url", DEFAULT_DB_URL);
		String user = System.getProperty("computercenter.db.user", DEFAULT_USER);
		String password = System.getProperty("computercenter.db.password", DEFAULT_PASSWORD);
		
		conn = DriverManager.getConnection(url, user, password);

		// TODO RA2-ISSUE-02: obrir la connexio amb DriverManager i guardar-la a conn.
		// Pista: usa url, user i password, i comprova com es declara el connector al pom.xml.
		// throw pending("RA2-ISSUE-02 pendent: implementa la connexio JDBC amb DriverManager.");
	}

	@Override
	public void disconnect() throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}


	@Override
	public void initSchema() throws SQLException {
		try (Statement stmt = requireConnection().createStatement()) {

        // Crear la tabla de productos
        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS products (" +
            "id IDENTITY PRIMARY KEY, " +
            "name VARCHAR(80) NOT NULL UNIQUE, " +
            "wholesaler_price DECIMAL(10,2) NOT NULL, " +
            "available BOOLEAN NOT NULL, " +
            "stock INT NOT NULL)"
        );

        // Crear la tabla del historial de inventario
        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS inventory_history (" +
            "id IDENTITY PRIMARY KEY, " +
            "product_id BIGINT NOT NULL, " +
            "action VARCHAR(40) NOT NULL, " +
            "quantity INT NOT NULL, " +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "FOREIGN KEY (product_id) REFERENCES products(id))"
        );

        // Crear el alias para la alerta de stock
        stmt.executeUpdate(
            "CREATE ALIAS IF NOT EXISTS STOCK_ALERT_LIMIT " +
            "FOR \"dao.ProductDaoImplJDBC.stockAlertLimit\""
        );

        // Comprobar si la tabla de productos esta vacia
        try (ResultSet rs = stmt.executeQuery(
                "SELECT COUNT(*) FROM products")) {

            if (rs.next() && rs.getInt(1) == 0) {

                // Insertar los productos iniciales
                stmt.executeUpdate(
                    "INSERT INTO products " +
                    "(name, wholesaler_price, available, stock) VALUES " +
                    "('SSD 1TB', 60.00, TRUE, 8), " +
                    "('RAM 32GB', 90.50, TRUE, 3), " +
                    "('Teclat mecanic', 45.00, TRUE, 6)"
                );
            }
        }

        System.out.println("Esquema de base de datos inicializado correctamente.");
    }
}


	@Override
	public ArrayList<Product> getInventory() throws SQLException {
		// TODO RA2-ISSUE-07: executar SELECT ordenat i convertir cada fila en Product amb mapProduct().
		throw pending("RA2-ISSUE-07 pendent: implementa consulta d'inventari i recorregut de ResultSet.");
	}

	@Override
	public Product findProductByName(String name) throws SQLException {
		// TODO RA2-ISSUE-07: buscar per nom amb PreparedStatement i retornar null si no hi ha resultat.
		throw pending("RA2-ISSUE-07 pendent: implementa consulta parametritzada per nom.");
	}

	@Override
	public int insertProduct(Product product) throws SQLException {

	    if (product == null) {
	        throw new SQLException("El producto no puede ser nulo.");
	    }

	    if (product.getName() == null || product.getName().isBlank()) {
	        throw new SQLException("El nombre no puede estar vacio.");
	    }

	    if (product.getName().length() > 80) {
	        throw new SQLException("El nombre no puede superar los 80 caracteres.");
	    }

	    if (product.getWholesalerPrice() == null
	            || product.getWholesalerPrice().getValue() < 0) {
	        throw new SQLException("El precio no puede ser nulo ni negativo.");
	    }

	    if (product.getStock() < 0) {
	        throw new SQLException("El stock no puede ser negativo.");
	    }

	    String sql = "INSERT INTO products (name, wholesaler_price, available, stock) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement stmt = requireConnection().prepareStatement(sql)) {

	        stmt.setString(1, product.getName().trim());
	        stmt.setDouble(2, product.getWholesalerPrice().getValue());
	        stmt.setBoolean(3, product.isAvailable());
	        stmt.setInt(4, product.getStock());

	        return stmt.executeUpdate();

	    } catch (SQLException e) {

	        if ("23505".equals(e.getSQLState())) {
	            throw new SQLException("Ya existe un producto con ese nombre.", e);
	        }

	        throw e;
	    }
	} 

	@Override
	public int updateStock(String name, int newStock) throws SQLException {
		// TODO RA2-ISSUE-05: actualitzar stock i available segons newStock amb PreparedStatement.
		throw pending("RA2-ISSUE-05 pendent: implementa actualitzacio d'estoc.");
	}

	@Override
	public int deleteProduct(String name) throws SQLException {
		// TODO RA2-ISSUE-06: eliminar per nom i comprovar files afectades.
		throw pending("RA2-ISSUE-06 pendent: implementa eliminacio controlada.");
	}

	@Override
	public void registerStockChange(String name, int unitsToAdd) throws SQLException {
		// TODO RA2-ISSUE-09: desactivar autoCommit, actualitzar estoc, inserir historial, commit o rollback.
		throw pending("RA2-ISSUE-09 pendent: implementa transaccio commit/rollback.");
	}

	@Override
	public boolean evaluateStockAlertWithProcedure(int stock) throws SQLException {
		// TODO RA2-ISSUE-10: cridar STOCK_ALERT_LIMIT amb CallableStatement i parametre d'entrada.
		throw pending("RA2-ISSUE-10 pendent: implementa procediment o alias amb CallableStatement.");
	}

	public static int stockAlertLimit(int stock) {
		return stock < 5 ? 1 : 0;
	}

	private Product mapProduct(ResultSet resultSet) throws SQLException {
		// TODO RA2-ISSUE-07: crear Product amb name, wholesaler_price, available, stock i assignar id.
		throw pending("RA2-ISSUE-07 pendent: implementa mapatge de ResultSet a Product.");
	}

	private SQLFeatureNotSupportedException pending(String message) {
		return new SQLFeatureNotSupportedException(message);
	}

	@SuppressWarnings("unused")
	private Connection requireConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			throw new SQLException("Connexio no disponible. Revisa RA2-ISSUE-02.");
		}
		return conn;
	}
}
