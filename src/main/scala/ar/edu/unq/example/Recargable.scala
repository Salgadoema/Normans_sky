package ar.edu.unq.example

/**
  * Created by damian on 09/09/16.
  */
trait Recargable extends Escudo {
  //hay que separar el metodo recargar de trajes y mochilas y
  // hacer un trait que sea recargar que reciba km y recargue


  override def recargar(km: Int): Unit = {
    proteccion = proteccion + 10 * km

  }



}
