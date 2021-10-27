package pontinisystems.doctorbrewer.features.profile.impl.domain.repositories

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.impl.domain.errors.Failure
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile

interface ProfileRepository {
    suspend fun getProfile(): Either<Profile, Failure>
}
