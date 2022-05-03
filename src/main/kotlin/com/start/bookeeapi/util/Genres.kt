package com.start.bookeeapi.util

enum class Genres(val genre: String) {
    FANTASY("Fantasy"),
    SCI_FI("Science Fiction"),
    DYSTOPIAN("Dystopian"),
    ACTION("Action"),
    ADVENTURE("Adventure"),
    MYSTERY("Mystery"),
    HORROR("Horror"),
    THRILLER("Thriller"),
    HISTORICAL_FICTION("Historical Fiction"),
    ROMANCE("Romance"),
    LGBTQPLUS("LGBTQ+"),
    MAGICAL_REALISM("Magical Realism"),
    GRAPHIC_NOVEL("Graphic Novel"),
    YOUNG_ADULT("Young Adult"),
    CHILDREN("Children"),
    AUTOBIOGRAPHY("Autobiography"),
    BIOGRAPHY("Biography"),
    ART_PHOTOGRAPHY("Art & Photography"),
    SELF_HELP("Self-help"),
    HISTORY("History"),
    TRUE_CRIME("True Crime"),
    HUMOR("Humor"),
    GUIDE("Guide / How-to "),
    RELIGION_SPIRIT("Religion & Spirituality"),
    SOCIAL_SCIENCE("Social Sciences"),
    SCIENCE("Science"),
    TECHNOLOGY("Technology")
}

fun List<Genres>.getGenreByString(genre: String) = this.first { enumGenre -> enumGenre.genre == genre }.name