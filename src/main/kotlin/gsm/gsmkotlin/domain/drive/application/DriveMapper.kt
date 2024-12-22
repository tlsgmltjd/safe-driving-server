package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.user.application.dto.DetectionDetailDto
import org.springframework.stereotype.Component

@Component
class DriveMapper {
    
    fun mappingDriveStart(drive: Drive) =
        DriveStartDto(drive.driveId)
    
    fun mappingDriveEnd(drive: Drive) =
        DriveEndDto(
            detectionCount = drive.detectedCount,
            detectionInfo = DetectionDetailDto(
                exit = drive.exitCount,
                almostSleep = drive.almostSleepCount,
                sleeping = drive.sleepingCount
            )
        )
    
}
