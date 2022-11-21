package com.example.mymoveapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoveapplication.R
import kotlinx.android.synthetic.main.move_details_item.view.*

class MoveDetailsAdapter : RecyclerView.Adapter<MoveDetailsAdapter.MoveDetailsHolder>() {


    private val movieCommentList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveDetailsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_details_item, parent, false)
        return MoveDetailsHolder(view)
    }

    override fun onBindViewHolder(holder: MoveDetailsHolder, position: Int) {
        holder.bind(movieCommentList[position])

    }

    override fun getItemCount() = movieCommentList.size

    fun update(list: Collection<String>) {
        movieCommentList.clear()
        movieCommentList.addAll(list)
        notifyDataSetChanged()
    }

    inner class MoveDetailsHolder(item: View): RecyclerView.ViewHolder(item) {

        fun bind(string: String){
            itemView.moveItemDetails.text = string

        }
    }


}
