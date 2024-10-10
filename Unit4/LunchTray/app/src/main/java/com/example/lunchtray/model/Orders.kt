package com.example.lunchtray.model

data class Orders(
    val entree: Menu.EntreeItem? = null,
    val sideDish: Menu.SideDishItem? = null,
    val accompaniment: Menu.AccompanimentItem? = null,
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.05 * itemTotalPrice,
    val orderTotalPrice: Double = itemTotalPrice + orderTax
)
