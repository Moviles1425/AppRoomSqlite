package pe.edu.cibertec.approomsqlite.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import pe.edu.cibertec.approomsqlite.R
import pe.edu.cibertec.approomsqlite.databinding.ActivityHomeBinding
import pe.edu.cibertec.approomsqlite.db.PersonaRoomDatabase

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
        val db = PersonaRoomDatabase.getDatabase(applicationContext)
        db.personaDao().obtenerPersona().observe(this, Observer{
            personaEntity ->
            if(personaEntity != null){
                binding.tvnombres.text = "${personaEntity.nombres} ${personaEntity.apellidos}"
                binding.tvemail.text = personaEntity.email
            }
        })

    }
    override fun onClick(p0: View?) {
        cerrarSesion()
    }

    private fun cerrarSesion(){
        Thread{
            val db = PersonaRoomDatabase.getDatabase(applicationContext)
            db.personaDao().eliminarTodo()
            runOnUiThread {
                startActivity(Intent(applicationContext,
                    MainActivity::class.java))
                finish()
            }
        }.start()
    }
}