package com.indianajones.contest;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import org.joda.time.Duration;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class ScenarioTest {

  @Test
  public void can_build_scenario() throws Exception {
    City from = new City("Paris");
    City to = new City("Berlin");

    Scenario scenario = new ScenarioBuilder().departure("08:20").from(from).to(to)
        .withTimeTableLine("09:20;Paris;Amsterdam;03:20").withTimeTableLine("08:30;Paris;Bruxelles;01:20")
        .withTimeTableLine("10:00;Bruxelles;Amsterdam;02:10").build();

    assertThat(scenario.getDepart()).isEqualTo(from);
    assertThat(scenario.getArrival()).isEqualTo(to);
    assertThat(scenario.getDeparture().getHourOfDay()).isEqualTo(8);
    assertThat(scenario.getDeparture().getMinuteOfHour()).isEqualTo(20);

    assertThat(scenario.getTimetable()).contains(from, new City("Bruxelles"));
    Set<Destination> fromParisDestination = scenario.getTimetable().get(0).getDestinations();
    assertThat(fromParisDestination).hasSize(2);

    Destination bruxelles = Iterables.get(fromParisDestination, 0);
    assertThat(bruxelles.getCity()).isEqualTo(new City("Bruxelles"));
    assertThat(bruxelles.getDeparture().getHourOfDay()).isEqualTo(8);
    assertThat(bruxelles.getDeparture().getMinuteOfHour()).isEqualTo(30);

    Destination amsterdam = Iterables.get(fromParisDestination, 1);
    assertThat(amsterdam.getCity()).isEqualTo(new City("Amsterdam"));
    assertThat(amsterdam.getDeparture().getHourOfDay()).isEqualTo(9);
    assertThat(amsterdam.getDeparture().getMinuteOfHour()).isEqualTo(20);

    Set<Destination> fromBruxellesDestination = scenario.getTimetable().get(1).getDestinations();
    Duration durationBruxelleAmsterdam = fromBruxellesDestination.iterator().next().getDuration();
    assertThat(durationBruxelleAmsterdam.getStandardHours()).isEqualTo(2);
    assertThat(durationBruxelleAmsterdam.getStandardMinutes()).isEqualTo(2 * 60 + 10);

  }
}
