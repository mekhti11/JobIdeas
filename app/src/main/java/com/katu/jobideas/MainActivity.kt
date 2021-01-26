package com.katu.jobideas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.katu.jobideas.Adapters.CategoryAdapter
import com.katu.jobideas.Listeners.CategoryAdapterListener
import com.katu.jobideas.Models.CategoryModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val db = Firebase.firestore
    private lateinit var categoryAdapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    private fun getData() {
        val list:ArrayList<CategoryModel> = arrayListOf()
        db.collection("Categories")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val index = doc.data["index"] as Long
                    list.add(index.toInt(),
                        CategoryModel(index.toInt(),
                                        doc.data["title"] as String))
                }
                setAdapter(list)
            }
            .addOnFailureListener{exception ->
                Log.d("Exception","Error getting documents.",exception)
            }
    }

    private fun setAdapter(list: ArrayList<CategoryModel>) {
        categoryAdapter = CategoryAdapter(this,list, CategoryAdapterListener() )
        val layoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation( LinearLayoutManager.HORIZONTAL)
        rv_categories.adapter = categoryAdapter
        rv_categories.layoutManager = layoutManager
    }
}
