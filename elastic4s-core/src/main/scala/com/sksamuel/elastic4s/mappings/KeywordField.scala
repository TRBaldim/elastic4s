package com.sksamuel.elastic4s.mappings

import com.sksamuel.exts.OptionImplicits._

case class KeywordField(name: String,
                        analysis: Analysis = Analysis(),
                        boost: Option[Double] = None,
                        copyTo: Seq[String] = Nil,
                        docValues: Option[Boolean] = None,
                        enabled: Option[Boolean] = None,
                        eagerGlobalOrdinals: Option[Boolean] = None,
                        fields: Seq[FieldDefinition] = Nil,
                        includeInAll: Option[Boolean] = None,
                        ignoreAbove: Option[Int] = None,
                        index: Option[String] = None,
                        indexOptions: Option[String] = None,
                        norms: Option[Boolean] = None,
                        nulls: Nulls = Nulls(),
                        searchQuoteAnalyzer: Option[String] = None,
                        similarity: Option[String] = None,
                        store: Option[Boolean] = None,
                        termVector: Option[String] = None)
    extends FieldDefinition {

  type T = KeywordField
  override def `type` = "keyword"

  override def boost(boost: Double): T          = copy(boost = boost.some)
  override def docValues(docValues: Boolean): T = copy(docValues = docValues.some)

  override def analyzer(analyzer: String): T       = copy(analysis = analysis.copy(analyzer = analyzer.some))
  override def normalizer(normalizer: String): T   = copy(analysis = analysis.copy(normalizer = normalizer.some))
  override def searchAnalyzer(analyzer: String): T = copy(analysis = analysis.copy(searchAnalyzer = analyzer.some))

  override def nullable(nullable: Boolean): T = copy(nulls = nulls.copy(nullable = nullable.some))
  override def nullValue(nullvalue: Any): T   = copy(nulls = nulls.copy(nullValue = nullvalue.some))

  override def fields(fields: Iterable[FieldDefinition]): T = copy(fields = fields.toSeq)

  override def copyTo(first: String, rest: String*): T = copyTo(first +: rest)
  override def copyTo(copyTo: Iterable[String]): T     = copy(copyTo = copyTo.toSeq)

  override def enabled(enabled: Boolean): T                = copy(enabled = enabled.some)
  def eagerGlobalOrdinals(eagerGlobalOrdinals: Boolean): T = copy(eagerGlobalOrdinals = eagerGlobalOrdinals.some)

  def similarity(similarity: String): T = copy(similarity = similarity.some)

  def ignoreAbove(ignoreAbove: Int): T                = copy(ignoreAbove = ignoreAbove.some)
  override def includeInAll(includeInAll: Boolean): T = copy(includeInAll = includeInAll.some)

  override def index(index: Boolean): T = copy(index = index.toString.some)

  override def norms(norms: Boolean): T = copy(norms = norms.some)

  override def store(b: Boolean): T = copy(store = b.some)

  override def termVector(t: String): T = copy(termVector = t.some)

  def indexOptions(indexOptions: String): T = copy(indexOptions = indexOptions.some)
}
