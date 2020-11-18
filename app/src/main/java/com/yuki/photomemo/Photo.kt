package com.yuki.photomemo

import androidx.room.*

@Entity(tableName = "photo_table")
data class Photo(
    @PrimaryKey @ColumnInfo(name = "uri") val uri: String,
    @ColumnInfo(name = "memo") val memo: String
)




