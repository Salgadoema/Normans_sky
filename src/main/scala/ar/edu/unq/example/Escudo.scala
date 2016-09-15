package ar.edu.unq.example

/**
  * Created by damian on 08/09/16.
  */
class Escudo(proteccion_ :Int) {

  def reacciona(danho: Int, atacante: Personaje, defensor: Personaje): Personaje =
     atacante


  def porcentajeDeReflexion(porcentaje: Int): Int = {0}


  var proteccion = proteccion_

  def escudo(valor: Int): Unit = {
    proteccion = valor
  }

  def proteccionEscudo(unDanho : Int) : Int = {
    if (proteccion >= unDanho) {
      proteccion = proteccion - unDanho
      0
    }
    else{
      var ret = proteccion - unDanho
      proteccion = 0
      ret
    }

  }


   def recargar(km: Int): Unit = {}

}