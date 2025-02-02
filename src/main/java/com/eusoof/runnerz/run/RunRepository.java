package com.eusoof.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id)).findFirst();
    }

    //post
    void create(Run run) {
        runs.add(run);
    }

    //put
    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        /*
        if (existingRun.isEmpty()) {
            return;
        }
        runs.remove(existingRun.get());
        runs.add(run);
        */
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    //delete
    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.remove(existingRun.get());
        }
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 55, Location.OUTDOOR));
        runs.add(new Run(2, "Second Run",LocalDateTime.now(), LocalDateTime.now().plusDays(1), 66, Location.INDOOR));
    }
}
