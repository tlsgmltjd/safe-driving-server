package gsm.gsmkotlin.domain.detection.application

import gsm.gsmkotlin.domain.detection.application.dto.DetectedDto

interface DetectionService {
    fun detected(camSecret: String, detectedDto: DetectedDto)
}
