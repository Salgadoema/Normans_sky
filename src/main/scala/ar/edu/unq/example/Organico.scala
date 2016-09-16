package ar.edu.unq.example

/**
  *
  */
trait Organico extends ObjetoRecolectable{

  def setearPorcentajeDeAgua(porcAgua: Int)= porcentajeDeAgua= porcAgua

  override def volumenDeshidratado(): Int = (super.obtenerVolumen()*(100-porcentajeDeAgua)/100)

}
