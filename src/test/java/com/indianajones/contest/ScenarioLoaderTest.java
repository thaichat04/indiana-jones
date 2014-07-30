package com.indianajones.contest;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class ScenarioLoaderTest {

  @Test
  public void can_load_scenario() throws Exception {
    Scenario scenario = ScenarioLoader.load(ScenarioLoaderTest.class.getResourceAsStream("/sample/input.txt"));
    
    assertThat(scenario.getDepart()).isEqualTo(new City("Paris"));
    assertThat(scenario.getArrival()).isEqualTo(new City("Berlin"));
    assertThat(scenario.getDeparture().getHourOfDay()).isEqualTo(8);
    assertThat(scenario.getDeparture().getMinuteOfHour()).isEqualTo(20);
    assertThat(scenario.getTimetable()).hasSize(4);
    assertThat(scenario.getDestinationsFrom(new City("Paris"))).hasSize(2);
  }
}
