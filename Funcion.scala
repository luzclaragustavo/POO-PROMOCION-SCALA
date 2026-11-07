trait Funcion:
  def anuncios: List[String] = List("Bienvenidos")

trait ConPublicidad extends Funcion:
  override def anuncios: List[String] = super.anuncios :+ "Publicidad"

trait ConTrailers extends Funcion:
  override def anuncios: List[String] = super.anuncios :+ "Trailers"

// linealizacion
class FuncionEstreno extends Funcion with ConPublicidad with ConTrailers
class FuncionMatine extends Funcion with ConTrailers
