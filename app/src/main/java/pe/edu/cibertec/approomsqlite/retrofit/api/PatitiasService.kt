package pe.edu.cibertec.approomsqlite.retrofit.api

import pe.edu.cibertec.approomsqlite.retrofit.request.LoginRequest
import pe.edu.cibertec.approomsqlite.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PatitiasService {

    @POST("login.php")
    fun autenticacion(@Body loginRequest: LoginRequest) : Call<LoginResponse>
}