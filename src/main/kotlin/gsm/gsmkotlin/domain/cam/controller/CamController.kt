package gsm.gsmkotlin.domain.cam.controller

import gsm.gsmkotlin.domain.cam.application.CamService
import gsm.gsmkotlin.domain.cam.application.dto.RegisterCamDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cam")
class CamController(
    private val camService: CamService
) {
    
    @PostMapping
    fun register(@RequestBody registerCamDto: RegisterCamDto): ResponseEntity<Void> {
        camService.register(registerCamDto)
        return ResponseEntity.ok().build()
    }
    
}
