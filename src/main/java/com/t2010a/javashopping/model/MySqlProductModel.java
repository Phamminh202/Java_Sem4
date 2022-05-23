package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.myenum.ProductStatus;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel{
    @Override
    public Product save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into products "+
                    "(id,name,image,price,qty,color_id,content,category_id,createdAt,updatedAt,status)"+
                    "value "+"(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getImage());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setInt(5,product.getQty());
            preparedStatement.setInt(6,product.getColor_id());
            preparedStatement.setString(7,product.getContent());
            preparedStatement.setInt(8,product.getCategory_id());
            preparedStatement.setString(9,product.getCreatedAt().toString());
            preparedStatement.setString(10,product.getUpdatedAt().toString());
            preparedStatement.setInt(11,product.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return product;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,ProductStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                int color_id = Integer.parseInt(resultSet.getString("color_id"));
                String content = resultSet.getString("content");
                int category_id = Integer.parseInt(resultSet.getString("category_id"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                Product product = new Product(id,name,image,price,qty,color_id,content,category_id);
                product.setCreatedAt(createdAt);
                product.setUpdatedAt(updatedAt);
                product.setStatus(ProductStatus.of(intstatus));
                list.add(product);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(String id) {
        Product product = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            preparedStatement.setString(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                int color_id = Integer.parseInt(resultSet.getString("color_id"));
                String content = resultSet.getString("content");
                int category_id = Integer.parseInt(resultSet.getString("category_id"));
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                product = new Product(id,name,image,price,qty,color_id,content,category_id);
                product.setCreatedAt(createdAt);
                product.setUpdatedAt(updatedAt);
                product.setStatus(ProductStatus.of(intstatus));
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(String id, Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products "+
                    "set id = ?,name = ?,image = ?,price = ?,qty = ?,color_id = ?,content = ?,category_id = ?, createdAt = ?,updatedAt = ? ,status = ? where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getImage());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setInt(5,product.getQty());
            preparedStatement.setInt(6,product.getColor_id());
            preparedStatement.setString(7,product.getContent());
            preparedStatement.setInt(8,product.getCategory_id());
            preparedStatement.setString(9,product.getCreatedAt().toString());
            preparedStatement.setString(10,product.getUpdatedAt().toString());
            preparedStatement.setInt(11,product.getStatus().getValue());
            preparedStatement.setString(12,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return product;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,ProductStatus.DELETE.getValue());
            preparedStatement.setString(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
