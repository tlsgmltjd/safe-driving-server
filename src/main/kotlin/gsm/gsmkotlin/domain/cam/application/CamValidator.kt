package gsm.gsmkotlin.domain.cam.application

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.cam.repository.CamRepository
import gsm.gsmkotlin.global.error.GlobalException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class CamValidator(
    private val camRepository: CamRepository
) {
    
    fun valid(cam: Cam, camSecret: String) {
        if(cam.camSecret != camSecret) {
            throw GlobalException("카메라 secret 값이 유효하지 않습니다.", HttpStatus.BAD_REQUEST)
        }
    }
    
}
