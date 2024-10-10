package com.example.lunchtray.data

object DataSrc {
    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Phở",
            description = "Phở bò tái chín, bánh phở tươi với nước dùng đậm đà",
            price = 45000.0, // 45,000 VNĐ
        ),
        EntreeItem(
            name = "Bánh Cuốn",
            description = "Bánh cuốn nhân thịt, ăn kèm chả lụa và hành phi",
            price = 30000.0, // 30,000 VNĐ
        ),
        EntreeItem(
            name = "Bún Chả",
            description = "Bún chả nướng, ăn kèm nước chấm và rau sống",
            price = 50000.0, // 50,000 VNĐ
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Nem rán",
            description = "Nem rán giòn, nhân thịt heo và miến",
            price = 20000.0, // 20,000 VNĐ
        ),
        SideDishItem(
            name = "Đậu phụ rán",
            description = "Đậu phụ rán giòn, ăn kèm tương ớt",
            price = 15000.0, // 15,000 VNĐ
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Dưa hấu",
            description = "Dưa hấu ngọt mát, thái lát",
            price = 10000.0, // 10,000 VNĐ
        ),
        AccompanimentItem(
            name = "Xoài",
            description = "Xoài chín ngọt, thái lát",
            price = 12000.0, // 12,000 VNĐ
        )
    )
}