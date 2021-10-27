package pontinisystems.doctorbrewer.features.profile.impl.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pontinisystems.core.DefaultDispatcherProvider
import pontinisystems.core.DispatcherProvider
import pontinisystems.doctorbrewer.features.profile.impl.domain.repositories.ProfileRepository
import pontinisystems.doctorbrewer.features.profile.impl.infra.database.DataBaseBuilder
import pontinisystems.doctorbrewer.features.profile.impl.infra.database.dao.ProfileDao
import pontinisystems.doctorbrewer.features.profile.impl.infra.repositories.ProfileRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProfileModuleDependency {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DataBaseBuilder {
        return Room.databaseBuilder(
            context,
            DataBaseBuilder::class.java,
            DataBaseBuilder.DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideProfileDao(database: DataBaseBuilder): ProfileDao {
        return database.profileDao()
    }

    @Provides
    @Singleton
    fun provideProfileRepository(profileDao: ProfileDao): ProfileRepository =
        ProfileRepositoryImpl(profileDao)

    @Provides
    @Singleton
    fun provideDispatcher(): DispatcherProvider = DefaultDispatcherProvider()

}
