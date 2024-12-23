package gsm.gsmkotlin.domain.user.entity

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.user.type.Authority
import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val id: Long = 0,

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(100)")
    val email: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var name: String? = null,
    
    @JoinColumn(name = "cam_id", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    var cam: Cam? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false)
    var authority: Authority = Authority.UNAUTHORIZATION
) {
    fun signup(name: String, cam: Cam) {
        this.name = name
        this.cam = cam
        this.authority = Authority.USER
    }
    
    companion object {
        fun of(email: String) = User(email = email)
    }
}
