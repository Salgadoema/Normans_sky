package ar.edu.unq.example.trajes

/**
  *
  */
class TrajeLiviano extends Traje{

  override var oxigenoDisponible : Int = 1500
  override var consumoPorKm : Int = 15
  override var capacidadMaxima :Int = 1500

  override def caminarDist(distancia :Int) :Unit ={
    if (distancia <= 67) oxigenoDisponible = oxigenoDisponible - (distancia * consumoPorKm / 100)
    else oxigenoDisponible = oxigenoDisponible - 10
  }

  override def caminarConPeso(distancia :Int , peso :Int) :Unit =
    oxigenoDisponible = oxigenoDisponible - (distancia * peso / Math.sqrt(distancia))toInt

//tendría que haber un metodo q revise el nivel de oxigeno desp de
// caminar y que si no tiene se muera el personaje
}
