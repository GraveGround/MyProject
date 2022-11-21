package com.example.mymoveapplication.data.shared

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SharedPreference constructor(
    context: Context
) {
    private val shared = context.getSharedPreferences(SAVE_SHARED, Context.MODE_PRIVATE)
//    private var sharedList = ArrayList<String>()
    private val sharedEditor = shared.edit()


    fun putComment(comment:String) {
        val sharedList = getCommentList()
        sharedList.add(comment)
        val gson = Gson()
        val json = gson.toJson(sharedList)
        sharedEditor.putString(STRING_SHARED, json)
        sharedEditor.apply()
    }

    fun getCommentList(): ArrayList<String> {
        var getList: ArrayList<String>
        val gson = Gson()
        val json = shared.getString(LIST_SHARED, null)
        val type: Type = object : TypeToken<ArrayList<String>>() {}.type
        getList = gson.fromJson(json,type)
        if (getList == null) {
            getList = ArrayList()
        }
        return getList
    }

    companion object {
        const val STRING_SHARED = "STRING_SHARED"
        const val LIST_SHARED = "LIST_SHARED"
        const val SAVE_SHARED = "SAVE_SHARED"
    }

}

