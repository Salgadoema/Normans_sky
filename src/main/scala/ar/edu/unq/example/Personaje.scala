package ar.edu.unq.example

/**
  * Created by user on 28/08/2016.
  */
class Personaje(energia: Int, unaMochila: Mochila  )  {


  def capacidadOxigenoFinal(): Double = miTraje.capacidadFinal


  var miTraje:Traje = new Traje {override def calcularConsumoAlRecorrerKms(kilometros: Double): Unit = ???

    override var consumoPorKm: Double = _
    override var capacidadFinal: Double = _
    override var capacidadMaxima: Double = _
  }

  def caminarKms(km: Double) = {
    miTraje.calcularConsumoAlRecorrerKms(km)
  }


  def agregarTraje(unTraje: Traje) =
  {miTraje=unTraje}

  def recolectarObjeto(objetoRecolectable: ObjetoRecolectable) = {

    miMochila.guardarObjeto(objetoRecolectable)
  }

  def capacidadLibre = miMochila.capacidadLibre

  val miMochila = unaMochila
  def miEnergia = energia




}
