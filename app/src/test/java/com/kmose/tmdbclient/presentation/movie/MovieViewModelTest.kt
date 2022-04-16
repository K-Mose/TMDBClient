package com.kmose.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kmose.tmdbclient.data.repository.movie.FakeMovieRepository
import com.kmose.tmdbclient.domain.usecase.GetMoviesUseCase
import com.kmose.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.kmose.tmdbclient.getOrAwaitValue
import com.kmose.tmdbclient.model.movie.Movie
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMovieUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMovieUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMovieUseCase, updateMovieUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(listOf(
            Movie(1, "overView1", "posterPath1", "date1", "title1"),
            Movie(2, "overView2", "posterPath2", "date2", "title2"),
            Movie(3, "overView3", "posterPath3", "date3", "title3"),
        ))

        val currentList  = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(listOf(
            Movie(4, "overView4", "posterPath4", "date4", "title4"),
            Movie(5, "overView5", "posterPath5", "date5", "title5"),
            Movie(6, "overView6", "posterPath6", "date6", "title6"),
        ))
        val updateList  = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updateList).isEqualTo(movies)
    }
}