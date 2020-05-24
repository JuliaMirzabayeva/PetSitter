package com.jjp.petsitter.model

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count_per_page") val countPerPage: Long,
    @SerializedName("total_count") val totalCount: Long,
    @SerializedName("current_page") val currentPage: Long,
    @SerializedName("total_pages") val totalPages: Long
)
