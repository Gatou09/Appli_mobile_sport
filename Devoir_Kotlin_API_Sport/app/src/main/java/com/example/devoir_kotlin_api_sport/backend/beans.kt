package com.example.devoir_kotlin_api_sport.backend

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import java.util.Date

/*
Json match
*/
class MatchData(var list : List<MatchDataItem>)

data class MatchDataItem(
    var id: Int,
    var team1: String,
    var team2: String,
    var score1: Int,
    var score2: Int,
    var termine: Boolean,
    var date: String,
    var image: String
)

/*
Raccourci et autre variable
*/

var Choixstatus = ""
var status = true

data class MyListItem(
    var team1: String,
    var team2: String,
    var score1: Int,
    var score2: Int,
    var termine: Boolean,
    var date: String
)

@SuppressLint("SimpleDateFormat")
var myList = arrayOf(
    MyListItem(
        "Toulouse",
        "Foix",
        1,
        1,
        true,
        "2024/18/01"
    ),

    MyListItem(
        "Pamier",
        "Verniole",
        0,
        2,
        true,
        "2024/18/01"
    ),

    MyListItem(
        "Foix",
        "Lille",
        5,
        2,
        false,
        "2024/18/01"
    ),

    MyListItem(
        "Toulouse",
        "Foix",
        1,
        1,
        true,
        "2024/18/01"
    ),

    MyListItem(
        "Pamier",
        "Verniole",
        0,
        2,
        true,
        "2024/18/01"
    ),

    MyListItem(
        "Toulouse",
        "Foix",
        1,
        1,
        true,
        "2024/18/01"
    ),

    MyListItem(
        "Pamier",
        "Verniole",
        0,
        2,
        true,
        "2024/18/01"
    )
)