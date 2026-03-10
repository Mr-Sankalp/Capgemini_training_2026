package org.example.dao;

import org.example.model.Product;
import org.example.util.DBConnection;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product product) {

        String sql = "INSERT INTO products(product_id,product_name,category,price,quantity,rating) VALUES(?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setDouble(6, product.getRating());

            ps.executeUpdate();
            System.out.println("Product added successfully!");

        } catch (SQLException e) {
            System.out.println("Error: Product ID already exists.");
        }
    }

    public void viewAllProducts() {

        String sql = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("ID   Name   Category   Price   Qty   Rating");
            System.out.println("----------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + "  " +
                                rs.getString("product_name") + "  " +
                                rs.getString("category") + "  " +
                                rs.getDouble("price") + "  " +
                                rs.getInt("quantity") + "  " +
                                rs.getDouble("rating"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProductById(int id) {

        String sql = "SELECT * FROM products WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("product_name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Rating: " + rs.getDouble("rating"));

            } else {
                System.out.println("Product not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(int id, double price) {

        String sql = "UPDATE products SET price=? WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Price updated successfully.");
            else
                System.out.println("Product not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuantity(int id, int qty) {

        String sql = "UPDATE products SET quantity=? WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, qty);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Quantity updated successfully.");
            else
                System.out.println("Product not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {

        String sql = "DELETE FROM products WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product deleted successfully.");
            else
                System.out.println("Product does not exist.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByName(String keyword) {

        String sql = "SELECT * FROM products WHERE product_name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("product_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showLowStock() {

        String sql = "SELECT product_id,product_name,quantity FROM products WHERE quantity < 5";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Low Stock Products");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + "  " +
                                rs.getString("product_name") + "  " +
                                rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}