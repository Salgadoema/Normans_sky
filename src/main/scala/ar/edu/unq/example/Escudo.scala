package ar.edu.unq.example

/**
  * Created by damian on 08/09/16.
  */
class Escudo(proteccion_ :Int) {

  def reacciona(danho: Int, atacante: Personaje): Personaje =
    return atacante


  def porcentajeDeReflexion(porcentaje: Int): Int = {0}


  var proteccion = proteccion_

  def escudo(valor: Int): Unit = {
    proteccion = valor
  }

  def proteccionEscudo(unDanho : Int) : Int = {
    if (0 <= proteccion - unDanho) {
      proteccion = proteccion - unDanho
      proteccion
    }
    else{
      proteccion =0
      0
    }

  }


   def recargar(km: Int): Unit = {}

}