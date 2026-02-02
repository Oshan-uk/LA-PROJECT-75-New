package com.example.layeredarchitecture.dao;


import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveOrderDetails(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {

        //        Connection connection= DBConnection.getDbConnection().getConnection();
    //        PreparedStatement stm = connection.prepareStatement
    //                ("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) " +
    //                        "VALUES (?,?,?,?)");
    //        stm.setString(1, orderDetailDTO.getOrderId());
    //        stm.setString(2, orderDetailDTO.getItemCode());
    //        stm.setBigDecimal(3, orderDetailDTO.getUnitPrice());
    //        stm.setInt(4, orderDetailDTO.getQty());
    //        return stm.executeUpdate()>0;

        return CRUDUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderDetailDTO.getOrderId(), orderDetailDTO.getItemCode(), orderDetailDTO.getUnitPrice(), orderDetailDTO.getQty());
    }


}
