package com.indianajones.contest;

import static com.indianajones.contest.ScenarioBuilder.DATETIME_FORMAT;
import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateTime.parse;
import static org.joda.time.Duration.standardHours;

import org.junit.Test;

import com.google.common.collect.Iterables;


public class SolutionsTest {

  @Test
  public void can_apply_only_destination_on_appropriate_cities() throws Exception {
    Solutions solutions = Solutions.init(new City("Paris"), parse("02:12", DATETIME_FORMAT));
    solutions.apply(new City("Paris"), new Destination(new City("Lyon"), parse("02:12", DATETIME_FORMAT), standardHours(2)));
    
    Solution solution = Iterables.get(solutions.getSolutions(), 0);
    assertThat(solution.isLatestCity(new City("Lyon"))).isTrue();
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(4);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(12);
    
    // Don't return back
    solutions.apply(new City("Lyon"), new Destination(new City("Paris"), parse("05:12", DATETIME_FORMAT), standardHours(2)));
    solution = Iterables.get(solutions.getSolutions(), 0);
    assertThat(solution.isLatestCity(new City("Lyon"))).isTrue();
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(4);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(12);
    
    // Train too early
    solutions.apply(new City("Lyon"), new Destination(new City("Grenoble"), parse("03:59", DATETIME_FORMAT), standardHours(1)));
    solution = Iterables.get(solutions.getSolutions(), 0);
    assertThat(solution.isLatestCity(new City("Lyon"))).isTrue();
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(4);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(12);
    
    // Transit train
    solutions.apply(new City("Lyon"), new Destination(new City("Grenoble"), parse("04:30", DATETIME_FORMAT), standardHours(1)));
    solution = Iterables.get(solutions.getSolutions(), 0);
    assertThat(solution.isLatestCity(new City("Grenoble"))).isTrue();
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(5);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(30);
    
    // Must backup solution
    solution = Iterables.get(solutions.getSolutions(), 1);
    assertThat(solution.isLatestCity(new City("Lyon"))).isTrue();
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(4);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(12);
    
    assertThat(solutions.getSolutions()).hasSize(2);
  }
}
