package gsm.gsmkotlin.domain.detection.repository

import gsm.gsmkotlin.domain.detection.entity.Detection
import org.springframework.data.jpa.repository.JpaRepository

interface DetectionRepository: JpaRepository<Detection, Long> {
}
