package com.example.poibogota

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import com.example.poibogota.databinding.ItemPointsinterestBinding
import kotlinx.android.synthetic.main.item_pointsinterest.view.*
import com.squareup.picasso.Picasso


class PointsAdapter( val pointsinterest:List<PointsInterest>):RecyclerView.Adapter<PointsAdapter.PointsHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return PointsHolder(layoutInflater.inflate(R.layout.item_pointsinterest,parent,false))
    }

    override fun onBindViewHolder(holder: PointsHolder, position: Int) {
        holder.render(pointsinterest[position])
        holder.context
        holder.setOnClickListeners()

    }

    override fun getItemCount(): Int {
        return pointsinterest.size
    }
    class PointsHolder(val view:View):RecyclerView.ViewHolder(view), View.OnClickListener {
        lateinit var secondActivitybtn:Button
        lateinit var context: Context
        lateinit var poi: PointsInterest


        val binding=ItemPointsinterestBinding.bind(view)
        fun render(pointsinterest: PointsInterest){
            context=view.context
            binding.tvName.text=pointsinterest.pointsInterestName
            binding.tvRate.text=pointsinterest.pointsInterestRate
            binding.tvDescription.text=pointsinterest.pointsInterestDescription
            secondActivitybtn=binding.secondActivitybtn
            Picasso.get().load(pointsinterest.pointsInterestImage).into(view.ivImage);
            poi=pointsinterest
        }
        fun setOnClickListeners(){
            secondActivitybtn.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val intent= Intent(context, Detalle::class.java)
            intent.putExtra("name", poi.pointsInterestName)
            intent.putExtra("description",poi.pointsInterestDescription)
            intent.putExtra("imagen", poi.pointsInterestImage)
          context.startActivity(intent)

        }


    }

}
