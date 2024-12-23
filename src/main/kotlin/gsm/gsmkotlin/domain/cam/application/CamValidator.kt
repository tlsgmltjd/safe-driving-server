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
    
    fun validIsDuplicatedCamId(camId: String) {
        val isExist = camRepository.existsById(camId)
        if(isExist) {
            throw GlobalException("cam id가 중복됩니다. cma id = $camId", HttpStatus.BAD_REQUEST)
        }
    }
    
}
