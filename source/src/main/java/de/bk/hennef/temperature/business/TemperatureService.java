package de.bk.hennef.temperature.business;

import de.bk.hennef.temperature.data.TemperatureAccessRepo;
import de.bk.hennef.temperature.data.TemperaturePersistenceRepo;
import de.bk.hennef.temperature.shared.Temperature;

/**
 * The temperature service reads and saves the temperature data
 */
public class TemperatureService {

  protected TemperatureAccessRepo temperatureAccessRepo;
  protected TemperaturePersistenceRepo temperaturePersistenceRepo;

  /**
   * Initializes the temperature service
   *
   * @param temperatureAccessRepo      the repository for reading data
   * @param temperaturePersistenceRepo the repository for persisting data
   */
  public TemperatureService(TemperatureAccessRepo temperatureAccessRepo,
      TemperaturePersistenceRepo temperaturePersistenceRepo) {
    this.temperatureAccessRepo = temperatureAccessRepo;
    this.temperaturePersistenceRepo = temperaturePersistenceRepo;
  }

  /**
   * Reads the temperature
   *
   * @return the temperature
   */
  public Temperature getCurrentTemperature() {
    return temperatureAccessRepo.getCurrentTemperature();
  }

  /**
   * Saves the temperature
   *
   * @param temperature the temperature
   */
  public void saveTemperature(Temperature temperature) {
    this.temperaturePersistenceRepo.saveTemperature(temperature);
  }

}
