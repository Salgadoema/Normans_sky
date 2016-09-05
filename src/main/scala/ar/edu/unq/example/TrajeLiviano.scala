package ar.edu.unq.example

/**
  * Created by damian on 02/09/16.
  */
class TrajeLiviano extends Traje{

  var oxigenoDisponible : Int = 1500

  def caminar(distancia : Int): Unit = {
    if (distancia <= 67) oxigenoDisponible = oxigenoDisponible - (distancia * 15 / 100)
      else oxigenoDisponible = oxigenoDisponible -10
  }

}
