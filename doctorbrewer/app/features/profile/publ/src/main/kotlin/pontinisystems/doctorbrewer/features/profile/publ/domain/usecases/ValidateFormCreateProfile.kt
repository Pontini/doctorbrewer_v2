package pontinisystems.doctorbrewer.features.profile.publ.domain.usecases

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile

interface ValidateFormCreateProfile {
    suspend operator fun invoke(profile: Profile): Either<Unit,Exception>
}