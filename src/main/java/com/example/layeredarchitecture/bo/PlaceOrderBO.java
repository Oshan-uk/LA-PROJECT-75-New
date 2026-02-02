package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.CRUDUtil;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO {

    public String generateNewID() throws SQLException, ClassNotFoundException;


    public boolean exists(String id) throws SQLException, ClassNotFoundException ;


    public OrderDTO find(String id) throws SQLException, ClassNotFoundException ;

    public boolean exits(String orderId) throws SQLException, ClassNotFoundException ;


    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException ;


    public boolean update(OrderDTO customerDTO) throws SQLException, ClassNotFoundException ;


    public boolean delete(String id) throws SQLException, ClassNotFoundException ;


    public ArrayList<OrderDetailDTO> getAlldetail() throws SQLException, ClassNotFoundException;

    public boolean save(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException ;

    public boolean update(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;

}