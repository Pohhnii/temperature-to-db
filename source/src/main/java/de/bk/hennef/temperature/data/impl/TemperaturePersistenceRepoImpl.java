package de.bk.hennef.temperature.data.impl;

import de.bk.hennef.temperature.data.TemperaturePersistenceRepo;
import de.bk.hennef.temperature.shared.Temperature;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TemperaturePersistenceRepoImpl implements TemperaturePersistenceRepo {

  private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/temperature?user=root&password=password";

  @Override
  public void saveTemperature(Temperature temperature) {
    try (Connection connection = DriverManager.getConnection(CONNECTION_URL)) {
      PreparedStatement statement = connection.prepareStatement(
          "insert into temperature (temperature_value, temperature_date) values (?, ?)");
      statement.setDouble(1, temperature.getValue());
      statement.setTimestamp(2, Timestamp.valueOf(temperature.getDate()));
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
