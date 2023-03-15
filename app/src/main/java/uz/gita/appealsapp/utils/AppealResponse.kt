package uz.gita.appealsapp.utils

sealed class AppealResponse<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : AppealResponse<T>(data)
    class Error<T>(message: String) : AppealResponse<T>(message = message)



}
