package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveIsActiveDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto

interface DriveService {
    fun start(): DriveStartDto
    fun end(): DriveEndDto
    fun isActive(camId: String, camSecret: String): DriveIsActiveDto
}
