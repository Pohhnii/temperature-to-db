package de.bk.hennef.temperature.shared;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Business object for temperature data
 */
public class Temperature {

  private double value;
  private LocalDateTime date;

  public Temperature() {
  }

  public Temperature(double value, LocalDateTime date) {
    this.value = value;
    this.date = date;
  }

  @Override
  public String toString() {
    return date.toString() + ": " + value + "°C";
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
