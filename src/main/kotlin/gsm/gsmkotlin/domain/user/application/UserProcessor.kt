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
    
    fun register(email: String): User {
        val userEntity = User.of(email)
        return userRepository.save(userEntity)
    }
    
    fun signup(user: User, name: String, cam: Cam, emergencyNumbers: Set<String>) {
        user.signup(name, cam)
        
        val emergencyNumberEntities = emergencyNumbers.stream()
            .map { EmergencyNumber.of(user, it) }
            .toList()
        
        userRepository.save(user)
        emergencyNumberRepository.saveAll(emergencyNumberEntities)
    }
    
}
