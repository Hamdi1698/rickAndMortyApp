package com.rickandmortyapp.model

data class Character (
    var id :Int,
    var name:String,
    var status:String,
    var species:String,
    var type:String,
    var gender:String,
    var origin: LocationData,
    var location: LocationData,
    var episode:List<String>,
    var image : String,
        )