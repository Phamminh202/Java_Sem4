package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Category;
import com.t2010a.javashopping.entity.myenum.CategoryStatus;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoryModel implements CategoryModel{
    @Override
    public Category save(Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into categories "+
                    "(name,createdAt,updatedAt,status)"+
                    " value "+"(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getCreatedAt().toString());
            preparedStatement.setString(3,category.getUpdatedAt().toString());
            preparedStatement.setInt(4,category.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return category;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,CategoryStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                Category category = new Category(id,name);
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setStatus(CategoryStatus.of(intstatus));
                list.add(category);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setStatus(CategoryStatus.of(intstatus));
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category update(int id, Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories "+
                    "set name = ?, createdAt = ?,updatedAt = ? ,status = ? where  id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getCreatedAt().toString());
            preparedStatement.setString(3,category.getUpdatedAt().toString());
            preparedStatement.setInt(4,category.getStatus().getValue());
            preparedStatement.setInt(5,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return category;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,CategoryStatus.DELETE.getValue());
            preparedStatement.setInt(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
