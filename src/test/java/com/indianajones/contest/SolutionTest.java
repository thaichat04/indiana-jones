package com.indianajones.contest;

import static com.indianajones.contest.ScenarioBuilder.DATETIME_FORMAT;
import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateTime.parse;
import static org.joda.time.Duration.standardHours;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;


public class SolutionTest {
  
  private Solution solution;

  @Before
  public void setup() throws Exception {
    solution = new Solution(Lists.newArrayList("Paris"),parse("02:12", DATETIME_FORMAT));
    solution.apply(new Destination(new City("Lyon"), parse("05:00", DATETIME_FORMAT), standardHours(1)));
  }

  @Test
  public void can_check_visited_cities() throws Exception {
    assertThat(solution.notVisited(new City("Paris"))).isFalse();
    assertThat(solution.notVisited(new City("Lyon"))).isFalse();
    assertThat(solution.notVisited(new City("Amsterdam"))).isTrue();
  }
  
  @Test
  public void can_get_latest_city() throws Exception {
    assertThat(solution.isLatestCity(new City("Lyon"))).isTrue();
    
    solution.apply(new Destination(new City("London"), new DateTime(), standardHours(2)));
    assertThat(solution.isLatestCity(new City("London"))).isTrue();
    assertThat(solution.isLatestCity(new City("Lyon"))).isFalse();
  }
  
  @Test
  public void can_calcul_current_moment() throws Exception {
    assertThat(solution.getMomento().getHourOfDay()).isEqualTo(6);
    assertThat(solution.getMomento().getMinuteOfHour()).isEqualTo(0);
  }
}
