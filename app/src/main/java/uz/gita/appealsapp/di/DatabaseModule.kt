package uz.gita.appealsapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.appealsapp.database.AppealDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppealDatabase::class.java, "Appeals.db")
        .createFromAsset("Appeals.db")
        .build()


    @Provides
    @Singleton
    fun provideDao(
        appealDatabase: AppealDatabase
    ) = appealDatabase.AppealDao()

}