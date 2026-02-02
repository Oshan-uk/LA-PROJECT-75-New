package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomerDTO;


import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public CustomerDTO findCustomer(String id) throws SQLException, ClassNotFoundException;

}
