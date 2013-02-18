package com.zapodot.store;

import com.zapodot.constretto.play.TaggedPropertySetConversions;
import org.constretto.ConfigurationStore;
import org.constretto.model.TaggedPropertySet;
import play.api.Configuration;

import java.util.Collection;

/**
 * Constretto ConfigurationStore wrapping Play2's Configuration class
 */
public class PlayConfigurationStore implements ConfigurationStore {

    private Configuration configuration;

    private PlayConfigurationStore(Configuration configuration) {
        this.configuration = configuration;
    }

    public static PlayConfigurationStore create(final Configuration configuration) {
        return new PlayConfigurationStore(configuration);
    }

    @Override
    public Collection<TaggedPropertySet> parseConfiguration() {
        return TaggedPropertySetConversions.convertToTaggedPropertySet(configuration.entrySet());

    }
}
