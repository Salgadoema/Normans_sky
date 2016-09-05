package ar.edu.unq.example

/**
  * Created by damian on 02/09/16.
  */
trait SemiRigida extends  Mochila{

  var constDeAbsorbcion : Int

  override def proteccionAlGolpeDe(golpe: Int): Int = {
     golpe - constDeAbsorbcion
  }

}
