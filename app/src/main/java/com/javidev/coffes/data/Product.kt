package com.javidev.coffes.data

import androidx.compose.ui.graphics.Color
import com.javidev.coffes.R
import com.javidev.coffes.ui.theme.surfaceCardBlue
import com.javidev.coffes.ui.theme.surfaceCardGreen

enum class Origen(val origin:String) {

    COL("COLOMBIA"),
    BRA("BRASIL"),
    CRI("RIO"),
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


}