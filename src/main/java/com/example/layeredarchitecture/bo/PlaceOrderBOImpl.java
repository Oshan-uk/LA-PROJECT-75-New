package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException{
        return orderDAO.generateNewID();
    }
    @Override
    public boolean exists(String itemCode) throws SQLException, ClassNotFoundException {
        return orderDAO.exists(itemCode);
    }
    @Override
    public OrderDTO find(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.find(id);
    }

    @Override
    public boolean exits(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exists(id);
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException{
        return orderDAO.getAll();
    }
    @Override
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException{
        return orderDAO.save(orderDTO);
    }

    @Override
    public boolean update(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.update(customerDTO);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.delete(id);
    }
    @Override
    public ArrayList<OrderDetailDTO> getAlldetail() throws SQLException, ClassNotFoundException{
        return orderDetailDAO.getAll();
    }
    @Override
    public boolean save(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.save(orderDetailDTO);
    }
    @Override
    public boolean update(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException{
        return orderDetailDAO.update(orderDetailDTO);
    }
}