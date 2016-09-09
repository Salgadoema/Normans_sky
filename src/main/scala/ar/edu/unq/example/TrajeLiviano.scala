package ar.edu.unq.example

/**
  * Created by damian on 02/09/16.
  */
class TrajeLiviano extends Traje{

  override var oxigenoDisponible : Int = 1500
  override var consumoPorKm : Int = 15
  override var capacidadMaxima :Int = 1500

  override def caminar(distancia : Int): Unit = {
    if (distancia <= 67) oxigenoDisponible = oxigenoDisponible - (distancia * consumoPorKm / 100)
    else oxigenoDisponible = oxigenoDisponible - 10
  }

}
