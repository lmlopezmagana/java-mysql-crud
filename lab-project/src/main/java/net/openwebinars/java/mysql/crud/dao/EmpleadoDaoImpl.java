package net.openwebinars.java.mysql.crud.dao;

import net.openwebinars.java.mysql.crud.model.Empleado;
import net.openwebinars.java.mysql.crud.pool.MyDataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoDaoImpl implements EmpleadoDao {

    private static EmpleadoDaoImpl instance;

    static {
        instance = new EmpleadoDaoImpl();
    }

    private EmpleadoDaoImpl() {}

    public static EmpleadoDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int add(Empleado emp) throws SQLException {

        String sql = """
                INSERT INTO empleado 
                    (nombre, apellidos, 
                       fecha_nacimiento, puesto, email)
                VALUES (?, ?, ?, ?, ?)
                """;

        int result;

        try(Connection conn = MyDataSource.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, emp.getNombre());
            pstm.setString(2, emp.getApellidos());
            pstm.setDate(3, Date.valueOf(emp.getFecha_nacimiento()));
            pstm.setString(4, emp.getPuesto());
            pstm.setString(5, emp.getEmail());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public Empleado getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Empleado> getAll() throws SQLException {
        return null;
    }

    @Override
    public int update(Empleado emp) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
