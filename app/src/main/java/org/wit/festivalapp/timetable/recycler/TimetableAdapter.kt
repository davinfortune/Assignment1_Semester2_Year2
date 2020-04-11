package org.wit.festivalapp.timetable.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.timetable_card.view.*
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.store.ArtistModel
import org.wit.festivalapp.timetable.interfaces.TimeListener

class TimetableAdapter constructor(private var artists: List<ArtistModel>,
                                private val listener: TimeListener
) : RecyclerView.Adapter<TimetableAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.timetable_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val artist = artists[holder.adapterPosition]
        holder.bind(artist, listener)
    }

    override fun getItemCount(): Int = artists.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(artist: ArtistModel, listener : TimeListener) {

            itemView.artistName.text = (artist.artistName + ".")
            itemView.timeTable.text = (artist.artistTime + ".")
            itemView.day.text = (artist.artistDay + ".")


            itemView.setOnClickListener { listener.onTimeClick(artist) }
        }
    }
}