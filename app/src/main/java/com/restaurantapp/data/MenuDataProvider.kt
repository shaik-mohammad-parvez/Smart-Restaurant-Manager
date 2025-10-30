package com.restaurantapp.data.repository

import com.restaurantapp.data.entity.MenuItem

object MenuDataProvider {

    val menuItems = listOf(

        // ⭐ Starters
        MenuItem(
            name = "Chicken Tikka",
            description = "Tender chicken grilled in tandoor with Indian spices",
            price = 249.0,
            imageUrl = "https://images.pexels.com/photos/4106480/pexels-photo-4106480.jpeg",
            category = "Starters",
            stock = 15,
            isAvailable = true
        ),
        MenuItem(
            name = "Paneer 65",
            description = "Crispy fried paneer tossed in spicy masala",
            price = 199.0,
            imageUrl = "https://images.pexels.com/photos/5639331/pexels-photo-5639331.jpeg",
            category = "Starters",
            stock = 12,
            isAvailable = true
        ),

        // 🍛 Main Course
        MenuItem(
            name = "Butter Chicken",
            description = "Creamy tomato curry with soft chicken pieces",
            price = 349.0,
            imageUrl = "https://images.pexels.com/photos/11170284/pexels-photo-11170284.jpeg",
            category = "Main Course",
            stock = 20,
            isAvailable = true
        ),
        MenuItem(
            name = "Veg Biryani",
            description = "Aromatic rice cooked with fresh vegetables and spices",
            price = 299.0,
            imageUrl = "https://images.pexels.com/photos/6529591/pexels-photo-6529591.jpeg",
            category = "Main Course",
            stock = 18,
            isAvailable = true
        ),

        // 🥪 Snacks
        MenuItem(
            name = "Grilled Sandwich",
            description = "Crunchy grilled sandwich with cheese & veggies",
            price = 149.0,
            imageUrl = "https://images.pexels.com/photos/1600711/pexels-photo-1600711.jpeg",
            category = "Snacks",
            stock = 25,
            isAvailable = true
        ),
        MenuItem(
            name = "French Fries",
            description = "Golden fried potato fries with seasoning",
            price = 99.0,
            imageUrl = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            category = "Snacks",
            stock = 30,
            isAvailable = true
        ),

        // 🍹 Drinks
        MenuItem(
            name = "Cold Coffee",
            description = "Chilled coffee blended with rich cream",
            price = 129.0,
            imageUrl = "https://images.pexels.com/photos/6546425/pexels-photo-6546425.jpeg",
            category = "Drinks",
            stock = 35,
            isAvailable = true
        ),
        MenuItem(
            name = "Fresh Lime Soda",
            description = "Refreshing soda with lemon and mint",
            price = 79.0,
            imageUrl = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
            category = "Drinks",
            stock = 40,
            isAvailable = true
        ),

        // 🍰 Desserts
        MenuItem(
            name = "Gulab Jamun",
            description = "Soft sweet milk dumplings in sugar syrup",
            price = 129.0,
            imageUrl = "https://images.pexels.com/photos/5410402/pexels-photo-5410402.jpeg",
            category = "Desserts",
            stock = 22,
            isAvailable = true
        ),
        MenuItem(
            name = "Brownie with Ice Cream",
            description = "Chocolate brownie served with vanilla ice cream",
            price = 189.0,
            imageUrl = "https://images.pexels.com/photos/4109996/pexels-photo-4109996.jpeg",
            category = "Desserts",
            stock = 15,
            isAvailable = true
        )
    )
}
