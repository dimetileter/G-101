package com.aliosman.g101.adapter.recyclerAdapter

data class CombineCardRecyclerData(
    val imgResRow1Colm1: Int,
    val imgResRow1Colm2: Int,
    val imgResRow2Colm1: Int,
    val imgResRow2Colm2: Int,
    val title: String,  //TODO: String olarak çevirilecek
    val desc: String,
    val dotList: List<Int>?,
) {
    // val dot1: Int?,
    // val dot2: Int?,
    // val dot3: Int?,
    // val dot4: Int?,
    // val dot5: Int?,
    // val dot6: Int?
}