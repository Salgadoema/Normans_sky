package ar.edu.unq.example.mochilas

/**
  *
  */
trait Propulsora extends Mochila {

  var combustible: Int = 4000
  var altura : Int=0

  def propulsarXTiempo(tiempo:Int): Unit = if(hayCombustibleParaElvuelo(tiempo:Int)) propulsar(tiempo)

  def propulsar(tiempo :Int):Unit= {
    consumoPorPropulsion(tiempo)
    posicionEnEjeZ(tiempo)
  }

  def hayCombustibleParaElvuelo(tiempo:Int): Boolean =  combustible >= tiempo * pesoTotal

  def consumoPorPropulsion(tiempo:Int): Int ={
      combustible = combustible - tiempo * pesoTotal
      combustible
  }

  def posicionEnEjeZ(tiempo: Int) : Int = {
    altura=altura+ tiempo /2
    altura
  }
}
