package kr.co.bullets.part2chapter4.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("items")
    val items: List<User>,
)
