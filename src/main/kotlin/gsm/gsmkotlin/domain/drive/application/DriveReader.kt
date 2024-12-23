package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.drive.repository.DriveRepository
import gsm.gsmkotlin.domain.user.entity.User
import gsm.gsmkotlin.global.error.GlobalException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class DriveReader(
    private val driveRepository: DriveRepository
) {
    fun readAllDriveHistoryByUser(user: User): List<Drive> =
        driveRepository.findAllHistoryByUser(user)
    
    fun readCurrentDriveByUser(user: User): Drive =
        driveRepository.findByUserAndActiveIsTrue(user)
            ?: throw GlobalException("운전중이지 않습니다.", HttpStatus.BAD_REQUEST)
    
    fun isActiveDriveByCam(cam: Cam): Boolean =
        driveRepository.findByActiveByCam(cam) != null
    
    fun readActiveDriveByCam(cam: Cam): Drive =
        driveRepository.findByActiveByCam(cam)
            ?: throw GlobalException("운전중인 drive를 찾을 수 없습니다. cam id = ${cam.camId}", HttpStatus.NOT_FOUND)
}
