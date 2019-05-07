package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalTime

@Configuration
class LunchConfiguration {

    @Bean
    fun databaseInitializer(lunchRepository: LunchRepository,
                            locationRepository: LocationRepository) = ApplicationRunner {
        locationRepository.deleteAll();
        val creos = locationRepository.save(Location(
                name = "Creos",
                id = 0
        ));
        lunchRepository.deleteAll()
        lunchRepository.save(Lunch("Pasta Donnertag",
                startTime = LocalTime.of(11, 45),
                date = LocalDate.now(),
                meetingPoint = "Fahrstuhl",
                location = creos,
                id = 0
        ))
    }
}
