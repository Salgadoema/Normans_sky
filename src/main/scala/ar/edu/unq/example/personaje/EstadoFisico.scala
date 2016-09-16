package ar.edu.unq.example.personaje

trait EstadoFisico extends Personaje{

  var estadoFisico :Int = 100

  override def getPoderDeAtaque: Int = {
    super.getPoderDeAtaque * estadoFisico / 100
  }

  override def caminarKms(km: Int): Unit = {
    super.caminarKms(km)
    estadoFisico = estadoFisico - km * 2
  }
}
