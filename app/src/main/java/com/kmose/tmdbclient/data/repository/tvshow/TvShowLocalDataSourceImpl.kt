package com.kmose.tmdbclient.data.repository.tvshow

import com.kmose.tmdbclient.data.db.TvShowDao
import com.kmose.tmdbclient.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowDao: TvShowDao
): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}