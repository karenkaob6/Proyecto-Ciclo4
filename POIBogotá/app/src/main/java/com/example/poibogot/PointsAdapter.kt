package com.example.poibogot
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pointsinterest.view.*

class PointsAdapter (val pointsInterest: List<PointsInterest>):RecyclerView.Adapter<PointsAdapter.PointsHolder>(){

    class PointsHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(pointsInterest: PointsInterest){
            view.tvNamePoint.text=pointsInterest.namePointsInterest
            view.tvAdressPoint.text=pointsInterest.addressPointsInterest
            view.tvGeneralInfo.text=pointsInterest.generalInfoPointsInterest
            view.tvTemperature.text=pointsInterest.temperaturePointsInterest
            Picasso.get().load(pointsInterest.imagePointsInterest).into(view.ivImagePoint)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return PointsHolder(layoutInflater.inflate(R.layout.item_pointsinterest, parent, false))
    }

    override fun onBindViewHolder(holder: PointsHolder, position: Int) {
        holder.render(pointsInterest[position])
    }

    override fun getItemCount(): Int {
        return pointsInterest.size
    }

}