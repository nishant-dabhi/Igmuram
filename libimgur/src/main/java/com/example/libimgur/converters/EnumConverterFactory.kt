package com.example.libimgur.converters

import com.squareup.moshi.Json
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

//this is converter that use to convert enums to string
//whenever moshi faces an enum in request is use this converterfactory
class EnumConverterFactory : Converter.Factory() {
    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<Enum<*>, String>? {
        return if (type is Class<*> && type.isEnum) { // it checks weather its class or not && weather its an enum or not
            Converter <Enum<*>, String> {enum ->
                try {
                    enum.javaClass.getField(enum.name).getAnnotation(Json::class.java).name
                  //class for Section-gets field(hot or top)-gets Json annotation for name(name parameter)
                } catch (e: Exception) {
                    null
                }
            }
        } else {
            null
        }
    }
}