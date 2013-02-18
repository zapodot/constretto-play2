package com.zapodot.constretto.play

import com.typesafe.config.ConfigValue
import org.constretto.model.TaggedPropertySet
import com.zapodot.store.PlayConfigurationStore
import scala.collection.JavaConversions._


/**
 *
 * @author zapodot@gmail.com
 */
object TaggedPropertySetConversions {

  implicit def ConfigValue2String(value: ConfigValue): String = value.unwrapped().toString

  def convertToTaggedPropertySet(configuration: Set[(String, ConfigValue)]): java.util.List[TaggedPropertySet] = {

    val configMap: Map[String, String] = configuration.map(x => (x._1, ConfigValue2String(x._2))).toMap
    List(new TaggedPropertySet(configMap, classOf[PlayConfigurationStore]))
  }

}


