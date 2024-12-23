package gsm.gsmkotlin.domain.drive.controller

import gsm.gsmkotlin.domain.drive.application.DriveService
import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveIsActiveDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/drive")
class DriveController(
    private val driveService: DriveService
) {
    
    @PostMapping("/start")
    fun start(): ResponseEntity<DriveStartDto> {
        val response = driveService.start()
        return ResponseEntity.ok(response)
    }
    
    @PostMapping("/end")
    fun end(): ResponseEntity<DriveEndDto> {
        val response = driveService.end()
        return ResponseEntity.ok(response)
    }
    
    @PostMapping("/status/{camId}")
    fun end(@PathVariable camId: String, httpServletRequest: HttpServletRequest): ResponseEntity<DriveIsActiveDto> {
        val camSecret = httpServletRequest.getHeader("CAM_SECRET")
        val response = driveService.isActive(camId, camSecret)
        return ResponseEntity.ok(response)
    }
    
}
