package org.example.filmlerapp.data.entity

import kotlinx.serialization.Serializable

@Serializable                                      //veri trasferi için kullanılır.
data class Filmler(var id:Int,
                   var ad:String,
                   var resim:String,
                   var fiyat:Int) {

}