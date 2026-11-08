// Strategy
trait Promocion:
  def aplicar(precio: Double): Double

class SinPromocion extends Promocion:
  def aplicar(precio: Double): Double = precio

class MartesMitadDePrecio extends Promocion:
  def aplicar(precio: Double): Double = precio * 0.5

class DescuentoEstudiante(porcentaje: Double) extends Promocion:
  require(porcentaje > 0 && porcentaje < 100, "Porcentaje invalido")
  def aplicar(precio: Double): Double = precio * (1 - porcentaje / 100)

// Singleton
object RegistroVentas:
  private var cantidad = 0
  def registrar(): Unit = cantidad += 1
  def total: Int = cantidad

// D de SOLID
class Boleteria(private var promocion: Promocion):
  def cambiarPromocion(nueva: Promocion): Unit = promocion = nueva

  def cobrar(entrada: Entrada): Double =
    RegistroVentas.registrar()
    promocion.aplicar(entrada.precio)

  // O de SOLID
  def totalVendido(entradas: List[Entrada]): Double =
    var total = 0.0
    for e <- entradas do total += cobrar(e)
    total

  def reembolsarTodo(items: List[Reembolsable]): Double =
    var devuelto = 0.0
    for item <- items do
      if item.reembolsar() then devuelto += item.montoReembolso
    devuelto
