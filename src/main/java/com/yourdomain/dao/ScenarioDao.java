package com.yourdomain.dao;

import com.yourdomain.model.ScenarioEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDao {

    public void initializeDatabase() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS water_orders (
                order_id INTEGER PRIMARY KEY AUTOINCREMENT,
                customer_name TEXT NOT NULL,
                qty_5_gallon INTEGER NOT NULL CHECK (qty_5_gallon >= 0),
                qty_1_gallon INTEGER NOT NULL CHECK (qty_1_gallon >= 0),
                order_status TEXT NOT NULL CHECK (order_status IN ('PENDING', 'DELIVERING', 'DELIVERED'))
            )
            """;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void addRecord(ScenarioEntity record) throws SQLException {
        String sql = """
            INSERT INTO water_orders
                (customer_name, qty_5_gallon, qty_1_gallon, order_status)
            VALUES (?, ?, ?, ?)
            """;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, record.customerName());
            statement.setInt(2, record.qty5Gallon());
            statement.setInt(3, record.qty1Gallon());
            statement.setString(4, record.orderStatus());
            statement.executeUpdate();
        }
    }

    public List<ScenarioEntity> getAllRecords() throws SQLException {
        String sql = """
            SELECT order_id, customer_name, qty_5_gallon, qty_1_gallon, order_status
            FROM water_orders
            ORDER BY order_id
            """;
        List<ScenarioEntity> records = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                records.add(new ScenarioEntity(
                    resultSet.getInt("order_id"),
                    resultSet.getString("customer_name"),
                    resultSet.getInt("qty_5_gallon"),
                    resultSet.getInt("qty_1_gallon"),
                    resultSet.getString("order_status")
                ));
            }
        }
        return records;
    }
}
