package com.prernajajodia.quizapp.activities.utils

import com.prernajajodia.quizapp.R

object IconPicker {
    var icons = arrayOf(R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3,R.drawable.icon_4)
    var currentIcon = 0

    fun getIcon(): Int {
        currentIcon = (currentIcon+ 1) % icons.size
        return icons[currentIcon]
    }


}