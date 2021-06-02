package com.prernajajodia.quizapp.activities.utils

object ColorPicker {
    var colors = arrayOf("#FF7F50", "#CD5C5C", "#FA8072", "#FFA07A", "#FF6347")
    var currentColorIndex = 0

    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}