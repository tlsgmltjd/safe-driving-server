package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto

interface DriveService {
    fun start(): DriveStartDto
}
