package com.prernajajodia.quizapp.activities.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.prernajajodia.quizapp.R
import com.prernajajodia.quizapp.activities.models.Quiz
import com.prernajajodia.quizapp.activities.utils.ColorPicker
import com.prernajajodia.quizapp.activities.utils.IconPicker


class QuizAdapter(private val quizzes: List<Quiz>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textViewTitle.text = quizzes[position].title
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.iconView.setImageResource(IconPicker.getIcon())
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }


    inner class QuizViewHolder(itemView: View) : ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.quiz_title)
        var iconView: ImageView = itemView.findViewById(R.id.quiz_icon)
        var cardContainer: CardView = itemView.findViewById(R.id.card_container)
    }
}