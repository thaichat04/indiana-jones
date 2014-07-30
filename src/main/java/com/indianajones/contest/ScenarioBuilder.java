package com.indianajones.contest;

import static org.joda.time.DateTime.parse;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ScenarioBuilder {
  
  public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormat.forPattern("HH:mm");
  private static final  PeriodFormatter hoursMinutes= new PeriodFormatterBuilder().appendHours().appendSeparator(":").appendMinutes().toFormatter();
  
  private City from;
  private City to;
  private DateTime departure;
  private List<City> timetable = Lists.newArrayList();

  public ScenarioBuilder from(City from) {
    this.from = from;
    return this;
  }
  
  public ScenarioBuilder to(City to) {
    this.to = to;
    return this;
  }
  
  public ScenarioBuilder departure(String departTime) {
    this.departure = parse(departTime, DATETIME_FORMAT);
    return this;
  }
  
  public ScenarioBuilder withTimeTableLine(String timeTableLine) {
    Iterable<String> elements = Splitter.on(";").trimResults().split(timeTableLine);
    String departure = Iterables.get(elements, 0);
    String from = Iterables.get(elements, 1);
    String to = Iterables.get(elements, 2);
    String duration = Iterables.get(elements, 3);
    
    City fromCity = new City(from);
    int indexOf = timetable.indexOf(fromCity);
    if (indexOf >= 0) {
      fromCity = timetable.get(indexOf);
    } else {
      timetable.add(fromCity);
    }
    
    City toCity = new City(to);
    
    if (!fromCity.getDestinations().contains(toCity)) {
      fromCity.addDestination(new Destination(toCity, parse(departure, DATETIME_FORMAT), hoursMinutes.parsePeriod(duration).toStandardDuration()));
    }
    
    return this;
  }
  
  public Scenario build() {
    return new Scenario(from, to, departure, timetable);
  }
  
}