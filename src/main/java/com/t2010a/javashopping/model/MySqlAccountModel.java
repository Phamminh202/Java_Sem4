package com.t2010a.javashopping.model;

import com.t2010a.javashopping.entity.Account;
import com.t2010a.javashopping.entity.myenum.AccountStatus;
import com.t2010a.javashopping.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    @Override
    public Account save(Account account) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into accounts " +
                    "(username, password, salt, email, phone, role, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getSalt());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setInt(6, account.getRole());
            preparedStatement.setString(7, account.getCreatedAt().toString());
            preparedStatement.setString(8, account.getUpdatedAt().toString());
            preparedStatement.setInt(9, account.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, password, salt, email, phone, AccountStatus.of(status));
                account.setCreatedAt(createdAt);
                account.setUpdatedAt(updatedAt);
                account.setRole(role);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findById(int id) {
        Account account = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                int role = resultSet.getInt("role");
                String password = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                account = new Account(id, username, password, salt, email, phone, AccountStatus.of(status));
                account.setCreatedAt(createdAt);
                account.setUpdatedAt(updatedAt);
                account.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account findByUsername(String username) {
        Account account = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ? and username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String password = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                account = new Account(id, username, password, salt, email, phone, AccountStatus.of(status));
                account.setCreatedAt(createdAt);
                account.setUpdatedAt(updatedAt);
                account.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account findByEmail(String email) {
        Account account = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt = LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt = LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                account = new Account(id, username, password, salt, email, phone, AccountStatus.of(status));
                account.setCreatedAt(createdAt);
                account.setUpdatedAt(updatedAt);
                account.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account update(int id, Account updateaccount) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update accounts " +
                    "set username = ?, password = ?, salt = ?, email = ?, phone = ?, role = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateaccount.getUsername());
            preparedStatement.setString(2, updateaccount.getPassword());
            preparedStatement.setString(3, updateaccount.getSalt());
            preparedStatement.setString(4, updateaccount.getEmail());
            preparedStatement.setString(5, updateaccount.getPhone());
            preparedStatement.setInt(6, updateaccount.getRole());
            preparedStatement.setString(7, updateaccount.getCreatedAt().toString());
            preparedStatement.setString(8, updateaccount.getUpdatedAt().toString());
            preparedStatement.setInt(9, updateaccount.getStatus().getValue());
            preparedStatement.setInt(10, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateaccount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update accounts " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.DELETE.getValue());
            preparedStatement.setInt(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
