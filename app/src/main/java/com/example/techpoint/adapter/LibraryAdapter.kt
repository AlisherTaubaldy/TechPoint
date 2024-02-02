package com.example.techpoint.adapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.techpoint.databinding.CourseItemBinding
import com.example.techpoint.listeners.BookOnClickListener
import com.example.techpoint.model.BookDataSet


class LibraryAdapter(
    private val context: Context,
    private val cours: List<BookDataSet>,
    val bookOnClickListener: BookOnClickListener) : RecyclerView.Adapter<LibraryAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CourseItemBinding.inflate(inflater, parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = cours[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return cours.size
    }

    inner class CourseViewHolder(private val binding: CourseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bookDataSet: BookDataSet) {
            binding.title.text = bookDataSet.title
            binding.subtitle.text = bookDataSet.subtitle

            Glide.with(context)
                .load(bookDataSet.imageResource)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.radiobutton_off_background) // Placeholder image
                        .error(R.drawable.stat_notify_error) // Error image in case of loading failure
                )
                .into(binding.image)

            binding.image.setOnClickListener {
                bookOnClickListener.bookOnClick(it,cours[position])
            }
        }
    }
}