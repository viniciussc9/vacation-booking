package edu.wgu.d387_sample_code.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/times")
@CrossOrigin
public class TimeController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getPresentationTimes() {
        Map<String, String> timeMap = new HashMap<>();

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime eastern = now.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime mountain = eastern.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utc = eastern.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        timeMap.put("ET", formatter.format(eastern));
        timeMap.put("MT", formatter.format(mountain));
        timeMap.put("UTC", formatter.format(utc));

        return timeMap;
    }
}

