package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import gsm.gsmkotlin.domain.drive.entity.Drive
import org.springframework.stereotype.Component

@Component
class DriveMapper {
    
    fun mappingDriveStart(drive: Drive) =
        DriveStartDto(drive.driveId)
    
}
