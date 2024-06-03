package com.example.appbroken_rice.classes

data class Product(
    val id: Int,
    val name: String,
    val image: String,
    val price: Float,
    val vote: Float
)

// Dữ liệu mẫu
val lstData = listOf(
    Category(
        nameCategory = "Chó",
        products = listOf(
            Product(
                id = 1,
                name = "Product 1",
                image = "https://i.pinimg.com/564x/7b/91/4a/7b914aef9ea19cfd1a0c1f48e718b4d1.jpg",
                price = 10f,
                vote = 4.5f
            ),
            Product(
                id = 2,
                name = "Product 2",
                image = "https://i.pinimg.com/564x/37/d0/8d/37d08d70fa5f162bbb3c23e129b68ec7.jpg",
                price = 15f,
                vote = 4.0f
            )
        )
    ),
    Category(
        nameCategory = "Mèo",
        products = listOf(
            Product(
                id = 3,
                name = "Product 3",
                image = "https://i.pinimg.com/564x/7b/91/4a/7b914aef9ea19cfd1a0c1f48e718b4d1.jpg",
                price = 20f,
                vote = 4.2f
            ),
            Product(
                id = 4,
                name = "Product 4",
                image = "https://i.pinimg.com/564x/37/d0/8d/37d08d70fa5f162bbb3c23e129b68ec7.jpg",
                price = 25f,
                vote = 4.8f
            )
        )
    ),
    Category(
        nameCategory = "Heo",
        products = listOf(
            Product(
                id = 3,
                name = "Product 3",
                image = "https://i.pinimg.com/564x/7b/91/4a/7b914aef9ea19cfd1a0c1f48e718b4d1.jpg",
                price = 20f,
                vote = 4.2f
            ),
            Product(
                id = 4,
                name = "Product 4",
                image = "https://i.pinimg.com/564x/37/d0/8d/37d08d70fa5f162bbb3c23e129b68ec7.jpg",
                price = 25f,
                vote = 4.8f
            )
        )
    ),
    Category(
        nameCategory = "Gà",
        products = listOf(
            Product(
                id = 3,
                name = "Product 3",
                image = "https://i.pinimg.com/564x/7b/91/4a/7b914aef9ea19cfd1a0c1f48e718b4d1.jpg",
                price = 20f,
                vote = 4.2f
            ),
            Product(
                id = 4,
                name = "Product 4",
                image = "https://i.pinimg.com/564x/37/d0/8d/37d08d70fa5f162bbb3c23e129b68ec7.jpg",
                price = 25f,
                vote = 4.8f
            )
        )
    ),
    Category(
        nameCategory = "Vịt",
        products = listOf(
            Product(
                id = 3,
                name = "Product 3",
                image = "https://i.pinimg.com/564x/7b/91/4a/7b914aef9ea19cfd1a0c1f48e718b4d1.jpg",
                price = 20f,
                vote = 4.2f
            ),
            Product(
                id = 4,
                name = "Product 4",
                image = "https://i.pinimg.com/564x/37/d0/8d/37d08d70fa5f162bbb3c23e129b68ec7.jpg",
                price = 25f,
                vote = 4.8f
            )
        )
    )
)

// Dữ liệu cart
val lstcart = listOf(
    Product(
        1,
        "Lotte",
        "https://i.pinimg.com/564x/2a/f4/4b/2af44b48ec2df06ad86fbb8f05146b35.jpg",
        100f,
        4.5f
    ),
    Product(
        2,
        "MC Donal",
        "https://i.pinimg.com/564x/2f/dc/c1/2fdcc11adced1ea822c46115a24b2b58.jpg",
        100f,
        4.5f
    ),
    Product(
        3,
        "KFC",
        "https://i.pinimg.com/564x/c1/50/fc/c150fc8f78a7097a40a7990f60559921.jpg",
        100f,
        4.5f
    ),
    Product(
        4,
        "Food",
        "https://i.pinimg.com/564x/40/14/3d/40143dd8429bcaa26cf1a9c89650c758.jpg",
        100f,
        4.5f
    ),
    Product(
        5,
        "Coffee",
        "https://i.pinimg.com/236x/53/ac/e8/53ace8cebe913d1b0af48d330c471dd5.jpg",
        100f,
        4.5f
    )
)
