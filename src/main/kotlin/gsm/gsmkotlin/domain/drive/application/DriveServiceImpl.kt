package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.cam.application.CamReader
import gsm.gsmkotlin.domain.cam.application.CamValidator
import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveIsActiveDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import gsm.gsmkotlin.domain.user.application.UserReader
import gsm.gsmkotlin.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DriveServiceImpl(
    private val userUtil: UserUtil,
    private val driveValidator: DriveValidator,
    private val driveProcessor: DriveProcessor,
    private val driveMapper: DriveMapper,
    private val driveReader: DriveReader,
    private val camReader: CamReader,
    private val camValidator: CamValidator
) : DriveService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun start(): DriveStartDto {
        val user = userUtil.getCurrentUser()
        driveValidator.validIsNotActive(user)
        val drive = driveProcessor.start(user)
        return driveMapper.mappingDriveStart(drive)
    }
    
    @Transactional(rollbackFor = [Exception::class])
    override fun end(): DriveEndDto {
        val user = userUtil.getCurrentUser()
        val drive = driveReader.readCurrentDriveByUser(user)
        driveProcessor.end(drive)
        return driveMapper.mappingDriveEnd(drive)
    }
    
    @Transactional(readOnly = true)
    override fun isActive(camId: String, camSecret: String): DriveIsActiveDto {
        val cam = camReader.readCamById(camId)
        camValidator.valid(cam, camSecret)
        val isActive = driveReader.readIsActiveDriveByCam(cam)
        return driveMapper.mappingDriveIsActive(isActive)
    }
    
}
