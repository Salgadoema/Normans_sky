package ar.edu.unq.example

/**
  * Created by user on 02/09/2016.
  */
class TrajePesado extends Traje{
  override var capacidadMaxima: Double = 4000

  def calcularConsumoAlRecorrerKms(km: Double): Unit = {
    capacidadFinal=(capacidadFinal-consumoRecorrido(km))+10
  }

  def consumoRecorrido(km:Double): Double ={
    consumoPorKm*km/100
  }

  override var capacidadFinal: Double = capacidadMaxima
  override var consumoPorKm: Double = 20
}
