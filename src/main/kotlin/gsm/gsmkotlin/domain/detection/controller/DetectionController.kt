package gsm.gsmkotlin.domain.detection.controller

import gsm.gsmkotlin.domain.detection.application.DetectionService
import gsm.gsmkotlin.domain.detection.application.dto.DetectedDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/detection")
class DetectionController(
    private val detectionService: DetectionService
) {
    
    @PostMapping
    fun detection(@RequestBody detectedDto: DetectedDto, httpServletRequest: HttpServletRequest): ResponseEntity<Void> {
        val camSecret = httpServletRequest.getHeader("CAM_SECRET")
        detectionService.detected(camSecret, detectedDto)
        return ResponseEntity.ok().build()
    }
    
}
