package com.parkingapi.demoparkingapi.config;

import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimezoneConfig {
  public void SpringTimezoneConfig() {

    TimeZone.setDefault(null);
  }
}
