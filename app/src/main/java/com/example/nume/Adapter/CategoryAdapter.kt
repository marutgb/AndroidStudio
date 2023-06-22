package com.example.nume.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.nume.Domain.CategoryDomain
import com.example.nume.R

class CategoryAdapter(private val categoryDomains: ArrayList<CategoryDomain>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = categoryDomains[position].title
        var picUrl = ""
        when (position) {
            0 -> {
                picUrl = "cat_1"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background1
                    )
            }
            1 -> {
                picUrl = "cat_2"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background2
                    )
            }
            2 -> {
                picUrl = "cat_3"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background3
                    )
            }
            3 -> {
                picUrl = "cat_4"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background4
                    )
            }
            4 -> {
                picUrl = "cat_5"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background5
                    )
            }
            5 -> {
                picUrl = "cat_6"
                holder.mainLayout.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.cat_background6
                    )
            }
        }
        val drawableResourceId =
            holder.itemView.context.resources.getIdentifier(
                picUrl,
                "drawable",
                holder.itemView.context.packageName
            )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.categoryPic)
    }

    override fun getItemCount(): Int {
        return categoryDomains.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        val categoryPic: ImageView = itemView.findViewById(R.id.categoryPic)
        val mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainLayout)
    }
}
