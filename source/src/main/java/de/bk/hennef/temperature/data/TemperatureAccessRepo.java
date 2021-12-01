package de.bk.hennef.temperature.data;

import de.bk.hennef.temperature.shared.Temperature;

/**
 * Repository for reading temperature data
 */
public interface TemperatureAccessRepo {

  Temperature getCurrentTemperature();

}
