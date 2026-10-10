package pe.edu.cibertec.approomsqlite.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.cibertec.approomsqlite.db.entity.PersonaEntity

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertar(persona: PersonaEntity)

    @Update
    fun actualizar(persona: PersonaEntity)

    @Query("DELETE FROM persona")
    fun eliminarTodo()

    @Query("SELECT * FROM persona LIMIT 1")
    fun obtenerPersona(): LiveData<PersonaEntity>
}