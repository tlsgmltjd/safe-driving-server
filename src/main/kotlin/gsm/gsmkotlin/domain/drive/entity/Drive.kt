package gsm.gsmkotlin.domain.drive.entity

import gsm.gsmkotlin.domain.user.entity.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_drive")
class Drive(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val driveId: Long = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @Column(nullable = false)
    val date: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    val detectedCount: Int = 0,
    @Column(nullable = false)
    var isActive: Boolean = true,
    var exitCount: Int = 0,
    var almostSleepCount: Int = 0,
    var sleepingCount: Int = 0,
    var wakeUpCount: Int = 0
) {
    companion object {
        fun of(user: User): Drive =
            Drive(user = user)
    }
    
    fun end() {
        this.isActive = false
    }
}
