package com.example.androidmovie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.androidmovie.NetworkBoundResource
import com.example.androidmovie.data.source.local.LocalDataSource
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.data.source.remote.ApiResponse
import com.example.androidmovie.data.source.remote.response.MovieResponse
import com.example.androidmovie.data.source.remote.response.RemoteDataSource
import com.example.androidmovie.utils.AppExecutors
import com.example.androidmovie.vo.Resource


class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                MovieRepository(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        "",
                        response.description,
                        response.date,
                        false,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun getTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowsEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowsEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val tvShowList = ArrayList<TvShowsEntity>()
//                val listActor = ArrayList<String>()
                for (response in data) {
                    val tvShow = TvShowsEntity(
                        response.id,
                        response.title,
                        "",
                        response.description,
                        response.date,
                        false,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    override fun setFavoriteTvShow(movie: TvShowsEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTShow(movie, state) }

    override fun getActor(movieId: String, origin: String): LiveData<String> {
        val actors = MutableLiveData<String>()
        remoteDataSource.getActor(object : RemoteDataSource.LoadActorCallback {
            override fun onActorReceived(resultsItem: String) {
                actors.postValue(resultsItem)
            }
        }, movieId, origin)
        return actors
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<DetailMovieEntity>> {
        return object : NetworkBoundResource<DetailMovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailMovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: DetailMovieEntity?): Boolean =
                data?.mMovies == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getActorById(movieId)

            override fun saveCallResult(data: List<MovieResponse>) {
            }
        }.asLiveData()
    }

    override fun updateActorMovie(movie: MovieEntity, actor: String) =
        appExecutors.diskIO().execute { localDataSource.updateActorMovieDb(movie, actor) }

    override fun getDetailTvShow(tvShowId: String): LiveData<Resource<DetailTvShowsEntity>> {
        return object :
            NetworkBoundResource<DetailTvShowsEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailTvShowsEntity> =
                localDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: DetailTvShowsEntity?): Boolean =
                data?.tvShowsEntity == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getActorById(tvShowId)

            override fun saveCallResult(data: List<MovieResponse>) {
            }
        }.asLiveData()
    }

    override fun updateActorTvShow(tvShow: TvShowsEntity, actor: String) =
        appExecutors.diskIO().execute { localDataSource.updateActorTvShowDb(tvShow, actor) }
}

