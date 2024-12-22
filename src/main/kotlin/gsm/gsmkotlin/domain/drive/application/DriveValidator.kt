package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.repository.DriveRepository
import gsm.gsmkotlin.domain.user.entity.User
import gsm.gsmkotlin.global.error.GlobalException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class DriveValidator(
    private val driveRepository: DriveRepository
) {
    
    fun validIsNotActive(user: User) {
        val isActive = driveRepository.existByUserAndActiveIsTrue(user)
        if(isActive) {
            throw GlobalException("현재 운전중입니다.", HttpStatus.BAD_GATEWAY)
        }
    }
    
}
