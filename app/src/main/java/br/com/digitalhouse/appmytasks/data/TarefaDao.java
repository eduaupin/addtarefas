package br.com.digitalhouse.appmytasks.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.Tarefa;
import io.reactivex.Observable;

//TODO: Implementar a anotação referente ao DAO
@Dao
public interface TarefaDao {

   //TODO: Implementar todos os métodos de consulta
    // O app precisará de:
    // - Inserção de dados
    //- Consulta de todos os dados
    // - Consulta contendo um limite de 5 dados em ordem decrescente
    @Insert
    void insereTarefa(Tarefa tarefa);

    @Query("SELECT * FROM tarefas")
    Observable<List<Tarefa>> getAllTarefas();

    @Query("SELECT * FROM tarefas ORDER BY id DESC LIMIT 5")
    Observable<List<Tarefa>> todasTarefas();


}
