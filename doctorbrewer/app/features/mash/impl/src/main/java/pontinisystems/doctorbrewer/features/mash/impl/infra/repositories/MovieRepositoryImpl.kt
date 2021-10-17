package pontinisystems.movie.infra.repositories

import pontinisystems.core.Either
import pontinisystems.movie.domain.entities.Movie
import pontinisystems.network.CustomException
import pontinisystems.movie.infra.datasources.MovieDatasource
import java.util.*

class MovieRepositoryImpl(
    private val datasource: MovieDatasource

    ) : MovieRepository {
    override suspend fun searchByCategory(category: String): Either<List<Movie>, Failure> {
        return try {

            val result = datasource.findByCategory(category)

            Either.Success(result.results)

        } catch (e: CustomException) {
            when (e) {
                is CustomException.TimeOutException -> Either.Error(
                    Failure.NetworkFailure(
                        30,
                        "Tente novamente mais tarde"
                    )
                )
                is CustomException.Network -> Either.Error(
                    Failure.NetworkFailure(
                        30,
                        "Tente novamente mais tarde"
                    )
                )
                is CustomException.ResponseBodyError -> Either.Error(
                    Failure.NetworkFailure(
                        10,
                        "Falha no servidor"
                    )
                )
                is CustomException.SessionExpired -> Either.Error(
                    Failure.NetworkFailure(
                        30,
                        "Refazer login"
                    )
                )
                is CustomException.Unknown -> {
                    Either.Error(Failure.Unknown("Falha inesperada. Já estamos trabalhando nisso."))
                }
            }

        }
    }
}