package com.indianajones.contest;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class PathFinderTest {
  

  @Test
  public void can_find_best_path_on_a_simple_scenario() throws Exception {
    Scenario simpleScenario = ScenarioLoader.load(PathFinderTest.class.getResourceAsStream("/sample/input-simple.txt"));
    PathFinder finder = new PathFinder(simpleScenario);
    finder.find(simpleScenario.getDepart());
    assertThat(finder.bestSolution().getPath()).containsExactly("Paris", "Amsterdam");
  }
  
  @Test
  public void can_find_best_path_on_a_scenario_with_two_possibble_paths() throws Exception {
    Scenario simpleScenario = ScenarioLoader.load(PathFinderTest.class.getResourceAsStream("/sample/input-simple-2paths.txt"));
    PathFinder finder = new PathFinder(simpleScenario);
    finder.find(simpleScenario.getDepart());
    assertThat(finder.bestSolution().getPath()).containsExactly("Paris", "Bruxelles", "Amsterdam");
    assertThat(finder.bestSolution().getMomento().getHourOfDay()).isEqualTo(12);
    assertThat(finder.bestSolution().getMomento().getMinuteOfHour()).isEqualTo(10);
  }
  
  @Test
  public void can_find_best_path_on_a_scenario_with_no_solution() throws Exception {
    Scenario simpleScenario = ScenarioLoader.load(PathFinderTest.class.getResourceAsStream("/sample/input-no-solution.txt"));
    PathFinder finder = new PathFinder(simpleScenario);
    finder.find(simpleScenario.getDepart());
    assertThat(finder.bestSolution()).isNull();
  }
  
  @Test
  public void can_find_best_path_on_a_complex_scenario() throws Exception {
    Scenario simpleScenario = ScenarioLoader.load(PathFinderTest.class.getResourceAsStream("/sample/input.txt"));
    PathFinder finder = new PathFinder(simpleScenario);
    finder.find(simpleScenario.getDepart());
    assertThat(finder.bestSolution().getPath()).containsExactly("Paris", "Bruxelles", "Amsterdam", "Berlin");
    assertThat(finder.bestSolution().getMomento().getHourOfDay()).isEqualTo(18);
    assertThat(finder.bestSolution().getMomento().getMinuteOfHour()).isEqualTo(40);
  }
}
