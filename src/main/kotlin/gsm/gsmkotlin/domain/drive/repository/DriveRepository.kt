package gsm.gsmkotlin.domain.drive.repository

import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DriveRepository: JpaRepository<Drive, Long> {
    @Query("SELECT d FROM Drive d WHERE d.user = :user AND d.isActive = false")
    fun findAllHistoryByUser(user: User): List<Drive>
}
