package com.example.sdkgiphyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.bind
import androidx.recyclerview.widget.RecyclerView
import com.example.sdkgiphyapp.databinding.ActivityMainBinding.bind
import com.example.sdkgiphyapp.databinding.CharacterBinding
import com.example.sdkgiphyapp.model.CharacterResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character.view.*

class CharacterAdapter(val character: List<Character>):RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //aqui retornamos el inflado de la vista "item_superhero.xml"
        return CharacterHolder(layoutInflater.inflate(R.layout.character, parent, false))
    }


    //este metodo le dice al objeto holder de su parametro que le cargue la info en cada superheroe
    //con el metodo render
    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.render(character[position])
    }

    override fun getItemCount(): Int = character.size


    class CharacterHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun render(character: Character) {
            val finalPath = "${character.thumbnail.path}/portrait_small.${character.thumbnail.extension}"
            val binding = CharacterBinding.bind(view)
            view.tvCharacterName.text = character.name
            Picasso.get().load("${character.thumbnail.path}/standard_small.${character.thumbnail.extension}").into(binding.ivCharacter)

            //para mostrar algo cuando haces click en cada superheroe
            view.setOnClickListener {
                Toast.makeText(view.context, "Has seleccionado a  $finalPath", Toast.LENGTH_SHORT).show()
            }
        }
    }
}