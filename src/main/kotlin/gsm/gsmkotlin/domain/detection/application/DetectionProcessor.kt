package gsm.gsmkotlin.domain.detection.application

import gsm.gsmkotlin.domain.detection.repository.DetectionRepository
import gsm.gsmkotlin.domain.detection.entity.Detection
import gsm.gsmkotlin.domain.detection.type.DetectionType
import gsm.gsmkotlin.domain.drive.entity.Drive
import org.springframework.stereotype.Component

@Component
class DetectionProcessor(
    private val detectionRepository: DetectionRepository
) {
    
    fun detected(drive: Drive, detectionType: DetectionType) {
        val detection = Detection.of(drive, detectionType)
        detectionRepository.save(detection)
    }
    
}
