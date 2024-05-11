package com.example.devoir_kotlin_api_sport.backend

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _myList = mutableStateListOf<MyListItem>()
    val myList: List<MyListItem> = _myList

    /*var searchText by mutableStateOf("")

    val filterList = myList.filter {it.name.contains(searchText)}*/

    //Requête en cours
    var runInProgress by mutableStateOf(false)
        private set


    fun loadMatchStatus() {
        _myList.clear()
        runInProgress = true

        if (Choixstatus == "")
            viewModelScope.launch(Dispatchers.Default) {
                val list: List<MatchDataItem> =  TournoiAPI.loadMatch()

                //on transforme List<MyListItem> en  List<PictureData>
                val res: List<MyListItem> = list.map {
                    MyListItem(it.team1, it.team2, it.score1, it.score2, it.termine, it.date)
                }

                _myList.addAll(res)
                runInProgress = false
            }

        if (Choixstatus == "true")
            viewModelScope.launch(Dispatchers.Default) {
                val list: List<MatchDataItem> =  TournoiAPI.loadMatch().filter {
                    it.termine
                }

                //on transforme List<MyListItem> en  List<PictureData>
                val res: List<MyListItem> = list.map {
                    MyListItem(it.team1, it.team2, it.score1, it.score2, it.termine, it.date)
                }

                _myList.addAll(res)
                runInProgress = false
            }

        if (Choixstatus == "false")

            viewModelScope.launch(Dispatchers.Default) {
                val list: List<MatchDataItem> =  TournoiAPI.loadMatch().filter {
                    !it.termine
                }

                //on transforme List<MyListItem> en  List<PictureData>
                val res: List<MyListItem> = list.map {
                    MyListItem(it.team1, it.team2, it.score1, it.score2, it.termine, it.date)
                }

                _myList.addAll(res)
                runInProgress = false
            }
    }

}