package gsm.gsmkotlin.domain.detection.application.dto

import gsm.gsmkotlin.domain.detection.type.DetectionType

data class DetectedDto(
    val camId: String,
    val type: DetectionType
)
