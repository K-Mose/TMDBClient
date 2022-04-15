package com.kmose.tmdbclient.data.db

import com.google.common.truth.Truth.assertThat
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.provider.SelfDestructiveThread
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kmose.tmdbclient.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        // inMemoryDatabaseBuilder - 테스트에서 사용할 수 있도록 임시적인 데이터 저장공간을 제공한다. 데이터가 지속적이지 않아서 테스트가 끝나면 데이터는 제거된다.
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java,
        ).build()
        dao = database.movieDao()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overView1", "posterPath1", "date1", "title1"),
            Movie(2, "overView2", "posterPath2", "date2", "title2"),
            Movie(3, "overView3", "posterPath3", "date3", "title3"),
        )
        dao.saveMovies(movies)
        val allMovie = dao.getMovies()
        assertThat(allMovie).isEqualTo(movies)
    }

    @Test
    fun deleteAllMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overView1", "posterPath1", "date1", "title1"),
            Movie(2, "overView2", "posterPath2", "date2", "title2"),
            Movie(3, "overView3", "posterPath3", "date3", "title3"),
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        assertThat(dao.getMovies()).isEmpty()
    }

    @After
    fun tearDown() {
        database.close()
    }
}