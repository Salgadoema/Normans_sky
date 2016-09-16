package ar.edu.unq.example

/**
  *
  */
abstract class Traje {

  var consumoPorKm: Int
  var oxigenoDisponible : Int
  var capacidadMaxima :Int

  def caminar(distancia : Int, peso : Int): Unit = {
    caminarDist(distancia)
    caminarConPeso(distancia, peso)
  }

  def caminarDist(distancia :Int) :Unit ={}

  def caminarConPeso(distancia :Int , peso :Int) :Unit ={}

}
