package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.user.application.dto.DetectionDetailDto
import gsm.gsmkotlin.domain.user.application.dto.DriveDetailDto
import gsm.gsmkotlin.domain.user.application.dto.UserInfoDto
import gsm.gsmkotlin.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    
    fun mappingUserInfo(user: User, driveHistory: List<Drive>): UserInfoDto {
        val drives = driveHistory.map {
            DriveDetailDto(
                date = it.date,
                detectionCount = it.detectedCount,
                detectionInfo = DetectionDetailDto(
                    exit = it.exitCount,
                    almostSleep = it.almostSleepCount,
                    sleeping = it.sleepingCount
                )
            )
        }
        
        val userInfo = UserInfoDto(
            name = user.name!!,
            email = user.email,
            driveCount = drives.size,
            drives = drives
        )
        
        return userInfo
    }
    
}
