package com.example.libimgur.apis

import com.example.libimgur.models.GalleryResponse
import com.example.libimgur.models.TagResponse
import com.example.libimgur.models.TagsReponse
import com.example.libimgur.params.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {


    @GET("gallery/{section}") //TODO: use path params
    suspend fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreview: Boolean? = true
    ) : Response<GalleryResponse>

    @GET("tags")
     suspend fun getTags() : Response<TagsReponse>

     @GET("gallery/t/{tag}")
     suspend fun getTagGallery(
         @Path("tag") tag: String
     ) : Response<TagResponse>
}


// we use Response instead of Call becouse of coroutines as we want to run test via runblocking