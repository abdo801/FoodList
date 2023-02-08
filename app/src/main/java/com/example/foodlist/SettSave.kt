package com.example.foodlist

import android.content.Context

enum class TextSize(val size:Int){
    Small(20),
    Medium(50),
    Large(70),
}
class SettSave(context: Context) {
    companion object{
        const val  FILE_NAME="file_name"
        const val FONT_SIZE="font_size"
    }
    private val  prefP=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
    fun setFontSize(textSize: com.example.foodlist.TextSize){
        prefP.edit()
            .putInt(FONT_SIZE,textSize.size)
            .apply()
    }
    fun getFontSize():Int= prefP.getInt(FONT_SIZE,20)
}