package pontinisystems.movie.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pontinisystems.movie.domain.usecases.GetMoviesByCategory
import pontinisystems.movie.infra.repositories.MovieRepositoryImpl
import pontinisystems.core.DefaultDispatcherProvider
import pontinisystems.core.DispactcherProvider
import pontinisystems.movie.infra.database.Database
import pontinisystems.movie.infra.datasources.MovieDatasource
import retrofit2.Retrofit

val movieModuleDependency = module {

    fun provideMovieApi(retrofit: Retrofit) = retrofit.create(MovieApi::class.java)
    factory { provideMovieApi(retrofit = get()) }

    single<MovieDatasource> { MovieDatasourceImpl(get())  }
    single<MovieRepository> {MovieRepositoryImpl(get())  }

    single<GetMoviesByCategory> { GetMoviesByCategoryImpl(get())  }

    single<DispactcherProvider> { DefaultDispatcherProvider() }

    viewModel{
        MoviesViewModel(
            get(),get()
        )
    }

    single { Database(androidContext()) }
    single { get<Database>().movieDao() }

}

