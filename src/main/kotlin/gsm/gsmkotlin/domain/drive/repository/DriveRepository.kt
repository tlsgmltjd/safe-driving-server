package gsm.gsmkotlin.domain.drive.repository

import gsm.gsmkotlin.domain.drive.entity.Drive
import org.springframework.data.jpa.repository.JpaRepository

interface DriveRepository: JpaRepository<Drive, Long> {
}
