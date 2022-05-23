package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.myenum.ColorStatus;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlColorModel implements ColorModel{
    @Override
    public Color save(Color color) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into colors "+
                    "(name,createdAt,updatedAt,status)"+
                    " value "+"(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,color.getName());
            preparedStatement.setString(2,color.getCreatedAt().toString());
            preparedStatement.setString(3,color.getUpdatedAt().toString());
            preparedStatement.setInt(4,color.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return color;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Color> findAll() {
        List<Color> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from colors where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ColorStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                Color color = new Color(id,name);
                color.setCreatedAt(createdAt);
                color.setUpdatedAt(updatedAt);
                color.setStatus(ColorStatus.of(intstatus));
                list.add(color);
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Color findById(int id) {
        Color color = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from colors where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,ColorStatus.ACTIVE.getValue());
            preparedStatement.setInt(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                int intstatus = resultSet.getInt("status");
                color.setCreatedAt(createdAt);
                color.setUpdatedAt(updatedAt);
                color.setStatus(ColorStatus.of(intstatus));
            }
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Color update(int id, Color color) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update colors "+
                    "set name = ?, createdAt = ?,updatedAt = ? ,status = ? where  id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,color.getName());
            preparedStatement.setString(2,color.getCreatedAt().toString());
            preparedStatement.setString(3,color.getUpdatedAt().toString());
            preparedStatement.setInt(4,color.getStatus().getValue());
            preparedStatement.setInt(5,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return color;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update colors " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,ColorStatus.DELETE.getValue());
            preparedStatement.setInt(2,id);
            System.out.println("Connection success!");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
