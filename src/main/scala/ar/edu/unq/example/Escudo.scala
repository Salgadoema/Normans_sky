package ar.edu.unq.example

/**
  *
  */
class Escudo(proteccion_ :Int) {


  var proteccion = proteccion_

  def reacciona(danho: Int, atacante: Personaje, defensor: Personaje): Personaje =
     atacante

  def recargar(km: Int): Unit = {}

  def porcentajeDeReflexion(porcentaje: Int): Int = {0}

  def escudo(valor: Int): Unit = {
    proteccion = valor
  }

  def proteccionEscudoAlRecibirDanhoDe(unDanho : Int) : Int = {
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
}