import com.zapodot.constretto.play.TaggedPropertySetConversions
import com.typesafe.config.ConfigValueFactory
import org.specs2.mutable.Specification

/**
 *
 * @author zapodot
 */
class ConfigValue2StringSpec extends Specification {

  "The configuration value 1" should {
    "equal 1" in {
      TaggedPropertySetConversions.ConfigValue2String(ConfigValueFactory.fromAnyRef(1)) mustEqual "1"
    }
  }

  "The configuration value \"a string\"" should {
    "equal \"a string\"" in {
      TaggedPropertySetConversions.ConfigValue2String(ConfigValueFactory.fromAnyRef("a string")) mustEqual "a string"
    }
  }
  "The configuration value 1.0" should {
    "equal 1.0" in {
      TaggedPropertySetConversions.ConfigValue2String(ConfigValueFactory.fromAnyRef(1.0d)) mustEqual "1.0"
    }
  }

}
