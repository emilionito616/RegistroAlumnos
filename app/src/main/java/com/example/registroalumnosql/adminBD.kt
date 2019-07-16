package com.example.registroalumnosql

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class adminBD (context: Context) :SQLiteOpenHelper(context, DATABASE, null, 1)
{
    companion object
    {
        val DATABASE="Estudiantes"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
                "Create Table Estudiante(" +
                        "noControl text primary key,"+
                        "nomEst text, "+
                        "carrera text, "+
                        "edadEst Integer)"
        )
    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun Consulta(select: String):Cursor? {
        try
        {
            val db = this.readableDatabase
            return db.rawQuery(select,null)
        }
        catch (ex:Exception)
        {
            return null
        }
    }
    fun Ejecuta(sentencia:String):Int {
        try
        {
            val db=this.writableDatabase// se abre base datos en base modo lectura
            db.execSQL(sentencia)
            db.close()
            return  1
        }
        catch (ex: Exception)
        {
            return 0
        }
    }


}