package br.com.digitalhouse.appmytasks.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.digitalhouse.appmytasks.model.Tarefa;

//TODO: Implementação da anotação referente ao Database
@androidx.room.Database(entities = {Tarefa.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase{

    //TODO: Realizar a implementação da classe database
    //Você pode utilizar o exemplo da útlima aula sobre Android Room
    private static volatile Database INSTANCE;

    public abstract TarefaDao tarefaDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "pessoas_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
