package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ResultSet rst = CRUDUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()) {
            String code = rst.getString("code");
            String description = rst.getString("description");
            BigDecimal unitPrice = rst.getBigDecimal("unitPrice");
            Integer qtyOnHand = rst.getInt("qtyOnHand");
            ItemDTO ItemDTO = new ItemDTO(code, description, unitPrice, qtyOnHand);
            items.add(ItemDTO);
        }
        return items;

    }

    @Override
    public void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//            pstm.setString(1, itemDTO.getCode());
//            pstm.setString(2, itemDTO.getDescription());
//            pstm.setBigDecimal(3, itemDTO.getUnitPrice());
//            pstm.setInt(4, itemDTO.getQtyOnHand());
//            pstm.executeUpdate();
        CRUDUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", code, description, unitPrice, qtyOnHand);
    }

    @Override
    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {

        return CRUDUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", description, unitPrice, qtyOnHand, code);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {


        return CRUDUtil.execute("DELETE FROM Item WHERE code=?",code);
        /* pstm.setString(1, code);
        pstm.executeUpdate();*/
//        int rs = ptsm.executeUpdate();



    }

    @Override
    public boolean existsItem(String itemCode) throws SQLException, ClassNotFoundException {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//
//            PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//            pstm.setString(1, itemCode);
//            return pstm.executeQuery().next();
        ResultSet rs = CRUDUtil.execute("SELECT code FROM Item WHERE code=?", itemCode);
        return rs.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        ResultSet rst = CRUDUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, itemCode + "");
//        ResultSet rst = pstm.executeQuery();
        ResultSet rst = CRUDUtil.execute("SELECT * FROM Item WHERE code=?", itemCode);

        if (rst.next()) {
            return new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
        }
        return null;
    }

}


