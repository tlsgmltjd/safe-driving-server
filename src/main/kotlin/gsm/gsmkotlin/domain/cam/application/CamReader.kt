package gsm.gsmkotlin.domain.cam.application

import gsm.gsmkotlin.domain.cam.repository.CamRepository
import gsm.gsmkotlin.global.error.GlobalException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class CamReader(
    private val camRepository: CamRepository
) {
    
    fun readCamById(camId: String) =
        camRepository.findByIdOrNull(camId)
            ?: throw GlobalException("존재하지 않는 카메라입니다. cam id = $camId", HttpStatus.NOT_FOUND)
    
}
