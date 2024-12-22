package gsm.gsmkotlin.domain.drive.controller

import gsm.gsmkotlin.domain.drive.application.DriveService
import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import org.springframework.http.ResponseEntity
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
    
}
