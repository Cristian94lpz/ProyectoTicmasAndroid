package com.app1.comparacionstring

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app1.comparacionstring.model.Comparacion

class MainViewModel: ViewModel() {

    private var texto1 = MutableLiveData<Comparacion>() //Dejo parentesis vacio, no quiero crear objeto Comparacion todavia
    val texto : LiveData<Comparacion> get() = texto1 // LiveData es clase padre de MutableLiveData

    private  var  text1:String = ""
    private  var text2:String = ""

    fun setText(t:String,n:Int){
        when(n){
            1 -> text1 = t
            2 -> text2 = t
        }

       // Log.d("text1", text1 )
      //  Log.d("text2", text2)
    }


    fun compara(){
       // Log.d("scopeCompara",text1+" "+ text2)
      //  Log.d("comparacion", texto1.value?.resultado.toString())
        if(text1 == "" || text2 == "") {
            texto1.value = Comparacion(null)

        }else if (text1 == text2) {
                texto1.value = Comparacion(true)

        }else{
                texto1.value = Comparacion(false)

        }

    }

    //Funciones para probar cambio variables privadas
    fun getText1():String{
        return text1
    }
    fun getText2():String{
        return text2
    }

}