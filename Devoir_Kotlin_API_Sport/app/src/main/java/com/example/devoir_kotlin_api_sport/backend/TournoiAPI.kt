package com.example.devoir_kotlin_api_sport.backend

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.text.SimpleDateFormat
import java.util.*

const val URL_API_TOURNOI = "http://192.168.1.43:8080/matchesJson"

object TournoiAPI {

    val client = OkHttpClient()
    // Configuration de Gson pour utiliser le format de date ISO 8601
    val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()

    fun loadMatch(): List<MatchDataItem> {
        val json = sendGet(URL_API_TOURNOI)
        val type = object : TypeToken<List<MatchDataItem>>() {}.type
        val data = gson.fromJson<List<MatchDataItem>>(json, type)
        return data
    }

    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use {
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}


//var ChoixEquipe ="Foix"
//val monsters = TournoiAPI.loadMatch()
//val type_monstre = monsters.filter { it.team1 == ChoixEquipe }
//
//fun main() {
//    println(type_monstre)
//    }