package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.drive.repository.DriveRepository
import gsm.gsmkotlin.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class DriveReader(
    private val driveRepository: DriveRepository
) {
    fun readAllDriveHistoryByUser(user: User): List<Drive> =
        driveRepository.findAllHistoryByUser(user)
}
