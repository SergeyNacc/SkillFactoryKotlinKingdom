package taxes


abstract class TaxCollector : CollectTaxes

interface CollectTaxes {
    fun collect()
}