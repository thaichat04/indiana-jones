package com.indianajones.contest;

import static com.indianajones.contest.ScenarioBuilder.DATETIME_FORMAT;

import java.io.File;
import java.io.FileInputStream;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSortedMap;

public class PathFinder {

  private static final Logger logger = LoggerFactory.getLogger(PathFinder.class);
  
  private final Scenario scenario;
  private final Solutions solutions;

  public PathFinder(Scenario scenario) {
    this.scenario = scenario;
    this.solutions = Solutions.init(scenario.getDepart(), scenario.getDeparture());
  }

  public void find(City city) {
    logger.debug("Current solutions:" + solutions);
    
    if (!city.equals(scenario.getArrival())) {
      for (Destination d : scenario.getDestinationsFrom(city)) {
        if (solutions.apply(city, d)) {
          find(d.getCity());
        }
      }
    }
  }

  @VisibleForTesting
  Solutions getSolutions() {
    return solutions;
  }
  
  public Solution bestSolution() {
    ImmutableSortedMap.Builder<DateTime, Solution> sortedBuilder = ImmutableSortedMap.<DateTime, Solution>naturalOrder();
    for (Solution s: solutions.getSolutions()) {
      if (s.isLatestCity(scenario.getArrival())) {
        sortedBuilder.put(s.getMomento(), s);
      }
    }
    ImmutableSortedMap<DateTime, Solution> sortedMap = sortedBuilder.build();

    return sortedMap.isEmpty() ? null : sortedMap.values().iterator().next();
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java -cp [classpath] com.indianajones.contest.PathFinder [input-file-path]");
      return;
    }
    
    File inputFile = new File(args[0]);
    if (!inputFile.exists()) {
      System.out.println(inputFile.getAbsolutePath() + " not exist");
      return;
    }
    
    try {
      Scenario scenario = ScenarioLoader.load(new FileInputStream(inputFile));
      PathFinder finder = new PathFinder(scenario);
      finder.find(scenario.getDepart());
      
      Solution bestSolution = finder.bestSolution();
      if (bestSolution != null) {
        System.out.println(bestSolution.getMomento().toString(DATETIME_FORMAT));
      }
    } catch (Exception e) {
      logger.error("Error", e);
    }
  }
}
