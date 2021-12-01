package de.bk.hennef.temperature.data.impl;

import de.bk.hennef.temperature.data.TemperatureAccessRepo;
import de.bk.hennef.temperature.shared.Temperature;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class TemperatureAccessRepoImpl implements TemperatureAccessRepo {

  private File file;

  public TemperatureAccessRepoImpl() {
    try {
      InputStream inputStream = getClass().getResourceAsStream("/python/read-temperature.py");
      assert inputStream != null;
      file = File.createTempFile(String.valueOf(inputStream.hashCode()), ".py");
      file.deleteOnExit();
      try (FileOutputStream outputStream = new FileOutputStream(file)) {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Temperature getCurrentTemperature() {
    StringBuilder outputString = new StringBuilder();
    try {
      String command = "python3 " + file.getAbsolutePath();
      Process p = Runtime.getRuntime().exec(command);
      p.waitFor();
      BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
      String line;
      while ((line = bri.readLine()) != null) {
        outputString.append(line);
      }
      bri.close();
      while ((line = bre.readLine()) != null) {
        System.out.println(line);
      }
      bre.close();
      p.waitFor();
      p.destroy();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    try {
      double temperatureValue = Double.parseDouble(outputString.toString());
      return new Temperature(temperatureValue, LocalDateTime.now());
    } catch (Exception e) {
      return null;
    }
  }
}
