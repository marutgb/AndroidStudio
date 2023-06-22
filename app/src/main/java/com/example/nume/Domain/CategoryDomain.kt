package com.example.nume.Domain

class CategoryDomain(var title: String, private var pic: String) {

    init {
        this.title = title
        this.pic = pic
    }



    // Getter pentru pic
    fun getPic(): String {
        return pic
    }

    // Setter pentru pic
    fun setPic(pic: String) {
        this.pic = pic
    }
}
