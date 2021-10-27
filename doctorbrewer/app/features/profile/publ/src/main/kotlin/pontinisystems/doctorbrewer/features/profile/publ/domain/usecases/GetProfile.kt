package pontinisystems.doctorbrewer.features.profile.publ.domain.usecases

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile

interface GetProfile {
    suspend operator fun invoke(): Either<Profile,Exception>
}