package ar.edu.unq.example

/**
  * Created by damian on 08/09/16.
  */
trait Escudo extends Personaje{

  var proteccion :Int

  def Escudo(valor: Int): Unit = {
    proteccion = valor
  }

  override def proteccionEscudo(unDanho : Int) : Int = {
    if (0 <= proteccion - unDanho) {
      proteccion = proteccion - unDanho
      proteccion
    }
    else{
      proteccion = proteccion - unDanho
      0
    }

  }
}
