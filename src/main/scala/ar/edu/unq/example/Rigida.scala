package ar.edu.unq.example

/**
  * Created by user on 01/09/2016.
  */
trait Rigida extends Mochila {

  var porcDeProteccion: Int

  def getPorcDeProteccion = porcDeProteccion

  override def proteccionAlGolpeDe(golpe:Int): Int = {
    golpe*getPorcDeProteccion/100
  }

}
