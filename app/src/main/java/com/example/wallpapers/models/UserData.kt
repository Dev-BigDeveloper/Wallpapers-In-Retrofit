package com.example.recyclerviewpagination.models

import com.example.wallpapers.models.Data

data class UserData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)