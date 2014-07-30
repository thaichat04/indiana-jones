package com.indianajones.contest;

import static com.google.common.base.Objects.toStringHelper;

import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;

public class City {
  private final String name;
  private final Set<Destination> connection;

  public City(String name) {
    this.name = name;
    this.connection = Sets.newHashSet();
  }
  
  public City(String name, Set<Destination> connection) {
    this.name = name;
    this.connection = connection;
  }

  public String getName() {
    return name;
  }

  public Set<Destination> getDestinations() {
    return connection;
  }
  
  public void addDestination(Destination destination) {
    getDestinations().add(destination);
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof City)) {
      return false;
    }
    City o = (City)obj;
    return Objects.equal(name, o.name);
  }
  
  @Override
  public String toString() {
    return toStringHelper(this)
      .add("name", name)
      .add("connection", connection)
      .toString();
  }

}
