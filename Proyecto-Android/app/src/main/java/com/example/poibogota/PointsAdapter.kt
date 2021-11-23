package com.example.poibogota

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import kotlinx.android.synthetic.main.item_pointsinterest.view.*
import com.squareup.picasso.Picasso


class PointsAdapter( val pointsinterest:List<PointsInterest>):RecyclerView.Adapter<PointsAdapter.PointsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return PointsHolder(layoutInflater.inflate(R.layout.item_pointsinterest,parent,false))
    }

    override fun onBindViewHolder(holder: PointsHolder, position: Int) {
        holder.render(pointsinterest[position])
    }

    override fun getItemCount(): Int {
        return pointsinterest.size
    }
    class PointsHolder( val view:View):RecyclerView.ViewHolder(view){
        fun render(pointsinterest: PointsInterest){
            view.tvName.text=pointsinterest.pointsInterestName
            view.tvRate.text=pointsinterest.pointsInterestRate
            view.tvDescription.text=pointsinterest.pointsInterestDescription
            Picasso.get().load(pointsinterest.pointsInterestImage).into(view.ivImage);

        }

    }
}