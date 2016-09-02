package ar.edu.unq.example

/**
  * Created by user on 02/09/2016.
  */
trait SemiRigida extends Mochila {

  var constDeAbsorbcion : Int

  override def proteccionAlGolpeDe(golpe: Int): Int = {
    golpe - constDeAbsorbcion
  }
}
