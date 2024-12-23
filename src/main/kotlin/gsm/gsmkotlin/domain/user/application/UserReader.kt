package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.user.repository.UserRepository
import gsm.gsmkotlin.global.error.GlobalException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository
) {
    
    fun readUserByEmail(email: String) =
        userRepository.findByEmail(email)
            ?: throw GlobalException("유저를 찾을 수 없습니다. email = $email", HttpStatus.NOT_FOUND)
    
    fun readUserByEmailOrNull(email: String) = userRepository.findByEmail(email)
    
}
