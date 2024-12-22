package gsm.gsmkotlin.domain.user.application.dto

data class SignupDto(
    val accessToken: String,
    val name: String,
    val camId: String,
    val emergencyNumbers: Set<String>
)
