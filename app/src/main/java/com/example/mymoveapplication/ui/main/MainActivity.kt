package com.example.mymoveapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymoveapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentPlace, MovieListFragment()).commit()
    }
}


//
//    companion object {
//        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
//    }


//private val adapter = MoveAdapter {
//        toMainActivity2(it)
//    }
//
//        this::toMainActivity2)
//
//    private val viewModel: MainViewModel by viewModel<MainViewModel>()

//        this::a.isLateinit

//        viewModelFactory = ViewModelFactory()
//   //    val intent = Intent(this, EditInfoActivity::class.java)
////    val userDetails = UserDetails()
////    intent.putExtra(KEY_TO_EDIT_INFO, userDetails)
//        viewModel = ViewModelProvider(this, viewModelFactory!!).get(MainViewModel::class.java)


//    private var viewModelFactory: ViewModelFactory? = null

//    lateinit var a :String

//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter

//        viewModel.movesLD.observe(this, Observer {
//            adapter.update(it)
//        })
//        viewModel.moveList()
//
//        viewModel.errorExp.observe(this, Observer {
//            Toast.makeText(this, "Error Found, or Some Wrong", Toast.LENGTH_SHORT).show()
//        })

//fun toMainActivity(moveData: MoveData) {
//        val intent = Intent(this, MainActivity2::class.java).apply {
//            putExtra(KEY_TO_SECOND_ACTIVITY, moveData.id)
//        }
//        startActivity(intent)
//    }