package ar.edu.unq.example.mochilas

/**
  *
  */
trait Rigida extends Mochila {

  var porcDeProteccion: Int

  def getPorcDeProteccion = porcDeProteccion

  override def proteccionAlGolpeDe(golpe:Int): Int =  golpe*getPorcDeProteccion/100

}
