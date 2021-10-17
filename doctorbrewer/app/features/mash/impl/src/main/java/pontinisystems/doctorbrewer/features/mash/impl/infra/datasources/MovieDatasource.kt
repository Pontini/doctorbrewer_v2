package pontinisystems.movie.infra.datasources

import pontinisystems.movie.infra.model.MovieModel

interface MovieDatasource {

    suspend fun findByCategory(category:String): MovieModel

}