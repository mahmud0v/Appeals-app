package uz.gita.appealsapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Appeals")
data class AppealEntity(
    @PrimaryKey
    val id:Int,
    @ColumnInfo(name = "phone_number")
    val phoneNumber:String?,
    @ColumnInfo(name = "district")
    val districtName:String?,
    @ColumnInfo(name = "request_data")
    val requestDate:String?,
    @ColumnInfo(name = "description")
    val description:String?,
    @ColumnInfo(name = "isAllow")
    val isAllow:Int?
)