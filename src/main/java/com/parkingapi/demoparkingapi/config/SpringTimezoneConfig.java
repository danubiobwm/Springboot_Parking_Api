package com.parkingapi.demoparkingapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimezoneConfig {
  @PostConstruct
  public void TimezoneConfig() {
    TimeZone.setDefault(TimeZone.getTimeZone("America/Fortaleza"));
  }
}
