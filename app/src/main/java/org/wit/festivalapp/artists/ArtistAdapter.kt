package org.wit.festivalapp.artists

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artist_card.view.*
import org.wit.festivalapp.R
import org.wit.festivalapp.helpers.readImage
import org.wit.festivalapp.helpers.readImageFromPath

class ArtistAdapter constructor(private var artists: List<ArtistModel>,
                                   private val listener: ArtistListener) : RecyclerView.Adapter<ArtistAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.artist_card, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val artist = artists[holder.adapterPosition]
        holder.bind(artist, listener)
    }

    override fun getItemCount(): Int = artists.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(artist: ArtistModel,  listener : ArtistListener) {
            itemView.artistName.text = (artist.artistName + ".")
            itemView.artistGenre.text = (artist.artistGenre + ".")

                Picasso.with(itemView.context).load(artist.artistImage).into(itemView.imageView)

            itemView.setOnClickListener { listener.onArtistClick(artist) }
        }
    }
}