package gsm.gsmkotlin.domain.detection.application

import gsm.gsmkotlin.domain.cam.application.CamReader
import gsm.gsmkotlin.domain.cam.application.CamValidator
import gsm.gsmkotlin.domain.detection.application.dto.DetectedDto
import gsm.gsmkotlin.domain.drive.application.DriveReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DetectionServiceImpl(
    private val camReader: CamReader,
    private val camValidator: CamValidator,
    private val driveReader: DriveReader,
    private val detectionProcessor: DetectionProcessor
) : DetectionService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun detected(camSecret: String, detectedDto: DetectedDto) {
        val cam = camReader.readCamById(detectedDto.camId)
        camValidator.valid(cam, camSecret)
        val drive = driveReader.readActiveDriveByCam(cam)
        detectionProcessor.detected(drive, detectedDto.type)
    }
}
