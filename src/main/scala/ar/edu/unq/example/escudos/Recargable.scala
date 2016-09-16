package ar.edu.unq.example.escudos

/**
  *
  */
trait Recargable extends Escudo {

  override def recargar(km: Int): Unit =  proteccion = proteccion + 10 * km

}
