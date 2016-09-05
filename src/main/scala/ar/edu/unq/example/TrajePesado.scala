package ar.edu.unq.example

/**
  * Created by damian on 02/09/16.
  */
class TrajePesado extends Traje{

  var oxigenoDisponible = 4000

  def controlarPresionOxigeno: Unit = {
    if(oxigenoDisponible >= 4000)
        oxigenoDisponible = 4000
  }

  def reacrgarOxigeno: Unit ={
    oxigenoDisponible = oxigenoDisponible + 10
    controlarPresionOxigeno
  }

  def caminar(distancia: Int): Unit={
    oxigenoDisponible = oxigenoDisponible - (distancia * 20 / 100)
    reacrgarOxigeno

  }

}
