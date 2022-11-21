package com.example.mymoveapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.ui.main.adapter.MoveDetailsAdapter
import kotlinx.android.synthetic.main.fragment_second_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment(R.layout.fragment_second_layout) {


    private val viewModel: MovieDetailsViewModel by viewModel<MovieDetailsViewModel>()
    private val viewModelComments: MovieDetailsViewModel by viewModel<MovieDetailsViewModel>()


    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"
    private val moveDetailsAdapter = MoveDetailsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputData = arguments?.getString(KEY_TO_SECOND_ACTIVITY)



        viewModelComments.commentLiveData.observe(viewLifecycleOwner, Observer {
            moveDetailsAdapter.update(it)
        })

        viewModelComments.commentLiveData.observe(viewLifecycleOwner, Observer {
            viewModelComments.getMovieCommentList()
        })

//        setResultListener()


        rvComments.layoutManager = LinearLayoutManager(requireContext())
        rvComments.adapter = moveDetailsAdapter

        rvComments.apply {
            setHasFixedSize(true)
        }

        noteButton.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(parentFragmentManager, "dialog_tag")
        }

        viewModel.moveSecondLiveData(inputData!!)
        viewModel.secondML.observe(viewLifecycleOwner, Observer {
            bind(it)
        })
    }

    fun setResultListener() {
        setFragmentResultListener(KEY_REQUEST) { requestKey, bundle ->
            val result = bundle.getString(KEY_BUNDLE, "Default Value")
//            viewModelComments.addComment(result)
//            viewModelComments.setMovieComments(result)

        }

    }


    fun bind(movie: MovieDetails) {
        tvMDtitle.text = movie.originalTitle
        tvMDVote.text = movie.voteAverage.toString()
        tvMDOverview.text = movie.overview

        Glide.with(requireContext())
            .load(imgBaseUrl + movie.posterPath)
            .into(imgMDetails)
    }

    companion object {
        fun newInstance() = MovieListFragment()
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
        const val KEY_TO_DIALOG_FRAGMENT = "KEY_TO_DIALOG_FRAGMENT"
        const val KEY_BUNDLE = "KEY_BUNDLE"
        const val KEY_REQUEST = "KEY_REQUEST"
    }

}


//    private fun toDialogFragment(moveData: MovieData) {
//
//        val bundle = Bundle()
//        bundle.putString(MovieListFragment.KEY_TO_SECOND_ACTIVITY, moveData.id)
//        activity?.supportFragmentManager?.beginTransaction()
//            ?.replace(R.id.fragmentPlace, MovieDetailsFragment().apply {
//                arguments = bundle
//            })?.commit()
//    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        fun bind(movie: MovieDetails) {
//            constrinL.tvMDtitle.text = movie.originalTitle
//            constrinL.tvMDVote.text = movie.voteAverage.toString()
//            constrinL.tvMDOverview.text = movie.overview
//
//            Glide.with(constrinL.context)
//                .load(imgBaseUrl + movie.posterPath)
//                .into(constrinL.imgMDetails)
//        }
//
//
//        val movieID = "" // intent.getStringExtra(KEY_TO_SECOND_ACTIVITY)
//
//        viewModel.secondML.observe(this, Observer {
//            bind(it)
//        })
//
//
////        if (movieID != null) {
//        viewModel.moveSecondLiveData(movieID!!)
//
//    }
