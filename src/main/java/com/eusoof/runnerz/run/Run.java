package com.eusoof.runnerz.run;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

        public Run {
                if (miles < 0) {
                        throw new IllegalArgumentException("Miles cannot be negative");
                }
                if (!completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("Completed date must be after started date");
                }
        }

}
