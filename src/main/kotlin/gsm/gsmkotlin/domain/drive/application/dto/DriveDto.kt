package gsm.gsmkotlin.domain.drive.application.dto

import gsm.gsmkotlin.domain.user.application.dto.DetectionDetailDto

data class DriveStartDto(
    val driveId: Long
)

data class DriveEndDto(
    val detectionCount: Int,
    val detectionInfo: DetectionDetailDto
)

data class DriveIsActiveDto(
    val isActive: Boolean
)
