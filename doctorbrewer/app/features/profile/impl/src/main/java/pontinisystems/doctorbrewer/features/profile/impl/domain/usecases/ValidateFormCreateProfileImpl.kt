package pontinisystems.doctorbrewer.features.profile.impl.domain.usecases

import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.impl.domain.errors.Failure
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile
import pontinisystems.doctorbrewer.features.profile.publ.domain.usecases.ValidateFormCreateProfile

class ValidateFormCreateProfileImpl : ValidateFormCreateProfile {

    override suspend fun invoke(profile: Profile): Either<Unit, Exception> {
        if (profile.name.length < 3 && profile.lastName.length < 3) {
            return Either.Error(Failure.InputInvalid())
        }
        return Either.Success(Unit)
    }

}