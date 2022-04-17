package com.example.mobilproje
import com.example.mobilproje.R.drawable.*
class Card {
    var name: String? = null
    var image: Int? = null
    var isvisible: Boolean=false
    var isMatch:Boolean=false
    var isOpen:Boolean=false
    var backimage= backcr

    constructor(name: String, image: Int) {
        this.name = name
        this.image = image
    }

    override fun toString(): String {
        return "$image"
    }
}