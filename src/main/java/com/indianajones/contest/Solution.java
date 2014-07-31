package com.indianajones.contest;

import static com.google.common.base.Objects.toStringHelper;
import static com.indianajones.contest.ScenarioBuilder.DATETIME_FORMAT;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.base.Objects;

public class Solution {
  private List<String> path = new LinkedList<String>();
  private DateTime momento;

  public Solution(List<String> path, DateTime momento) {
    this.path = path;
    this.momento = momento;
  }

  public DateTime getMomento() {
    return momento;
  }

  public boolean isLatestCity(City city) {
    return path.isEmpty() 
        || city == null 
        || path.get(path.size() - 1).equals(city.getName());
  }

  public void apply(Destination destination) {
    path.add(destination.getCity().getName());
    momento = destination.getDeparture().plus(destination.getDuration());
  }

  public boolean notVisited(City city) {
    return !path.contains(city.getName());
  }

  public boolean canTransit(Destination destination) {
    return getMomento().isBefore(destination.getDeparture()) 
        || getMomento().isEqual(destination.getDeparture());
  }

  public List<String> getPath() {
    return path;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(path);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Solution)) {
      return false;
    }
    Solution o = (Solution) obj;
    return Objects.equal(path, o.path);
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("path", path)
        .add("momento", getMomento().toString(DATETIME_FORMAT))
        .toString();
  }
  
  
}
