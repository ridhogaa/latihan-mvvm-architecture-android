package com.ergea.learnmvvmapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ergea.learnmvvmapp.databinding.ItemBinding
import com.ergea.learnmvvmapp.databinding.ItemBinding.inflate
import com.ergea.learnmvvmapp.model.Word
import com.ergea.learnmvvmapp.ui.home.MainViewModel

class HomeAdapter(
    val viewModel: MainViewModel,
    val arrayList: ArrayList<Word>,
) : RecyclerView.Adapter<HomeAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeAdapter.NotesViewHolder =
        NotesViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HomeAdapter.NotesViewHolder, position: Int) =
        holder.bind(arrayList[position])

    override fun getItemCount(): Int = arrayList.size

    inner class NotesViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(blog: Word) {
            binding.title.text = blog.title
            binding.delete.setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }

}