package com.indianajones.contest;

import static com.google.common.base.Objects.toStringHelper;
import static com.indianajones.contest.ScenarioBuilder.DATETIME_FORMAT;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import com.google.common.base.Objects;

public class Destination {

  private final DateTime departure;
  private final Duration duration;
  private final City city;

  public Destination(String name, DateTime departure, Duration duration) {
    this(new City(name), departure, duration);
  }

  public Destination(City to, DateTime departure, Duration duration) {
    this.city = to;
    this.departure = departure;
    this.duration = duration;
  }

  public DateTime getDeparture() {
    return departure;
  }

  public Duration getDuration() {
    return duration;
  }

  public City getCity() {
    return city;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(city.getName());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Destination)) {
      return false;
    }

    Destination o = (Destination) obj;
    return Objects.equal(city.getName(), o.city.getName());
  }
  
  @Override
  public String toString() {
    return toStringHelper(this)
      .add("city", city)
      .add("departure", departure.toString(DATETIME_FORMAT))
      .add("duration", duration)
      .toString();
  }

}
