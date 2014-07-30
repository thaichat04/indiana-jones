package com.indianajones.contest;

import static com.google.common.base.Objects.toStringHelper;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.filter;

import java.util.Set;

import org.joda.time.DateTime;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Solutions {
  private final Set<Solution> solutions;

  private Solutions() {
    solutions = Sets.newHashSet();
  }

  public static Solutions init(City startCity, DateTime dateTime) {
    Solutions solutions = new Solutions();
    Solution initSolution = new Solution(Lists.newArrayList(startCity.getName()), dateTime);
    solutions.getSolutions().add(initSolution);
    return solutions;
  }

  public boolean apply(final City fromCity, final Destination destination) {
    Predicate<Solution> transitableOnly = new Predicate<Solution>() {
      public boolean apply(Solution solution) {
        return solution.isLatestCity(fromCity)
            && solution.notVisited(destination.getCity())
            && solution.canTransit(destination);
      }
    };

    for (Solution applicableSolution : filter(solutions, transitableOnly)) {
      Solution currentSolution = new Solution(newArrayList(applicableSolution.getPath()), applicableSolution.getMomento());
      solutions.add(currentSolution);
      applicableSolution.apply(destination);
      return true;
    }

    return false;
  }

  public Set<Solution> getSolutions() {
    return solutions;
  }
  
  @Override
  public String toString() {
    return toStringHelper(this)
        .add("solutions", solutions)
        .toString();
  }

}
