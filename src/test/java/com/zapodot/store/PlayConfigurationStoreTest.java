package com.zapodot.store;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import org.constretto.model.TaggedPropertySet;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * @author sondre
 */
public class PlayConfigurationStoreTest {

    public static final String CONFIGURATION_PROPERTY = "play.string";

    @Test
    public void testCreate() throws Exception {
        Map<String, Object> configurationSettings = Maps.newHashMap();
        configurationSettings.put(CONFIGURATION_PROPERTY, "String");
        final FakeApplication fakeApplication = Helpers.fakeApplication(configurationSettings);
        Helpers.start(fakeApplication);
        final PlayConfigurationStore store = PlayConfigurationStore.create(fakeApplication.getWrappedApplication().configuration());
        final Collection<TaggedPropertySet> taggedPropertySets = store.parseConfiguration();
        final TaggedPropertySet taggedPropertySet = Iterators.get(taggedPropertySets.iterator(), 0);
        assertTrue(taggedPropertySet.getProperties().containsKey(CONFIGURATION_PROPERTY));
    }

}
