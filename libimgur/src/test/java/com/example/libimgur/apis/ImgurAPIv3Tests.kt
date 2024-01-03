package com.example.libimgur.apis

import com.example.libimgur.ImgurClient
import com.example.libimgur.params.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ImgurAPIv3Tests {
    val api = ImgurClient.api

    @Test
    fun `get tags working` () = runBlocking {
        val response = api.getTags()
        assertNotNull(response.body())
    }

    @Test
    fun `get tag - aww working` () = runBlocking {
        val response = api.getTagGallery("aww")
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries -hot working` () = runBlocking {
        val response = api.getGallery(Section.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries -top working` () = runBlocking {
        val response = api.getGallery(Section.TOP)
        assertNotNull(response.body())
    }
}


//Section.HOT and Section.TOP does not give response until it converts to string
//becouse moshi and retrofit doesnt know how to convert an enum into string(enumConverterFactory)

// so after creating enum we cannot use api.getGallery(abc or any other input)


// after adding coroutines we remove .execute() and insert RunBlocking{}
// runblocking runs new coroutines and blocks current thread interruptibly until its completion
// so for test its better to use runblocking always but in app its not

