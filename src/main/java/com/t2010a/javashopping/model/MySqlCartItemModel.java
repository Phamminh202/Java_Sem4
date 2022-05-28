package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.cart.CartItem;
import com.t2010a.javashopping.entity.myenum.CartItemStatus;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCartItemModel implements CheckoutCartItemModel{
    @Override
    public CartItem save(CartItem cartItem) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into cartitem "+
                    "(shoppingcartId,productId,productName,productImage,unitPrice,qty,createdAt,status)"+
                    " value "+"(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,cartItem.getShoppingcartId());
            preparedStatement.setString(2,cartItem.getProductId());
            preparedStatement.setString(3,cartItem.getProductName());
            preparedStatement.setString(4,cartItem.getProductImage());
            preparedStatement.setDouble(5,cartItem.getUnitPrice());
            preparedStatement.setInt(6,cartItem.getQty());
            preparedStatement.setString(7, LocalDateTime.now().toString());
            preparedStatement.setInt(8, CartItemStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return cartItem;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CartItem> findAll() {
        List<CartItem> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from cartitem";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int shoppingcartId = Integer.parseInt(resultSet.getString("shoppingcartId"));
                String productId = resultSet.getString("productId");
                String productName = resultSet.getString("productName");
                String productImage = resultSet.getString("productImage");
                double unitPrice = Double.parseDouble(resultSet.getString("unitPrice"));
                int qty = Integer.parseInt(resultSet.getString("qty"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = Integer.parseInt(resultSet.getString("status"));
                CartItem cartItem = new CartItem();
                cartItem.setShoppingcartId(shoppingcartId);
                cartItem.setProductId(productId);
                cartItem.setProductName(productName);
                cartItem.setProductImage(productImage);
                cartItem.setUnitPrice(unitPrice);
                cartItem.setQty(qty);
                cartItem.setCreatedAt(createdAt);
                cartItem.setStatus(CartItemStatus.of(status));
                list.add(cartItem);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CartItem> findByShoppingCartId(int shoppingcartId) {
        List<CartItem> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from cartitem where shoppingcartId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,shoppingcartId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId = resultSet.getString("productId");
                String productName = resultSet.getString("productName");
                String productImage = resultSet.getString("productImage");
                double unitPrice = Double.parseDouble(resultSet.getString("unitPrice"));
                int qty = Integer.parseInt(resultSet.getString("qty"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int status = Integer.parseInt(resultSet.getString("status"));
                CartItem cartItem = new CartItem();
                cartItem.setShoppingcartId(shoppingcartId);
                cartItem.setProductId(productId);
                cartItem.setProductName(productName);
                cartItem.setProductImage(productImage);
                cartItem.setUnitPrice(unitPrice);
                cartItem.setQty(qty);
                cartItem.setCreatedAt(createdAt);
                cartItem.setStatus(CartItemStatus.of(status));
                list.add(cartItem);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
