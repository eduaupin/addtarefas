package br.com.digitalhouse.appmytasks.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//TODO: Implementar a anotação necessária para entidade e seus campos
@Entity(tableName = "tarefas")
public class Tarefa implements Parcelable  {

   //TODO: Implementar os atributos necessários para a classe modelo
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nomeTarefa")
    private String nomeTarefa;

    @ColumnInfo(name = "descTarefa")
    private String descTarefa;

    public Tarefa(String nomeTarefa, String descTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descTarefa = descTarefa;
    }

    protected Tarefa(Parcel in) {
        nomeTarefa = in.readString();
        descTarefa = in.readString();
    }

    public static final Creator<Tarefa> CREATOR = new Creator<Tarefa>() {
        @Override
        public Tarefa createFromParcel(Parcel in) {
            return new Tarefa(in);
        }

        @Override
        public Tarefa[] newArray(int size) {
            return new Tarefa[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescTarefa() {
        return descTarefa;
    }

    public void setDescTarefa(String descTarefa) {
        this.descTarefa = descTarefa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeTarefa);
        dest.writeString(descTarefa);
    }
}
