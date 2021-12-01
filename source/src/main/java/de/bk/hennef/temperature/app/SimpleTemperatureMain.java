package de.bk.hennef.temperature.app;

import de.bk.hennef.temperature.business.TemperatureService;
import de.bk.hennef.temperature.data.TemperatureAccessRepo;
import de.bk.hennef.temperature.data.TemperaturePersistenceRepo;
import de.bk.hennef.temperature.data.impl.TemperatureAccessRepoImpl;
import de.bk.hennef.temperature.data.impl.TemperaturePersistenceRepoImpl;
import de.bk.hennef.temperature.shared.Temperature;
import java.time.LocalDateTime;

/**
 * Runs a simple Program. The temperature data gets read, printed to the terminal and then
 * persisted.
 */
public class SimpleTemperatureMain {

  /**
   * Executes the program.
   *
   * @param args program args. Not used yet.
   */
  public static void main(String[] args) {

    // The temperature service
    TemperatureService temperatureService = initService();

    try {
      // indefinite loop
      while (true) {
        // read the temperature
        Temperature temperature = temperatureService.getCurrentTemperature();
        // if the temperature is null, then print an error to the terminal
        if (temperature == null) {
          System.out.println("Error: No data accessible.");
        } else {
          // print the temperature to the terminal
          System.out.println(temperature);
          // persist the temperature
          temperatureService.saveTemperature(temperature);
        }
        Thread.sleep(1000);
      }
    } catch (Exception e) {
      e.printStackTrace();
      // the program is stopped by the user or an exception
      System.out.println("Program stopped. Cause: " + e.getMessage());
    }

  }

  /**
   * Initializes the temperature service with and adds the repositories.
   *
   * @return the temperature service
   */
  private static TemperatureService initService() {
    TemperatureAccessRepo temperatureAccessRepo = new TemperatureAccessRepoImpl();
    TemperaturePersistenceRepo temperaturePersistenceRepo = new TemperaturePersistenceRepoImpl();

    return new TemperatureService(temperatureAccessRepo, temperaturePersistenceRepo);
  }

}
