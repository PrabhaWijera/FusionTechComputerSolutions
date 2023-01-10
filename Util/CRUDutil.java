package lk.ijse.Fusion.Util;


import lk.ijse.Fusion.Database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CRUDutil {
    public static <T>T execute(String sql, Object... args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection. getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }
        if(sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T)pstm.executeQuery();
        }
        return (T)((Boolean)(pstm.executeUpdate() > 0));   // convert boolean to Boolean(Boxing type)
    }
}