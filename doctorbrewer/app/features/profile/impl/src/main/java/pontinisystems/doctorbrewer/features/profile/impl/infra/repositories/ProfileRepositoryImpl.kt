package pontinisystems.doctorbrewer.features.profile.impl.infra.repositories

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.impl.domain.errors.Failure
import pontinisystems.doctorbrewer.features.profile.impl.domain.repositories.ProfileRepository
import pontinisystems.doctorbrewer.features.profile.impl.infra.database.dao.ProfileDao
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(private val dao: ProfileDao) : ProfileRepository {


    override suspend fun getProfile(): Either<Profile, Failure> {
        return Either.Error(Failure.NetworkFailure(10,""))
    }

}