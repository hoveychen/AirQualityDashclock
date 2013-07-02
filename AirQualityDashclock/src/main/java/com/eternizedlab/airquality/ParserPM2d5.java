package com.eternizedlab.airquality;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserPM2d5 {
    private QueryResults results = new QueryResults();
    // "实时空气质量指数(AQI)";             jin_value = "40";
    private static final Pattern AQI_PATTERN = Pattern.compile(
            "\\s*jin_value\\s=\\s\"(\\d+)\";");

    public void parse(String htmlBody) {
        Matcher matcher = AQI_PATTERN.matcher(htmlBody);
        if (matcher.find()) {
            results.setOverallAQI(Integer.valueOf(matcher.group(1)));
        } else {
            results.setOverallAQI(-1);
        }
        if (matcher.find()) {
            results.setOverallAQIInUS(Integer.valueOf(matcher.group(1)));
        } else {
            results.setOverallAQIInUS(-1);
        }

    }

    public QueryResults getResults() {
        return results;
    }
}
