package com.example.registroalumnosql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityLista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        val rview=findViewById<RecyclerView>(R.id.lista_rv)
        val adapter=AdapterListaEstudiantes(this)
        rview.adapter=adapter
        rview.layoutManager=LinearLayoutManager(this)
        adapter.setStudentList(ListaEstudiantes())
    }

    fun ListaEstudiantes():List<Estudiante>{
        var students= ArrayList<Estudiante>()
        val database=adminBD(this)
        val cursor=database.Consulta("SELECT noControl,nomEst,carrera,edadEst FROM Estudiante")
        if(cursor!!.moveToFirst())do{
            val stu=Estudiante(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3))
            students.add(stu)
        }
        while(cursor!!.moveToNext())
        cursor.close()
        return students
    }
}
