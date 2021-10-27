package pontinisystems.doctorbrewer.features.profile.publ.domain.usecases

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile

interface ProfileIsRegistered {
    suspend operator fun invoke(): Either<Boolean,Exception>
}