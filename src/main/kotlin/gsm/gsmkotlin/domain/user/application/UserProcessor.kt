package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.user.entity.EmergencyNumber
import gsm.gsmkotlin.domain.user.entity.User
import gsm.gsmkotlin.domain.user.repository.EmergencyNumberRepository
import gsm.gsmkotlin.domain.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserProcessor(
    private val userRepository: UserRepository,
    private val emergencyNumberRepository: EmergencyNumberRepository
) {
    
    fun signup(email: String, name: String, cam: Cam, emergencyNumbers: Set<String>) {
        val userEntity = User(
            email = email,
            name = name,
            cam = cam
        )
        
        val emergencyNumberEntities = emergencyNumbers.stream()
            .map { EmergencyNumber.of(userEntity, it) }
            .toList()
        
        userRepository.save(userEntity)
        emergencyNumberRepository.saveAll(emergencyNumberEntities)
    }
    
}
