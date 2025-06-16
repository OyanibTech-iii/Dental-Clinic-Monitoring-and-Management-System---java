package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeServiceImpl implements TransactionTypeService {
    
    @Override
    public int saveTransactionType(TransactionType type) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "INSERT INTO TransactionType (TypeName, Description, DefaultCost) VALUES (?,?,?)";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setString(1, type.getTypeName());
            prepStat.setString(2, type.getDescription());
            prepStat.setDouble(3, type.getDefaultCost());
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public TransactionType getTransactionType(int typeID) {
        TransactionType type = null;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM TransactionType WHERE TypeID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, typeID);
            
            ResultSet result = prepStat.executeQuery();
            
            if (result.next()) {
                type = new TransactionType();
                type.setTypeID(result.getInt("TypeID"));
                type.setTypeName(result.getString("TypeName"));
                type.setDescription(result.getString("Description"));
                type.setDefaultCost(result.getDouble("DefaultCost"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return type;
    }

    @Override
    public int deleteTransactionType(int typeID) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "DELETE FROM TransactionType WHERE TypeID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, typeID);
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int updateTransactionType(TransactionType type) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "UPDATE TransactionType SET TypeName = ?, Description = ?, DefaultCost = ? WHERE TypeID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setString(1, type.getTypeName());
            prepStat.setString(2, type.getDescription());
            prepStat.setDouble(3, type.getDefaultCost());
            prepStat.setInt(4, type.getTypeID());
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        List<TransactionType> types = new ArrayList<>();
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM TransactionType";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            ResultSet result = prepStat.executeQuery();
            
            while (result.next()) {
                TransactionType type = new TransactionType();
                type.setTypeID(result.getInt("TypeID"));
                type.setTypeName(result.getString("TypeName"));
                type.setDescription(result.getString("Description"));
                type.setDefaultCost(result.getDouble("DefaultCost"));
                types.add(type);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return types;
    }
}