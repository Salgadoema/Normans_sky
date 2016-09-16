package ar.edu.unq.example


trait Duplicador extends Personaje{

  def duplicar(valor : Int) : Int = {
    valor * 2
  }

  override def getPoderDeAtaque: Int = {
    duplicar(super.getPoderDeAtaque)
  }
}
