package de.bk.hennef.temperature.data;

import de.bk.hennef.temperature.shared.Temperature;

/**
 * Repository for saving temperature data.
 */
public interface TemperaturePersistenceRepo {

  void saveTemperature(Temperature temperature);

}
