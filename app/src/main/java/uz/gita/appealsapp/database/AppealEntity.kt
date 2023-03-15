package uz.gita.appealsapp.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
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
    var isAllow:Int?
): Parcelable