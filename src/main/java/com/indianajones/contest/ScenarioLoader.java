package com.indianajones.contest;

import static com.google.common.collect.Iterables.get;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Splitter;

public class ScenarioLoader {

  public static Scenario load(InputStream inputStream) throws IOException {
    List<String> lines = IOUtils.readLines(inputStream);
    Iterable<String> firstLine = Splitter.on(";").trimResults().split(lines.get(0));
    int nbTimeLines = Integer.valueOf(lines.get(1));

    ScenarioBuilder builder = new ScenarioBuilder();
    builder.departure(get(firstLine, 0));
    builder.from(new City(get(firstLine, 1)));
    builder.to(new City(get(firstLine, 2)));
    
    for (int i=2; i<lines.size() && (i-2 < nbTimeLines); i++) {
      builder.withTimeTableLine(lines.get(i));
    }
    
    return builder.build();
  }
}
