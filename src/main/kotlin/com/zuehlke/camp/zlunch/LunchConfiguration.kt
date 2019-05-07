package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalTime

@Configuration
class LunchConfiguration {

    @Bean
    fun databaseInitializer(lunchRepository: LunchRepository,
                            locationRepository: LocationRepository,
                            userRepository: UserRepository,
                            participationRepository: ParticipationRepository) = ApplicationRunner {

        userRepository.deleteAll()
        participationRepository.deleteAll()
        locationRepository.deleteAll()
        lunchRepository.deleteAll()


        val rene = userRepository.save(User(
                name = "Rene",
                id = 0)
        )

        val creos = locationRepository.save(Location(
                name = "Creos",
                id = 0
        ));

        val lunch = lunchRepository.save(Lunch(
                name = "Pasta Donnertag",
                startTime = LocalTime.of(11, 45),
                date = LocalDate.now(),
                meetingPoint = "Fahrstuhl",
                location = creos,
                id = 0
        ))

        participationRepository.save(Participation(user = rene, lunch = lunch, id = 0))

    }
}
