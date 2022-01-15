package com.javidev.coffes.data

import androidx.compose.ui.graphics.Color
import com.javidev.coffes.R
import com.javidev.coffes.ui.theme.surfaceCardBlue
import com.javidev.coffes.ui.theme.surfaceCardGreen

enum class Product(val origin:String) {

    COL("COLOMBIA"),
    BRA("BRASIL"),
    CRI("COSTA RICA"),
    NIC("NICARAGUA");

    fun getBackgroundImage(): Int{
        return when(this){
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.ri
            NIC -> R.drawable.ni
        }
    }

    fun getFlag(): Int{
        return when(this){
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }
    fun getSurface(): Color {
        return when(this){
            COL,BRA -> surfaceCardBlue
            CRI,NIC -> surfaceCardGreen
        }
    }

    fun getId():Int{
        return  when(this){
            COL -> 0
            BRA -> 1
            CRI -> 2
            NIC -> 3
        }
    }

    fun getPrecio(): Double {
        return  when(this){
            COL -> 38.5
            BRA -> 35.9
            CRI -> 25.0
            NIC -> 27.5
        }
    }


    fun getMoneda(): String{
        return when(this){
            COL -> "$"
            BRA -> "R$"
            CRI -> "Ç"
            NIC -> "C$"
        }
    }


    fun getSummary():String{
        return when(this){
            COL -> "Elaborado a mano desde 1912"
            BRA -> "100% Ecologico "
            CRI -> "Numero uno en ventas en todo el mundo"
            NIC ->  "De los mejores campos el mejor cafe!!!"
        }
    }

    fun getTexto():String{
        return when(this){
            COL -> "Lorem Colombia es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen."
            BRA -> "Lorem Brasil es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen."
            CRI -> "Lorem Costa rica es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen."
            NIC -> "Lorem Nicaragua es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen."
        }
    }


    fun getListCitys(): List<String>{
        val listCitys = listOf(
            "Madrid: España","La habana: Cuba","Cancun: Mexico","Medellin: Colombia","Buenos Aires: Argentina"
        )
        return listCitys
    }


}

