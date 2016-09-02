package ar.edu.unq.example

/**
  * Created by user on 01/09/2016.
  */
trait Organico extends ObjetoRecolectable{

  def setearPorcentajeDeAgua(porcAgua: Int)= porcentajeDeAgua= porcAgua

  override def volumenDeshidratado(): Int = (super.obtenerVolumen()*(100-porcentajeDeAgua)/100)

}
