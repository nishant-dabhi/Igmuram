package com.example.igmuram

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.VideoFrameDecoder

class IgmuramApp : Application(), ImageLoaderFactory {

    override fun newImageLoader() = ImageLoader.Builder(this@IgmuramApp)
        .components {
            add(VideoFrameDecoder.Factory())
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(this)
    }
}