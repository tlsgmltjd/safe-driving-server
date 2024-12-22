package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.drive.repository.DriveRepository
import gsm.gsmkotlin.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class DriveProcessor(
    private val driveRepository: DriveRepository
) {
    
    fun start(user: User): Drive {
        val drive = Drive.of(user)
        return driveRepository.save(drive)
    }
    
}
