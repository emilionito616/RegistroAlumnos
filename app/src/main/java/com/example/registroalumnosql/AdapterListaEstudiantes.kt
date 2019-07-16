package com.example.registroalumnosql

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterListaEstudiantes internal  constructor(
    context:Context
): RecyclerView.Adapter<AdapterListaEstudiantes.StudentViewHolder>(){
    private val inflater:LayoutInflater= LayoutInflater.from(context)
    private var students= emptyList<Estudiante>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView=inflater.inflate(R.layout.estudiante_item,parent,false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount()=students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current=students[position]
        holder.edNombre.text=current.nombre
        holder.edControl.text=current.noControl
        holder.edCarrera.text=current.carrera
        holder.edEdad.text=current.edad
    }

    inner class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val edControl:TextView =itemView.findViewById(R.id.item_control)
        val edNombre:TextView=itemView.findViewById(R.id.item_nombres)
        val edCarrera:TextView=itemView.findViewById(R.id.item_carrera)
        val edEdad:TextView=itemView.findViewById(R.id.item_edad)
    }

    fun setStudentList(studentList: List<Estudiante>){
        this.students=studentList
        notifyDataSetChanged()
    }
}