package ar.edu.unq.example

/**
  *
  */

class TrajePesado extends Traje{

  override var oxigenoDisponible = 4000
  override var consumoPorKm: Int = 20
  override var capacidadMaxima: Int = 4000

  def controlarPresionOxigeno(): Unit =
    if (oxigenoDisponible >= capacidadMaxima) oxigenoDisponible = capacidadMaxima

  def recargarOxigeno(): Unit ={
   oxigenoDisponible = oxigenoDisponible + 10
   controlarPresionOxigeno()
  }

  override def caminarDist(distancia :Int) :Unit ={
    oxigenoDisponible = oxigenoDisponible - (distancia * consumoPorKm / 100)
    recargarOxigeno()
  }

  override def caminarConPeso(distancia :Int , peso :Int) :Unit ={
    caminarDist(distancia)
    oxigenoDisponible = oxigenoDisponible - distancia*peso / Math.sqrt(distancia).toInt
    recargarOxigeno()
  }

}
