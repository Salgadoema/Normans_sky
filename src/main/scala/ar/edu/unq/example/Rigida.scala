package ar.edu.unq.example

/**
  * Created by user on 01/09/2016.
  */
trait Rigida extends Mochila {

  var pocDeProteccion:Int

  def getPorcDeProteccion = pocDeProteccion

  override def proteccionAlGolpeDe(golpe:Int): Int = {
    golpe*getPorcDeProteccion/100
  }

}
