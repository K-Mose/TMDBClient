package com.kmose.tmdbclient.data.repository.tvshow

import android.util.Log
import com.kmose.tmdbclient.domain.repository.TvShowRepository
import com.kmose.tmdbclient.model.tvshow.TvShow
import com.kmose.tmdbclient.model.tvshow.TvShowList
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearALl()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowsFromAPI()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.printStackTrace().toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.printStackTrace().toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.printStackTrace().toString())
        }
        if(tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}