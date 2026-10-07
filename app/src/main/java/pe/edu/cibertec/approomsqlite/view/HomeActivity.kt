package pe.edu.cibertec.approomsqlite.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.approomsqlite.R
import pe.edu.cibertec.approomsqlite.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncerrarsesion.setOnClickListener(this)
        obtenerUsuarioLogueado()
    }

    private fun obtenerUsuarioLogueado(){

    }
    override fun onClick(p0: View?) {
        cerrarSesion()
    }

    private fun cerrarSesion(){

    }
}