package com.example.sdkgiphyapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sdkgiphyapp.databinding.CharacterBinding
import com.example.sdkgiphyapp.model.Thumbnail
import com.squareup.picasso.Picasso

class CharacterViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = CharacterBinding.bind(view)

    fun bind(image:Character) {
        val finalpath: String = image.thumbnail.path +"/portrait_small."+ image.thumbnail.extension

    }


}