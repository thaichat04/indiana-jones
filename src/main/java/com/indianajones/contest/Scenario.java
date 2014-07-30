package com.indianajones.contest;

import static com.google.common.base.Objects.toStringHelper;

import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class Scenario {

  private final City depart;
  private final City arrival;
  private final DateTime departure;
  private final List<City> timetable;

  Scenario(City depart, City arrival, DateTime departure, List<City> timetable) {
    this.depart = depart;
    this.arrival = arrival;
    this.departure = departure;
    this.timetable = timetable;
  }

  public City getDepart() {
    return depart;
  }

  public City getArrival() {
    return arrival;
  }

  public DateTime getDeparture() {
    return departure;
  }

  public List<City> getTimetable() {
    return timetable;
  }
  
  public Set<Destination> getDestinationsFrom(City city) {
    int pos = timetable.indexOf(city);
    if (pos >= 0) {
      return Iterables.get(timetable, pos).getDestinations();
    }
    return Sets.newHashSet();
  }
  
  @Override
  public String toString() {
    return toStringHelper(this)
        .add("departCity", depart)
        .add("arrivalCity", arrival)
        .add("departureTime", departure)
        .add("timetable", timetable)
        .toString();
  }
}
