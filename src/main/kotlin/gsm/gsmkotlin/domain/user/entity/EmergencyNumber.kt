package gsm.gsmkotlin.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_emergency_number")
class EmergencyNumber(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val emergencyNumberId: Long = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @Column(nullable = false)
    val number: String,
) {
    companion object {
        fun of(user: User, number: String): EmergencyNumber =
            EmergencyNumber(user = user, number = number)
    }
}
