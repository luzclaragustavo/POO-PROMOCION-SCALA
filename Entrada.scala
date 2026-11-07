abstract class Entrada(val pelicula: String, val butaca: String, val precioBase: Double):
  require(precioBase > 0, "El precio base tiene que ser positivo")

  // abstracto
  def precio: Double

  def descripcion: String = s"$pelicula, butaca $butaca: $$${precio}"

class Entrada2D(pelicula: String, butaca: String, precioBase: Double)
    extends Entrada(pelicula, butaca, precioBase):
  def precio: Double = precioBase

class Entrada3D(pelicula: String, butaca: String, precioBase: Double)
    extends Entrada(pelicula, butaca, precioBase):
  private val recargoAnteojos = 1500.0
  def precio: Double = precioBase + recargoAnteojos
  override def descripcion: String = super.descripcion + " (incluye anteojos 3D)"

// hereda y mezcla un trait
class EntradaVIP(pelicula: String, butaca: String, precioBase: Double, val conCena: Boolean)
    extends Entrada(pelicula, butaca, precioBase) with Reembolsable:
  def precio: Double = precioBase * 1.5 + (if conCena then 8000.0 else 0.0)
  def montoReembolso: Double = precio

// Factory
object Entrada:
  def crear(tipo: String, pelicula: String, butaca: String, precioBase: Double): Entrada =
    tipo match
      case "2D"  => Entrada2D(pelicula, butaca, precioBase)
      case "3D"  => Entrada3D(pelicula, butaca, precioBase)
      case "VIP" => EntradaVIP(pelicula, butaca, precioBase, conCena = false)
      case otro  => throw IllegalArgumentException(s"Tipo de entrada desconocido: $otro")
