package pe.edu.cibertec.approomsqlite.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.approomsqlite.R
import pe.edu.cibertec.approomsqlite.databinding.ActivityMainBinding
import pe.edu.cibertec.approomsqlite.retrofit.ClienteRetrofit
import pe.edu.cibertec.approomsqlite.retrofit.request.LoginRequest
import pe.edu.cibertec.approomsqlite.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        login()
    }

    private fun login(){
        val request : Call<LoginResponse> = ClienteRetrofit
            .retrofitPatitasService.autenticacion(
                LoginRequest(
                    binding.etusuario.text.toString(),
                    binding.etpassword.text.toString()
                )
            )
        request.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                p0: Call<LoginResponse?>,
                p1: Response<LoginResponse?>
            ) {
                val loginResponse = p1.body()!!
                if(loginResponse.rpta){
                    Toast.makeText(applicationContext,
                        "Login Exitoso",
                        Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,
                        loginResponse.mensaje,
                        Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(
                p0: Call<LoginResponse?>,
                p1: Throwable
            ) {

            }
        })
    }
}