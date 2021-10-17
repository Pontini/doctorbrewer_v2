package pontinisystems.movie.infra.model

import pontinisystems.movie.domain.entities.Movie

data class MovieModel(
    val page:Int,
    val results:List<Movie>

){}