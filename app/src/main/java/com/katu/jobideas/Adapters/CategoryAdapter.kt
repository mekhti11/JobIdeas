package com.katu.jobideas.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.katu.jobideas.Listeners.CategoryAdapterListener
import com.katu.jobideas.Models.CategoryModel
import com.katu.jobideas.R
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter (private val context: Context,
                               private val list:ArrayList<CategoryModel>,
                               private val listener: CategoryAdapterListener
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHodler>() {




    override fun onBindViewHolder(holder: CategoryViewHodler, position: Int) {
        holder.setUI(list[position])
        if (position != 0){
            holder.itemView.white_line.visibility = View.INVISIBLE
        }
        holder.itemView.ll.setOnClickListener { v ->
            print("Clicked ${list[position].index}")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHodler {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHodler(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }



    inner class CategoryViewHodler (v: View) : RecyclerView.ViewHolder(v){
        fun setUI(model:CategoryModel){
            itemView.title.text = model.title
        }
    }
}