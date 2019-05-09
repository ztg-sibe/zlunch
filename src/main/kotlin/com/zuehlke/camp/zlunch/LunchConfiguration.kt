package com.zuehlke.camp.zlunch

import com.zuehlke.camp.zlunch.entity.Location
import com.zuehlke.camp.zlunch.entity.Lunch
import com.zuehlke.camp.zlunch.entity.Participation
import com.zuehlke.camp.zlunch.entity.User
import com.zuehlke.camp.zlunch.services.LocationRepository
import com.zuehlke.camp.zlunch.services.LunchRepository
import com.zuehlke.camp.zlunch.services.ParticipationRepository
import com.zuehlke.camp.zlunch.services.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class LunchConfiguration {

    @Bean
    fun databaseInitializer(lunchRepository: LunchRepository,
                            locationRepository: LocationRepository,
                            userRepository: UserRepository,
                            participationRepository: ParticipationRepository) = ApplicationRunner {

        userRepository.deleteAll()
                .then(participationRepository.deleteAll())
                .then(locationRepository.deleteAll())
                .then(lunchRepository.deleteAll())
                .then(locationRepository.save(Location(name = "Cleos")))
                .flatMap { cleos ->
                    lunchRepository.save(Lunch(
                            name = "Pasta Donnertag",
                            meetingPoint = "Fahrstuhl",
                            location = cleos
                    )).zipWith(userRepository.save(User(name = "Rene"))) { cleosGroup, rene ->
                        participationRepository.save(Participation(user = rene, lunch = cleosGroup)).subscribe()
                    }
                }
                .then(locationRepository.save(Location(name = "Sultan")))
                .flatMap { döner ->
                    lunchRepository.save(Lunch(
                            name = "Dönerstag",
                            meetingPoint = "Fahrstuhl",
                            location = döner,
                            date = LocalDate.now().minusDays(7)
                    )).then(lunchRepository.save(Lunch(
                            name = "Dönerstag",
                            meetingPoint = "Fahrstuhl",
                            location = döner
                    )))
                    .zipWith(userRepository.save(User(name = "Fahed"))) { dönerGroup, fahed ->
                        participationRepository.save(Participation(user = fahed, lunch = dönerGroup)).subscribe()
                    }


                }
                .then()
                .log()
                .block()
    }
}
