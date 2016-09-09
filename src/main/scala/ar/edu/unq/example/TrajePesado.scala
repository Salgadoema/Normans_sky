package ar.edu.unq.example

class TrajePesado extends Traje{

  override var oxigenoDisponible = 4000
  override var consumoPorKm: Int = 20
  override var capacidadMaxima: Int = 4000

  def controlarPresionOxigeno(): Unit = {
    if (oxigenoDisponible >= capacidadMaxima)
        oxigenoDisponible = capacidadMaxima
  }

  def reacrgarOxigeno(): Unit ={
    oxigenoDisponible = oxigenoDisponible + 10
    controlarPresionOxigeno()
  }

  override def caminar(distancia: Int): Unit={
    oxigenoDisponible = oxigenoDisponible - (distancia * consumoPorKm / 100)
    reacrgarOxigeno()
  }


}
