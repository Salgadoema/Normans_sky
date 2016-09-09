package ar.edu.unq.example

/**
  * Created by damian on 02/09/16.
  */
class TrajeLiviano extends Traje{

  var oxigenoDisponible : Int = 1500

  def caminar(distancia : Int): Unit = {
    if (distancia <= 67) oxigenoDisponible = oxigenoDisponible - (distancia * 15 / 100)
      else oxigenoDisponible = oxigenoDisponible -10
  * Created by user on 02/09/2016.
  */
class TrajeLiviano extends Traje {

  override var capacidadMaxima: Double= 1500
  var capacidadFinal = capacidadMaxima
  var consumoPorKm=15.0


  def calcularConsumoAlRecorrerKms(km: Double): Unit = {
    if((consumoRecorrido(km))<10) capacidadFinal=capacidadFinal-consumoRecorrido(km)
    else capacidadFinal=capacidadFinal-10
  }

  def consumoRecorrido(km:Double): Double ={
    consumoPorKm*km/100
  }

}
