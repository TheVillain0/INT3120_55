package com.example.lunchtray.model

import android.icu.text.NumberFormat
import androidx.compose.ui.text.intl.Locale

data class Menu(open val name: String,
                open val price: Double,
                open val description: String
) {

    data class EntreeItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : Menu(name, description, price)


    data class SideDishItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : Menu(name, description, price)


    data class AccompanimentItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : Menu(name, description, price)

    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance(Locale("vi", "VN")).format(price)
}
