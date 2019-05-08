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

@Configuration
class LunchConfiguration {

    @Bean
    fun databaseInitializer(lunchRepository: LunchRepository,
                            locationRepository: LocationRepository,
                            userRepository: UserRepository,
                            participationRepository: ParticipationRepository) = ApplicationRunner {

//        userRepository.deleteAll()
//        participationRepository.deleteAll()
//        locationRepository.deleteAll()
//        lunchRepository.deleteAll()
//
//
//        val rene = userRepository.save(User(name = "Rene"))
//        val fahed = userRepository.save(User(name = "Fahed"))
//
//        val creos = locationRepository.save(Location(name = "Creos"))
//        val döner = locationRepository.save(Location(name = "Sultan"))
//
//        val group1 = lunchRepository.save(Lunch(
//                name = "Pasta Donnertag",
//                meetingPoint = "Fahrstuhl",
//                location = creos
//        ))
//
//        val group2 = lunchRepository.save(Lunch(
//                name = "Dönerstag",
//                meetingPoint = "Fahrstuhl",
//                location = döner
//        ))
//
//        val part1 = participationRepository.save(Participation(user = rene, lunch = group1))
//        val part2 = participationRepository.save(Participation(user = fahed, lunch = group2))
//
//        print("")
    }
}
