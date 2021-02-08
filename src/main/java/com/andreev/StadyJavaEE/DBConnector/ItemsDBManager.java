package com.andreev.StadyJavaEE.DBConnector;

import com.andreev.StadyJavaEE.entity.Country;
import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.entity.User;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ItemsDBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/first_ee_db?useUnicode=true&serverTimezone=UTC",
                            "soulex", "soulex");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addItem(Item item) {
        int rows = 0;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO items (name, price, amount, manufacturer_id) " +
                "VALUES (?, ?, ?, ?)")) {
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getManufacturer().getId());

            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT it.id, it.name, it.price, it.amount, it.manufacturer_id, c.name AS country_name, c.short_name " +
                "FROM items it " +
                "INNER JOIN countries c ON c.id = it.manufacturer_id ORDER BY it.price DESC")) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                items.add(new Item(
                        set.getLong("id"),
                        set.getString("name"),
                        set.getInt("price"),
                        set.getInt("amount"),
                        new Country(
                                set.getLong("manufacturer_id"),
                                set.getString("country_name"),
                                set.getString("short_name")
                        )));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItem(Long id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT it.id, it.name, it.price, it.amount, it.manufacturer_id, c.name AS country_name, c.short_name " +
                "FROM items it " +
                "INNER JOIN countries c ON c.id = it.manufacturer_id WHERE it.id = ?")) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                item = new Item(
                        set.getLong("id"),
                        set.getString("name"),
                        set.getInt("price"),
                        set.getInt("amount"),
                        new Country(
                                set.getLong("manufacturer_id"),
                                set.getString("country_name"),
                                set.getString("short_name")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static boolean saveItem(Item item) {
        int rows = 0;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE items SET name = ?, price = ?, amount = ?, manufacturer_id = ? " +
                "WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getManufacturer().getId());
            statement.setLong(5, item.getId());

                        rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static boolean deleteItem(Item item) {
        int rows = 0;
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setLong(1, item.getId());

            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM countries")) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                countries.add(new Country(
                                set.getLong("id"),
                                set.getString("name"),
                                set.getString("short_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static Country getCountry(Long id) {
        Country country = null;
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM countries WHERE id = ? LIMIT 1")) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                country = new Country(
                        set.getLong("id"),
                        set.getString("name"),
                        set.getString("short_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    public static User getUser(String email) {
        User user = null;
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1")) {
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                user = new User(
                        set.getLong("id"),
                        set.getString("email"),
                        set.getString("password"),
                        set.getString("full_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean addUser(User user) {
        int rows = 0;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (email, password, full_name) " +
                "VALUES (?, ?, ?)")) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());

            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

}
