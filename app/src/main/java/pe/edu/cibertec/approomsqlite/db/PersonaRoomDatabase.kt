package pe.edu.cibertec.approomsqlite.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.cibertec.approomsqlite.db.dao.PersonaDao
import pe.edu.cibertec.approomsqlite.db.entity.PersonaEntity

@Database(entities = [PersonaEntity::class], version = 1)
abstract class PersonaRoomDatabase : RoomDatabase() {

    abstract fun personaDao(): PersonaDao

    companion object {
        @Volatile
        private var INSTANCE  : PersonaRoomDatabase? = null

        fun getDatabase(context: Context): PersonaRoomDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    PersonaRoomDatabase::class.java,
                    "personadb").build()
                INSTANCE = instance
                return instance
            }
        }

    }

}