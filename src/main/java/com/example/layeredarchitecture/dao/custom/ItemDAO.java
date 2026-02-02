package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

    public void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException ;

    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException ;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;


    public boolean existsItem(String itemCode) throws SQLException, ClassNotFoundException ;

    public String generateNewId() throws SQLException, ClassNotFoundException ;

    public ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException ;
}
