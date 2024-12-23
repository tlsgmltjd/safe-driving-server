package gsm.gsmkotlin.domain.detection.application

import gsm.gsmkotlin.domain.detection.repository.DetectionRepository
import gsm.gsmkotlin.domain.detection.entity.Detection
import gsm.gsmkotlin.domain.detection.type.DetectionType
import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.drive.repository.DriveRepository
import org.springframework.stereotype.Component

@Component
class DetectionProcessor(
    private val driveRepository: DriveRepository,
    private val detectionRepository: DetectionRepository
) {
    
    fun detected(drive: Drive, detectionType: DetectionType) {
        when (detectionType) {
            DetectionType.EXIT -> drive.addExitCount()
            DetectionType.ALMOST_SLEEP -> drive.addAlmostSleepCount()
            DetectionType.SLEEPING -> drive.addSleepingCount()
            DetectionType.WAKE_UP -> drive.addWakeUpCount()
        }
        
        val detection = Detection.of(drive, detectionType)
        driveRepository.save(drive)
        detectionRepository.save(detection)
    }
    
}
